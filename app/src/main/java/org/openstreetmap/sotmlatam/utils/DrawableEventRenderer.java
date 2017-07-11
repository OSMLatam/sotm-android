package org.openstreetmap.sotmlatam.utils;

/**
 * Created by laura on 9/7/2016.
 */
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.openstreetmap.sotmlatam.R;
import com.github.tibolte.agendacalendarview.render.EventRenderer;

public class DrawableEventRenderer extends EventRenderer<DrawableCalendarEvent> {

    // region Class - EventRenderer

    @Override
    public void render(final View view, final DrawableCalendarEvent event) {
        Log.e("pasa","pasa");
        TextView txtTitle = (TextView) view.findViewById(R.id.view_agenda_event_title);
        TextView txtLocation = (TextView) view.findViewById(R.id.view_agenda_event_location);
        TextView txtDescription = (TextView) view.findViewById(R.id.view_agenda_event_description);
        LinearLayout descriptionContainer = (LinearLayout) view.findViewById(R.id.view_agenda_event_description_container);
        descriptionContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(event.getDescription())
                        .setPositiveButton(R.string.okbutton, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create().show();

            }
        });
        descriptionContainer.setVisibility(View.VISIBLE);
        txtTitle.setTextColor(view.getResources().getColor(android.R.color.black));

        txtTitle.setText(event.getTitle());
        txtLocation.setText(event.getLocation());
        txtDescription.setText(event.getDescription());
        if (event.getLocation().length() > 0) {
            txtLocation.setText(event.getLocation());
        }

        if (event.getTitle().equals(view.getResources().getString(R.string.agenda_event_no_events))) {
            txtTitle.setTextColor(view.getResources().getColor(android.R.color.black));
        } else {
            txtTitle.setTextColor(view.getResources().getColor(R.color.blue_dark));
        }
        descriptionContainer.setBackgroundColor(event.getColor());
        txtLocation.setTextColor(view.getResources().getColor(R.color.blue_dark));
    }

    @Override
    public int getEventLayout() {
        return R.layout.view_agenda_drawable_event;
    }

    @Override
    public Class<DrawableCalendarEvent> getRenderType() {
        return DrawableCalendarEvent.class;
    }

    // endregion
}
