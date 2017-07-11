package org.openstreetmap.sotmlatam.fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.openstreetmap.sotmlatam.R;
import org.openstreetmap.sotmlatam.db.MyPlacesHelper;
import org.openstreetmap.sotmlatam.db.ProgramEvent;
import org.openstreetmap.sotmlatam.utils.BaseOSMCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class ProgramRecyclerViewAdapter extends RecyclerView.Adapter<ProgramRecyclerViewAdapter.ViewHolder> {

    private List<ProgramEvent> mValues;
    private final Activity context;
    MyPlacesHelper helper;

    public ProgramRecyclerViewAdapter(List<ProgramEvent> items, Activity context) {
        mValues = items;
        this.context = context;
        helper = new MyPlacesHelper(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_agenda_drawable_event, parent, false);
        return new ViewHolder(view);
    }
private void setFavorite(ViewHolder holder){
    Bitmap icon;
    if(holder.mItem.isFavorite()) {
        icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ic_heart);
    }else{
         icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ic_heart_outline);
    }
    holder.eye.setImageBitmap(icon);
}
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        if (!holder.mItem.getDescription().isEmpty()) {
            final TextView message = new TextView(context);
            // i.e.: R.string.dialog_message =>
            // "Test this dialog following the link to dtmilano.blogspot.com"
            final SpannableString s =
                    new SpannableString(holder.mItem.getDescription());
            Linkify.addLinks(s, Linkify.WEB_URLS);
            message.setText(s);
            message.setPadding(30,10,30,10);
            message.setMovementMethod(LinkMovementMethod.getInstance());
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                  //  builder.setMessage(holder.mItem.getDescription())
                    builder.setView(message)
                            .setPositiveButton(R.string.okbutton, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                    builder.setTitle(holder.mItem.getTitle());
                    builder.create().show();
                }
            };
            holder.mView.setOnClickListener(clickListener);
            holder.txtTitle.setOnClickListener(clickListener);
            holder.txtDescription.setOnClickListener(clickListener);
            holder.eye.setVisibility(View.VISIBLE);
           setFavorite(holder);
            holder.eye.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.mItem.setFavorite(!holder.mItem.isFavorite());
                    helper.updateFavorite(holder.mItem);
                    setFavorite(holder);
                }
            });

        } else {
            holder.eye.setVisibility(View.GONE);
        }
        if (holder.mItem.getAuditorium().isEmpty())
            holder.txtLocation.setText("");
        else {
            holder.txtLocation.setText(holder.mItem.getAuditorium());
        }
        if (holder.mItem.getDescription().isEmpty()) {
            holder.txtDescription.setText("");
        } else {
            holder.txtDescription.setText(holder.mItem.getAuthor());
        }
        holder.txtTitle.setText(holder.mItem.getTitle());
        SimpleDateFormat timeFormat = new SimpleDateFormat("H:mm");
        holder.txtHour.setText(timeFormat.format(holder.mItem.getEventDate()));

    }



    @Override
    public long getItemId(int position) {
        super.getItemId(position);
        return mValues.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setmValues(List<ProgramEvent> mValues1) {
        //this.mValues = mValues;
        this.mValues.clear();
        this.mValues.addAll(mValues1);
        notifyDataSetChanged();
    }

    public List<ProgramEvent> getmValues() {
        return mValues;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout mView;
        TextView txtTitle, txtLocation, txtDescription, txtHeader,txtHour;
        ImageView eye;
        public ProgramEvent mItem;

        public ViewHolder(View view) {
            super(view);
            mView = (LinearLayout) view.findViewById(R.id.view_agenda_event_description_container);
            txtTitle = (TextView) view.findViewById(R.id.view_agenda_event_title);
            txtLocation = (TextView) view.findViewById(R.id.view_agenda_event_location);
            txtDescription = (TextView) view.findViewById(R.id.view_agenda_event_description);
            eye = (ImageView) view.findViewById(R.id.eye);
            txtHeader = (TextView) view.findViewById(R.id.day);
            txtHour = (TextView)view.findViewById(R.id.day);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.getTitle() + "'";
        }
    }
}
