package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="categories")
public class Category {
    @Id
    @GeneratedValue
    int id;
    String name;

    public Category(String name) {
        this.name = name;
    }
}
