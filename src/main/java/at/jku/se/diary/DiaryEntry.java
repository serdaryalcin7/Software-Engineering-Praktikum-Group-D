package at.jku.se.diary;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class DiaryEntry {

        private String title;
        private String location;
        private LocalDate date;
        private String text;
        private String category;
        private String description;
        private String star;


    public DiaryEntry(){}

        public DiaryEntry(String title, String location, LocalDate date, String text, String category,String description, String star) {

            this.title= title;
            this.location = location;
            this.date = date;
            this.text = text;
            this.category = category;
            this.description = description;
            this.star = star;
        }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}

