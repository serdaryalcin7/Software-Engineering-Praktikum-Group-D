package at.jku.se.diary;

public class CategoryEntry {

    private String category;
    private String description;
    private String star;

    public CategoryEntry(String category, String description, String star) throws EntryNullException {
            if (category == null || description == null || star == null) {
                throw new EntryNullException("Please fill out every field!");
            }

            this.category = category;
            this.description = description;
            this.star = star;
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
