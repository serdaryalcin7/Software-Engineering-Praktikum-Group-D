package sample.diaryfx;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class DiaryEntry {

        private StringProperty title;
        private StringProperty location;
        private ObjectProperty<LocalDate> date;
        private StringProperty text;
        private StringProperty category;
        private StringProperty star;

    public DiaryEntry(){}

        public DiaryEntry(String title, String location, LocalDate date, String text, String category, String star) {
            this.title = new SimpleStringProperty(title);
            this.location = new SimpleStringProperty(location);
            this.date = new SimpleObjectProperty<LocalDate>(date);
            this.text = new SimpleStringProperty(text);
            this.category = new SimpleStringProperty(category);
            this.star = new SimpleStringProperty(star);
        }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getStar() {
        return star.get();
    }

    public StringProperty starProperty() {
        return star;
    }

    public void setStar(String star) {
        this.star.set(star);
    }
}

