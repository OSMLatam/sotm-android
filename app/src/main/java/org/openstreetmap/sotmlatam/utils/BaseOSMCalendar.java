package org.openstreetmap.sotmlatam.utils;

import com.github.tibolte.agendacalendarview.models.BaseCalendarEvent;

import java.util.Calendar;

/**
 * Created by laura on 9/12/2016.
 */
public class BaseOSMCalendar extends BaseCalendarEvent {
    protected String author;

    public BaseOSMCalendar(long id, int color, String title, String description, String location, long dateStart, long dateEnd, int allDay, String duration) {
        super(id, color, title, description, location, dateStart, dateEnd, allDay, duration);
    }

    public BaseOSMCalendar(String title, String description, String location, int color, Calendar startTime, Calendar endTime, String author) {
        super(title, description, location, color, startTime, endTime, false);
        this.author = author;
    }

    public BaseOSMCalendar(BaseCalendarEvent calendarEvent) {
        super(calendarEvent);
    }

    public BaseOSMCalendar(String title, String description, String location, int color, Calendar startTime, Calendar endTime, boolean allDay, String author) {
        super(title, description, location, color, startTime, endTime, allDay);
        this.author = author;
    }

    public BaseOSMCalendar(Calendar day, String title) {
        super(day, title);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
