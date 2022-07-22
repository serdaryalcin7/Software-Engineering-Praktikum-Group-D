package at.jku.se.diary;

/**
 * @author Team-D
 * This class has a constructor and generates getters and setters for the categories
 */
public class CategoryEntry {

    private String category;
    private String description;
    private String star;

    public CategoryEntry(){}

    public CategoryEntry(String category, String description, String star) {

            this.category = category;
            this.description = description;
            this.star = star;
    }

    /**
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
