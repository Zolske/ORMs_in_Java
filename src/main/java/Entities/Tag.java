package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="tags")
public class Tag {
    @Id
    @GeneratedValue
    int id;
    String name;

    public Tag() {
    }

    public int getId() {
        return id;
    }

    public Tag(String name) {
        this.name = name;
    }
}
