package Entities;

import Datatypes.Unit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    int id;
    String name;
    int quantity;
    Unit unit_of_measurement;

    public Ingredient(String name, int quantity, Unit unit_of_measurement) {
        this.name = name;
        this.quantity = quantity;
        this.unit_of_measurement = unit_of_measurement;
    }

    public int getId() {
        return id;
    }
}
