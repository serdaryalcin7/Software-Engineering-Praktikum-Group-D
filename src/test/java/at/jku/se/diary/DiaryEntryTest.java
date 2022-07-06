/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.jku.se.diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author reinhold
 */
class DiaryEntryTest {

    private DiaryEntry t1, t2;

    @BeforeEach
    void setUp(){
        t1 = new DiaryEntry();
        t2 = new DiaryEntry("title", "loc", LocalDate.now(), "text", "cat", "desc", "3");
    }

    @Test
    void setEntries(){
        t1.setTitle("title");
        assertEquals("title", t1.getTitle());
        t1.setLocation("loc");
        assertEquals("loc", t1.getLocation());
        t1.setDate(LocalDate.now());
        assertEquals(LocalDate.now(), LocalDate.now());
        t1.setText("text");
        assertEquals("text", t1.getText());
        t1.setCategory("cat");
        assertEquals("cat", t1.getCategory());
        t1.setDescription("desc");
        assertEquals("desc", t1.getDescription());
        t1.setStar("3");
        assertEquals("3", t1.getStar());
    }
    @Test
    void testImage1(){
    }
}