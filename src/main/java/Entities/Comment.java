package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    int id;
    String text;
    LocalDate date_posted;
    User author;
    int associated_recipe;

    public Comment(String text, LocalDate date_posted, User author, int associated_recipe) {
        this.text = text;
        this.date_posted = date_posted;
        this.author = author;
        this.associated_recipe = associated_recipe;
    }
}
