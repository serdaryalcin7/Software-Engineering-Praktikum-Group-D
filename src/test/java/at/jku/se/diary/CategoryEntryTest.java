package at.jku.se.diary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Team-D
 */

class CategoryEntryTest {

    private CategoryEntry categoryEntry = new CategoryEntry();

    /**
     * class CategoryEntry: Test of getCategory method
     */
    @Test
    void getCategory() {
        categoryEntry.setCategory("Hotel");
        assertEquals(categoryEntry.getCategory(),"Hotel");
    }

    /**
     * class CategoryEntry: Test of setCategory method
     */
    @Test
    void setCategory() {
        categoryEntry.setCategory("Hotel");
        assertEquals(categoryEntry.getCategory(),"Hotel");
    }

    /**
     * class CategoryEntry: Test of getDescription method
     */
    @Test
    void getDescription() {
        categoryEntry.setDescription("Sommerhaus Hotel");
        assertEquals(categoryEntry.getDescription(),"Sommerhaus Hotel");
    }

    /**
     * class CategoryEntry: Test of setDescription method
     */
    @Test
    void setDescription() {
        categoryEntry.setDescription("Sommerhaus Hotel");
        assertEquals(categoryEntry.getDescription(),"Sommerhaus Hotel");
    }

    /**
     * class CategoryEntry: Test of getStar method
     */
    @Test
    void getStar() {
        categoryEntry.setDescription("Sommerhaus Hotel");
        assertEquals(categoryEntry.getDescription(),"Sommerhaus Hotel");
    }

    /**
     * class CategoryEntry: Test of setStar method
     */
    @Test
    void setStar() {
        categoryEntry.setStar("4");
        assertEquals(categoryEntry.getStar(),"4");
    }
}