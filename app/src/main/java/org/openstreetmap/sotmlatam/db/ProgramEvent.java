package org.openstreetmap.sotmlatam.db;


import java.util.Date;

/**
 * Created by LauraAdm on 05/11/2016.
 */

public class ProgramEvent {

    private Integer id;
    private String author;
    private String title;
    private String description;
    private Date eventDate;
    private String auditorium;
    private boolean favorite;

    public ProgramEvent(Integer id, String author, String title, String description, Date eventDate, String auditorium) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.auditorium = auditorium;
        favorite = false;
    }

    public ProgramEvent(String author, String title, String description, Date eventDate, String auditorium) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.auditorium = auditorium;
        favorite = false;
    }

    public ProgramEvent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if(((ProgramEvent)o).getId()==id)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }


}
