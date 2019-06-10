package guru.springframework.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jleoirab on 2019-06-08
 */
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private int prepTime;
    private int cookTime;
    private int servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
//    private int rating;
    private String imageUrl;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Set<MeasuredIngredient> measuredIngredients = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "recipes_to_categories_mapping",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<MeasuredIngredient> getMeasuredIngredients() {
        return measuredIngredients;
    }

    public void setMeasuredIngredients(Set<MeasuredIngredient> measuredIngredients) {
        this.measuredIngredients = measuredIngredients;
    }
}
