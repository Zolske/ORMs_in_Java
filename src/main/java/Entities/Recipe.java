package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue
    int id;
    String title;
    String description;
    String instructions;
    int preparation_time;
    int cooking_time;
    int servings;
    int difficulty_level;
    //    @ManyToOne(fetch=LAZY)
    int rating;
    ArrayList<Ingredient> ingredients;
    ArrayList<Category> categories;
    @ManyToOne(fetch = LAZY)
    User creator;
    LocalDate date_created;
    LocalDate last_modified;

    public Recipe(String title, String description, String instructions, int preparation_time, int cooking_time, int servings, int difficulty_level, int rating, ArrayList<Ingredient> ingredients, ArrayList<Category> categories, User creator, LocalDate date_created, LocalDate last_modified) {
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.preparation_time = preparation_time;
        this.cooking_time = cooking_time;
        this.servings = servings;
        this.difficulty_level = difficulty_level;
        this.rating = rating;
//        this.ingredients = ingredients;
//        this.categories = categories;
        this.creator = creator;
        this.date_created = date_created;
        this.last_modified = last_modified;
    }

    public Recipe() {
    }
}
