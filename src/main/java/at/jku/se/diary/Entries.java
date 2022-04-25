package at.jku.se.diary;

public class Entries {

    private String title;
    private String date;
    private String location;
    private String text;

    private String tag;

    public Entries(String title, String date, String location, String text, String tag) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.text = text;
        this.tag = tag;
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
}