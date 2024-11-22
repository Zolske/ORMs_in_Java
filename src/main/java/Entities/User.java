package Entities;

import Datatypes.Role;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    int id;
    String username;
    String email;
    String password;
//    Role roles;
//    boolean date_registered;
//    @OneToMany(mappedBy="creator")
//    Set<Recipe> recipes;

//    public User(Set<Recipe> recipes, boolean date_registered, Role roles, String password, String email, String username) {
////        this.recipes = recipes;
//        this.date_registered = date_registered;
////        this.roles = roles;
//        this.password = password;
//        this.email = email;
//        this.username = username;
//    }

    public User(){}

public User( String password, String email, String username) {
//        this.recipes = recipes;
//    this.date_registered = date_registered;
////        this.roles = roles;
    this.password = password;
    this.email = email;
    this.username = username;
}
}
