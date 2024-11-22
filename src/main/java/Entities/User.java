package Entities;

import Datatypes.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    int id;
    String username;
    String email;
    String password;
    Role roles;
    boolean date_registered;
    @OneToMany(mappedBy="creator")
    Set<Recipe> recipes;

    public User(Set<Recipe> recipes, boolean date_registered, Role roles, String password, String email, String username) {
        this.recipes = recipes;
        this.date_registered = date_registered;
        this.roles = roles;
        this.password = password;
        this.email = email;
        this.username = username;
    }
}
