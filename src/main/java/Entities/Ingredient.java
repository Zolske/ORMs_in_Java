package Entities;

import Datatypes.Unit;
import jakarta.persistence.*;

@Entity
@Table (name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue
    int id;
    String name;
    int quantity;
    @Enumerated(EnumType.STRING)
    Unit unit_of_measurement;

    public Ingredient(String name, int quantity, Unit unit_of_measurement) {
        this.name = name;
        this.quantity = quantity;
        this.unit_of_measurement = unit_of_measurement;
    }

    public Ingredient(){}

    public int getId() {
        return id;
    }
}
