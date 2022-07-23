package at.jku.se.diary;

/**
 * This class has a constructor and generates getters and setters for the categories
 * @author Team-D
 */
public class CategoryEntry {

    private String category;
    private String description;
    private String star;

    /**
     * Object constructor
     */
    public CategoryEntry(){}

    /**
     * Object constructor
     * @param category
     * @param description
     * @param star
     */
    public CategoryEntry(String category, String description, String star) {

            this.category = category;
            this.description = description;
            this.star = star;
    }

    /**
     * Getter method for the Category
     * @return Category of the Category Entry
     */
    public String getCategory() {
        return category;
    }

    /**
     * Changes the Category of this Category Entry
     * @param category The new value for this Category Entry
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter method for the Description
     * @return Description of the Category Entry
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the Description of this Category Entry
     * @param description The new value for this Category Entry
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for the Star
     * @return Star of the Category Entry
     */
    public String getStar() {
        return star;
    }

    /**
     * Changes the Star of this Category Entry
     * @param star The new value for this Category Entry
     */
    public void setStar(String star) {
        this.star = star;
    }
}
