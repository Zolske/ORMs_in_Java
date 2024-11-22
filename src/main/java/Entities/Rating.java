package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue
    int id;
    int value;  // (e.g. 1-5 stars)
    LocalDate date_rated;
    int associated_recipe;
    @ManyToOne(fetch = LAZY)
    User rater;

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public Rating(int value, int associated_recipe, User rater) {
        this.rater = rater;
        this.value = value;
        this.date_rated = LocalDate.now();
        this.associated_recipe = associated_recipe;

    }
}
