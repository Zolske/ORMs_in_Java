package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    int id;
    int value;  // (e.g. 1-5 stars)
    LocalDate date_rated;
    int associated_recipe;
    User rater;
    @OneToMany(mappedBy="rating")
    Set<Recipe> recipes;

    public Rating(int value, LocalDate date_rated, int associated_recipe, User rater, Set<Recipe> recipes) {
        this.value = value;
        this.date_rated = date_rated;
        this.associated_recipe = associated_recipe;
        this.rater = rater;
        this.recipes = recipes;
    }
}
