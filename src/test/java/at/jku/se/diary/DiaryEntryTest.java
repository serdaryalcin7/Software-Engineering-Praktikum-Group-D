package at.jku.se.diary;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Team-D
 */
class DiaryEntryTest {

    private DiaryEntry diaryEntry = new DiaryEntry();
    private ArrayList<CategoryEntry> categoryEntryArrayList= new ArrayList<>();

    /**
     * class DiaryEntry: Test of getTitle method
     */
    @Test
    void getTitle() {
        diaryEntry.setTitle("travel in world!");
        assertEquals(diaryEntry.getTitle(), "travel in world!");
    }

    /**
     * class DiaryEntry: Test of setTitle method
     */
    @Test
    void setTitle() {
        diaryEntry.setTitle("travel in world!");
        assertEquals(diaryEntry.getTitle(), "travel in world!");
    }

    /**
     * class DiaryEntry: Test of getLocation method
     */
    @Test
    void getLocation() {
        diaryEntry.setLocation("Linz");
        assertEquals(diaryEntry.getLocation(), "Linz");
    }

    /**
     * class DiaryEntry: Test of setLocation method
     */
    @Test
    void setLocation() {
        diaryEntry.setLocation("Linz");
        assertEquals(diaryEntry.getLocation(), "Linz");
    }

    /**
     * class DiaryEntry: Test of getDate method
     */
    @Test
    void getDate() {
        diaryEntry.setDate(LocalDate.of(2022, 07, 23));
        assertEquals(diaryEntry.getDate(), LocalDate.of(2022, 07, 23));
    }

    /**
     * class DiaryEntry: Test of setDate method
     */
    @Test
    void setDate() {
        diaryEntry.setDate(LocalDate.of(2022, 07, 23));
        assertEquals(diaryEntry.getDate(), LocalDate.of(2022, 07, 23));
    }

    /**
     * class DiaryEntry: Test of getText method
     */
    @Test
    void getText() {
        diaryEntry.setText("Die erste Station ist Linz");
        assertEquals(diaryEntry.getText(), "Die erste Station ist Linz");
    }

    /**
     * class DiaryEntry: Test of getText method
     */
    @Test
    void setText() {
        diaryEntry.setText("Die erste Station ist Linz");
        assertEquals(diaryEntry.getText(), "Die erste Station ist Linz");
    }

    /**
     * class DiaryEntry: Test of getCategoryEntries method
     */
    @Test
    void getCategoryEntries() {
        CategoryEntry categoryEntry = new CategoryEntry("Hotel","Sommerhaus Hotel","4");
        categoryEntryArrayList.add(categoryEntry);
        diaryEntry.setCategoryEntries(categoryEntryArrayList);
        assertEquals(diaryEntry.getCategoryEntries(), categoryEntryArrayList);
    }

    /**
     * class DiaryEntry: Test of setCategoryEntries method
     */
    @Test
    void setCategoryEntries() {
        CategoryEntry categoryEntry = new CategoryEntry("Hotel","Sommerhaus Hotel","4");
        categoryEntryArrayList.add(categoryEntry);
        diaryEntry.setCategoryEntries(categoryEntryArrayList);
        assertEquals(diaryEntry.getCategoryEntries(), categoryEntryArrayList);
    }

    /**
     * class DiaryEntry: Test of getFotopath1 method
     */
    @Test
    void getFotopath1() {
        diaryEntry.setFotopath1("src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getFotopath1(), "src/main/java/at/jku/se/diary/addfoto.png");
    }

    /**
     * class DiaryEntry: Test of setFotopath1 method
     */
    @Test
    void setFotopath1() {
        diaryEntry.setFotopath1("src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getFotopath1(), "src/main/java/at/jku/se/diary/addfoto.png");
    }

    /**
     * class DiaryEntry: Test of getFotopath2 method
     */
    @Test
    void getFotopath2() {
        diaryEntry.setFotopath2("src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getFotopath2(), "src/main/java/at/jku/se/diary/addfoto.png");
    }

    /**
     * class DiaryEntry: Test of setFotopath2 method
     */
    @Test
    void setFotopath2() {
        diaryEntry.setFotopath2("src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getFotopath2(), "src/main/java/at/jku/se/diary/addfoto.png");
    }

    /**
     * class DiaryEntry: Test of getFotopath3 method
     */
    @Test
    void getFotopath3() {
        diaryEntry.setFotopath3("src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getFotopath3(), "src/main/java/at/jku/se/diary/addfoto.png");
    }

    /**
     * class DiaryEntry: Test of setFotopath3 method
     */
    @Test
    void setFotopath3() {
        diaryEntry.setFotopath3("src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getFotopath3(), "src/main/java/at/jku/se/diary/addfoto.png");
    }

    /**
     * class DiaryEntry: Test of createNewEntry method
     */
    @Test
    void createNewEntry() throws EntryNullException {
        CategoryEntry categoryEntry = new CategoryEntry("Hotel","Sommerhaus Hotel","4");
        categoryEntryArrayList.add(categoryEntry);
        diaryEntry.setCategoryEntries(categoryEntryArrayList);
        diaryEntry=diaryEntry.createNewEntry("travel in world!","Linz",LocalDate.of(2022, 07, 23),"Die erste Station ist Linz",categoryEntryArrayList,"src/main/java/at/jku/se/diary/addfoto.png","src/main/java/at/jku/se/diary/addfoto.png","src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getTitle(),"travel in world!");
        assertEquals(diaryEntry.getLocation(), "Linz");
        assertEquals(diaryEntry.getDate(), LocalDate.of(2022, 07, 23));
        assertEquals(diaryEntry.getText(), "Die erste Station ist Linz");
        assertEquals(diaryEntry.getCategoryEntries(), categoryEntryArrayList);
        assertEquals(diaryEntry.getFotopath1(), "src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getFotopath2(), "src/main/java/at/jku/se/diary/addfoto.png");
        assertEquals(diaryEntry.getFotopath3(), "src/main/java/at/jku/se/diary/addfoto.png");
    }

    /**
     * class DiaryEntry: Test of categoryFilter method
     */
    @Test
    void categoryFilter() {
        boolean category = true;
        boolean filter;

        CategoryEntry categoryEntry = new CategoryEntry("Hotel","Sommerhaus Hotel","4");
        categoryEntryArrayList.add(categoryEntry);
        diaryEntry.setCategoryEntries(categoryEntryArrayList);

        filter=diaryEntry.categoryFilter(categoryEntryArrayList,"Hotel");
        assertEquals(category,filter);
        filter=diaryEntry.categoryFilter(categoryEntryArrayList,"false");
        assertNotEquals(category,filter);
    }

    /**
     * class DiaryEntry: Test of descriptionFilter method
     */
    @Test
    void descriptionFilter() {
        boolean description = true;
        boolean filter;

        CategoryEntry categoryEntry = new CategoryEntry("Hotel","Sommerhaus Hotel","4");
        categoryEntryArrayList.add(categoryEntry);
        diaryEntry.setCategoryEntries(categoryEntryArrayList);

        filter=diaryEntry.descriptionFilter(categoryEntryArrayList,"Sommerhaus Hotel");
        assertEquals(description,filter);
        filter=diaryEntry.descriptionFilter(categoryEntryArrayList,"false");
        assertNotEquals(description,filter);
    }

    /**
     * class DiaryEntry: Test of starFilter method
     */
    @Test
    void starFilter() {
        boolean star = true;
        boolean filter;

        CategoryEntry categoryEntry = new CategoryEntry("Hotel","Sommerhaus Hotel","4");
        categoryEntryArrayList.add(categoryEntry);
        diaryEntry.setCategoryEntries(categoryEntryArrayList);

        filter=diaryEntry.starFilter(categoryEntryArrayList,"4");
        assertEquals(star,filter);
        filter=diaryEntry.starFilter(categoryEntryArrayList,"false");
        assertNotEquals(star,filter);
    }
}