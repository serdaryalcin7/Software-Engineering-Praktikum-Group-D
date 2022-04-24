package at.jku.se.diary;

import java.util.Date;

public class Entries {

    private String title;
    private String date;
    private String location;
    private String text;

    public Entries(String title, String date, String location, String text) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.text = text;
    }

    public Entries() {
        this.title = "";
        this.date ="" ;
        this.location = "";
        this.text = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
