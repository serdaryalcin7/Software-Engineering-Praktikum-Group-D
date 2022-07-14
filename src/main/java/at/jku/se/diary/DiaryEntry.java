package at.jku.se.diary;


import at.jku.se.diary.CategoryEntry;

import java.time.LocalDate;
import java.util.ArrayList;

public class DiaryEntry {

    private String title;
    private String location;
    private LocalDate date;
    private String text;

    private ArrayList<CategoryEntry> categoryEntries;

    private String fotopath1;
    private String fotopath2;
    private String fotopath3;

    public DiaryEntry() {  }

    public DiaryEntry(String title, String location, LocalDate date, String text, ArrayList<CategoryEntry> categoryEntries) {

        this.title = title;
        this.location = location;
        this.date = date;
        this.text = text;
        this.categoryEntries = categoryEntries;

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

    public ArrayList<CategoryEntry> getCategoryEntries() {
        return categoryEntries;
    }

    public void setCategoryEntries(ArrayList<CategoryEntry> categoryEntries) {
        this.categoryEntries = categoryEntries;
    }

    public String getFotopath1() {
        return fotopath1;
    }

    public void setFotopath1(String fotopath1) {
        this.fotopath1 = fotopath1;
    }

    public String getFotopath2() {
        return fotopath2;
    }

    public void setFotopath2(String fotopath2) {
        this.fotopath2 = fotopath2;
    }

    public String getFotopath3() {
        return fotopath3;
    }

    public void setFotopath3(String fotopath3) {
        this.fotopath3 = fotopath3;
    }

    public DiaryEntry createNewEntry(String title, String location, LocalDate date, String text, ArrayList<CategoryEntry> categoryEntries, String fotopath1, String fotopath2, String fotopath3){

        DiaryEntry diaryEntry = new DiaryEntry();

        diaryEntry.setTitle(title);
        diaryEntry.setLocation(location);
        diaryEntry.setDate(date);
        diaryEntry.setText(text);
        diaryEntry.setCategoryEntries(categoryEntries);
        diaryEntry.setFotopath1(fotopath1);
        diaryEntry.setFotopath2(fotopath2);
        diaryEntry.setFotopath3(fotopath3);

        return diaryEntry;

    }

    public boolean categoryFilter(ArrayList<CategoryEntry> categoryEntries, String searchValue){
        for (CategoryEntry category: categoryEntries) {
            if (category.getCategory().equalsIgnoreCase(searchValue)){
                return true;
            }
        }
        return false;
    }

    public boolean descriptionFilter(ArrayList<CategoryEntry> categoryEntries, String searchValue){
        for (CategoryEntry description: categoryEntries) {
            if (description.getDescription().equalsIgnoreCase(searchValue)){
                return true;
            }
        }
        return false;
    }

    public boolean starFilter(ArrayList<CategoryEntry> categoryEntries, String searchValue){
        for (CategoryEntry star: categoryEntries) {
            if (star.getStar().equals(searchValue)){
                return true;
            }
        }
        return false;
    }






}