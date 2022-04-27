package at.jku.se.diary;




import javafx.scene.control.DatePicker;

import java.util.Date;


public class Entries {

    private String title;
    private String date;
    private String location;
    private String text;
    private String categoryText;
    private String tag;

    public Entries(String title, String date, String location, String text, String tag, String categoryText) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.text = text;
        this.tag = tag;
        this.categoryText = categoryText;
    }

    public Entries() {

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategoryText() {
        return categoryText;
    }

    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }
}