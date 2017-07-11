package org.openstreetmap.sotmlatam.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.util.Log;

import org.openstreetmap.sotmlatam.service.Receiver;

public class MyPlacesHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String EVENT_TABLE_NAME = "events";
    private static final String KEY_ID = "id";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_EVENT_DATE = "event_date";
    private static final String KEY_AUDITORIUM = "auditorium";
    private static final String KEY_FAVORITE = "favorite";


    private static final String EVENT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS  "
            + EVENT_TABLE_NAME
            + " (" +
            KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_AUTHOR
            + " TEXT, "
            + KEY_TITLE
            + " TEXT, "
            + KEY_DESCRIPTION
            + " TEXT, "
            + KEY_EVENT_DATE
            + " date, "
            + KEY_AUDITORIUM
            + " TEXT,"
            + KEY_FAVORITE
            + " INTEGER"
            + ")";

    private static final String[] COLUMNS = {KEY_ID, KEY_AUTHOR, KEY_TITLE
            , KEY_DESCRIPTION, KEY_EVENT_DATE, KEY_AUDITORIUM};
    Context c;

    public MyPlacesHelper(Context context) {
        super(context, EVENT_TABLE_NAME, null, DATABASE_VERSION);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(EVENT_TABLE_CREATE);

            new OtherData().execute();
        } finally {
            // db.setLockingEnabled(true);
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //
    }

    public Cursor searchLocationCursor(String query) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + EVENT_TABLE_NAME
                + " where " + KEY_TITLE + " like '%" + query + "%'", null);
        return cursor;
    }


    public interface LoadContentInterface {
        public void onFinishLoadContent();

        public void notificedProcessStarted();
    }


    public ProgramEvent getCurrentEvent(String currentDate, String place) {
        ProgramEvent event = new ProgramEvent();
        SimpleDateFormat formatter
                = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String query = "SELECT  * FROM "
                + EVENT_TABLE_NAME + " WHERE " + KEY_AUDITORIUM + "=? and datetime(" + KEY_EVENT_DATE + ")>=datetime(?) order by " + KEY_ID + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        String[] arg = {place, currentDate};
        try {
            Cursor cursor = db.rawQuery(query, arg);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                event.setId(cursor.getInt(0));
                event.setAuthor(cursor.getString(1));
                event.setTitle(cursor.getString(2));
                event.setDescription(cursor.getString(3));
                Date date1 = formatter.parse(cursor.getString(4));
                event.setEventDate(date1);
                event.setAuditorium(cursor.getString(5));
                event.setFavorite(cursor.getInt(6) == 1 ? true : false);
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Log.e("DB", e.getMessage());
        }
        return event;
    }

    public List<ProgramEvent> getProgramEvent(String currentDate, String place) {
        List<ProgramEvent> events = new LinkedList<ProgramEvent>();
        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String query = "SELECT  * FROM "
             + EVENT_TABLE_NAME    + " WHERE "
                + KEY_AUDITORIUM + "=? and date(" + KEY_EVENT_DATE + ")=date(?) order by "
                + KEY_ID + " ASC" ;

        SQLiteDatabase db = this.getWritableDatabase();
        String[] arg = {place, currentDate};
        Cursor cursor = db.rawQuery(query, arg );

        if (cursor.moveToFirst()) {
    do{
                try {
                    ProgramEvent t = new ProgramEvent();
                    t.setId(cursor.getInt(0));
                    t.setAuthor(cursor.getString(1));
                    t.setTitle(cursor.getString(2));
                    t.setDescription(cursor.getString(3));
                    Date date1 = sdf.parse(cursor.getString(4));
                    t.setEventDate(date1);
                    t.setAuditorium(cursor.getString(5));
                    t.setFavorite(cursor.getInt(6) == 1 ? true : false);
                    events.add(t);

                } catch (Exception e) {
                    Log.e("DATABASE", e.getMessage());
                }
            }         while (cursor.moveToNext()) ;
        }
        cursor.close();
        db.close();
        return events;
    }

    private static final int ALARM_REQUEST_CODE = 1;

    private void addAlarm(ProgramEvent event) {
        AlarmManager manager = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(c, Receiver.class);
         intent.putExtra("eventName", event.getTitle());
       // Log.e("id",""+event.getId());
        PendingIntent pIntent = PendingIntent.getBroadcast(c, event.getId(), intent, PendingIntent.FLAG_UPDATE_CURRENT );
        Calendar cal_now = Calendar.getInstance();
        cal_now.setTime(event.getEventDate());
        cal_now.add(Calendar.MINUTE, -5);
        cal_now.set(Calendar.SECOND,0);
        manager.set(AlarmManager.RTC_WAKEUP,cal_now.getTimeInMillis(),pIntent);

    }

    private void removeAlarm(ProgramEvent event) {
        AlarmManager manager = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(c, Receiver.class);
        intent.putExtra("eventName", event.getTitle());
        PendingIntent pIntent = PendingIntent.getBroadcast(c, event.getId(), intent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        manager.cancel(pIntent);
    }

    public int updateFavorite(ProgramEvent event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FAVORITE, event.isFavorite() ? String.valueOf(1) : String.valueOf(0));
        int i = db.update(EVENT_TABLE_NAME,
                values,
                KEY_ID + " = ?",
                new String[]{String.valueOf(event.getId())}); // selection
        db.close();
        if (event.isFavorite()) {
            addAlarm(event);
        } else
            removeAlarm(event);
        return i;
    }

    private class OtherData extends AsyncTask<Void, Integer, Void> {
        private static final int COL_NAME = 0;
        private static final int COL_TITLE = 1;
        private static final int COL_DESCRIPTION = 2;
        private static final int COL_EVENT_DATE = 3;
        private static final int COL_EVENT_HOUR = 4;
        private static final int COL_AUDITORIUM = 5;

        private ArrayList<ProgramEvent> parse(InputStream in) throws IOException {
            int id = 0;
            ArrayList<ProgramEvent> results = new ArrayList<ProgramEvent>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                String[] tokens = nextLine.split(";");
                if (tokens.length != 6) {
                    continue;
                }
                //Add new parsed result
                ProgramEvent current = new ProgramEvent();
                current.setId(id);
                current.setAuthor(tokens[COL_NAME]);
                current.setDescription(tokens[COL_DESCRIPTION]);
                current.setAuditorium(tokens[COL_AUDITORIUM]);
                current.setTitle(tokens[COL_TITLE]);
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                try {
                    StringBuffer buf = new StringBuffer(tokens[COL_EVENT_DATE]);
                    buf.append(" ");
                    buf.append(tokens[COL_EVENT_HOUR]);
                    Date t = formatter.parse(buf.toString());
                    current.setEventDate(t);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                results.add(current);
            }
            in.close();
            return results;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ((LoadContentInterface) MyPlacesHelper.this.c)
                    .notificedProcessStarted();
            AssetManager manager = c.getAssets();
            SQLiteDatabase db = getWritableDatabase();
            try {
                InputStream in = manager.open("myprogram.csv");
                List<ProgramEvent> events = parse(in);
                // reading cvs

                db.beginTransaction();
                String sql = "insert into "
                        + EVENT_TABLE_NAME
                        + " (" +
                        KEY_AUTHOR
                        + " , "
                        + KEY_TITLE
                        + " , "
                        + KEY_DESCRIPTION
                        + " , "
                        + KEY_EVENT_DATE
                        + " , "
                        + KEY_AUDITORIUM
                        + " , "
                        + KEY_FAVORITE
                        + ") values(?,?,?,?,?,?)";
                SQLiteStatement insert = db.compileStatement(sql);
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                for (ProgramEvent event :
                        events) {
                    insert.clearBindings();
                    insert.bindString(1, event.getAuthor());
                    insert.bindString(2, event.getTitle());
                    insert.bindString(3, event.getDescription());
                    insert.bindString(4, formatter.format(event.getEventDate()));
                    insert.bindString(5, event.getAuditorium());
                    insert.bindString(6, String.valueOf(0));
                    insert.execute();

                }
                db.setTransactionSuccessful();
                db.endTransaction();
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ((LoadContentInterface) MyPlacesHelper.this.c)
                    .onFinishLoadContent();
        }
    }

}
