package at.jku.se.diary;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * DiaryEntry contains title, location, date, test, tags and pictures
 * Constructor + Getters and Setters for a new Entry
 * Also the filter function happens in this class
 * @author Team-D
 */
public class DiaryEntry {

    private String title;
    private String location;
    private LocalDate date;
    private String text;

    private ArrayList<CategoryEntry> categoryEntries;

    private String fotopath1;
    private String fotopath2;
    private String fotopath3;

    /**
     * Object constructor
     */
    public DiaryEntry() {}

    /**
     * Getter method for Title
     * @return Title of the Diary Entry
     */
    public String getTitle() {
        return title;
    }

    /**
     * Changes the Title of this Diary Entry
     * @param title The new value for this Diary Entry
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Getter method for Location
     * @return Location of the Diary Entry
     */
    public String getLocation() {
        return location;
    }

    /**
     * Changes the Location of this Diary Entry
     * @param location The new value for this Diary Entry
     */
    public void setLocation(String location) { this.location = location; }

    /**
     * Getter method for Date
     * @return Date of the Diary Entry
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Changes the Date of this Diary Entry
     * @param date The new value for this Diary Entry
     */
    public void setDate(LocalDate date) { this.date = date;}

    /**
     * Getter method for Text
     * @return Text of the Diary Entry
     */
    public String getText() {
        return text;
    }

    /**
     * Changes the Text of this Diary Entry
     * @param text The new value for this Diary Entry
     */
    public void setText(String text) { this.text = text; }

    /**
     * Getter method for CategoryEntries
     * @return the CategoryEntries
     */
    public ArrayList<CategoryEntry> getCategoryEntries() {
        return categoryEntries;
    }

    /**
     * @param categoryEntries to set
     */
    public void setCategoryEntries(ArrayList<CategoryEntry> categoryEntries) { this.categoryEntries = categoryEntries; }

    /**
     *  Getter method for Fotopath
     * @return first image path
     */
    public String getFotopath1() {
        return fotopath1;
    }

    /**
     * @param fotopath1 to set first image path
     */
    public void setFotopath1(String fotopath1) {
        this.fotopath1 = fotopath1;
    }

    /**
     * Getter method for Fotopath
     * @return second image path
     */
    public String getFotopath2() {
        return fotopath2;
    }

    /**
     * @param fotopath2 to set second image path
     */
    public void setFotopath2(String fotopath2) {
        this.fotopath2 = fotopath2;
    }

    /**
     * Getter method for Fotopath
     * @return third image path
     */
    public String getFotopath3() {
        return fotopath3;
    }

    /**
     * @param fotopath3 to set third image path
     */
    public void setFotopath3(String fotopath3) {
        this.fotopath3 = fotopath3;
    }

    /**
     * This method will create a new diary entry
     * @param title
     * @param location
     * @param date
     * @param text
     * @param categoryEntries
     * @param fotopath1
     * @param fotopath2
     * @param  fotopath3
     * @return diaryEntry
     * @throws EntryNullException Title, Location, Date, Text can not be null
     */
    public DiaryEntry createNewEntry(String title, String location, LocalDate date, String text, ArrayList<CategoryEntry> categoryEntries, String fotopath1, String fotopath2, String fotopath3) throws EntryNullException {

        if(title == "" || location == "" || date == null || text == "") {
           throw new EntryNullException("Please fill out every field!");
        }

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

    /**
     * This method will verify if the given stored text can find the corresponding category
     * @param categoryEntries
     * @param searchValue
     * @return true/false
     */
    public boolean categoryFilter(ArrayList<CategoryEntry> categoryEntries, String searchValue){
        for (CategoryEntry category: categoryEntries) {
            if (category.getCategory().equalsIgnoreCase(searchValue)){
                return true;
            }
        }
        return false;
    }


    /**
     * This method will verify if the given stored text can find the corresponding description
     * @param categoryEntries
     * @param searchValue
     * @return true/false
     */
    public boolean descriptionFilter(ArrayList<CategoryEntry> categoryEntries, String searchValue){
        for (CategoryEntry description: categoryEntries) {
            if (description.getDescription().equalsIgnoreCase(searchValue)){
                return true;
            }
        }
        return false;
    }


    /**
     * This method will verify if the given stored text can find the corresponding star rating
     * @param categoryEntries
     * @param searchValue
     * @return true/false
     */
    public boolean starFilter(ArrayList<CategoryEntry> categoryEntries, String searchValue){
        for (CategoryEntry star: categoryEntries) {
            if (star.getStar().equals(searchValue)){
                return true;
            }
        }
        return false;
    }
}