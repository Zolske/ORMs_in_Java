package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table (name="comments")
public class Comment {
    @Id
    @GeneratedValue
    int id;
    String text;
    LocalDate date_posted;
    @ManyToOne(fetch=LAZY)
    User author;
    int associated_recipe;

    public Comment(String text, LocalDate date_posted, User author, int associated_recipe) {
        this.text = text;
        this.date_posted = date_posted;
        this.author = author;
        this.associated_recipe = associated_recipe;
    }
}
