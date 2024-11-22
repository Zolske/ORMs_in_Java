package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Image {
    @Id
    @GeneratedValue
    int id;
    String filename;
    LocalDate file_data;
    int associated_recipe;

    public Image(int associated_recipe, LocalDate file_data, String filename) {
        this.associated_recipe = associated_recipe;
        this.file_data = file_data;
        this.filename = filename;
    }
}
