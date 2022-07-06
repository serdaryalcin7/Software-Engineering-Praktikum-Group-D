/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.jku.se.diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import at.jku.se.diary.DiaryEntry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author reinhold
 */
class DiaryEntryTest {

    private DiaryEntry t1;
    private DiaryEntry t2;

    @BeforeEach
    void setUp(){

        t1 = new DiaryEntry();
        t2 = new DiaryEntry("title", "loc", LocalDate.now(), "text", "cat", "desc", "3");
    }

    @Test
    void setTitle() {

        t1.setTitle("title");
        assertEquals("title", t1.getTitle());
        assertNotEquals(t1.getTitle(), null);

    }
    @Test
    void setLocation() {

        t1.setLocation("loc");
        assertEquals("loc", t1.getLocation());
        assertNotEquals(t1.getLocation(), null);

    }
    @Test
    void setDate() {

        t1.setDate(LocalDate.now());
        assertEquals(LocalDate.now(), t1.getDate());
        assertNotEquals(t1.getDate(),null);

    }

    @Test
    void setText() {

        t1.setText("text");
        assertEquals("text", t1.getText());
        assertNotEquals(t1.getText(), null);

    }
    @Test
    void setCategory() {

        t1.setCategory("Restaurant");
        assertEquals("Restaurant", t1.getCategory());
        assertNotEquals(null,t1.getCategory());

    }
    @Test
    void setDescription() {

        t1.setDescription("desc");
        assertEquals("desc", t1.getDescription());
        assertNotEquals(t1.getDescription(), null);

    }
    @Test
    void setStar() {

        t1.setStar("3");
        assertEquals("3", t1.getStar());
        assertNotEquals(t1.getStar(), null);

    }
    @Test
    void testDescription(){

        t1.setDescription("Super cool Hotel");
        assertEquals("Super cool Hotel", t1.getDescription());
        assertNotEquals(t1.getDescription(), null);

    }
    @Test
    void testAddNewCategory() {

        t1.setText("new Category");
        t1.setCategory(t1.getText());
        assertEquals(t1.getText(),t1.getCategory());
        assertNotEquals(t1.getCategory(), null);

    }

    @Test
    void testDeleteCategory() {

        t1.setText(null);
        t1.setCategory(t1.getText());
        assertEquals(t1.getText(),t1.getCategory());
        assertNotEquals("Hotel", t1.getCategory());

    }

    @Test
    void testEditEntry() {

        t1 = new DiaryEntry("Beach Vaccation", "Antalaya", LocalDate.now(), null, "Beah", "Beach was great", "5");
        t2 = new DiaryEntry("Beach Vacation", "Antalya", LocalDate.now(), null, "Beach", "Beach was kinda sick", "4");

        assertEquals("Beach Vacation",t2.getTitle());
        assertNotEquals(t1.getTitle(),t2.getTitle());

        assertEquals("Antalya",t2.getLocation());
        assertNotEquals(t1.getLocation(),t2.getLocation());

        assertEquals("Beach",t2.getCategory());
        assertNotEquals(t1.getCategory(),t2.getCategory());

        assertEquals("Beach was kinda sick",t2.getDescription());
        assertNotEquals(t1.getDescription(),t2.getDescription());
    }
}