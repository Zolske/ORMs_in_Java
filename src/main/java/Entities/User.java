package Entities;

import Datatypes.Role;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    int id;
    String username;
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;
    LocalDate date_registered;
    @OneToMany(mappedBy = "creator")
    Set<Recipe> recipes;
    @OneToMany(mappedBy = "rater")
    Set<Rating> ratings;
    @OneToMany(mappedBy = "author")
    Set<Comment> comments;


    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User(String password, String email, String username, Role role) {

        this.date_registered = LocalDate.now();
        this.role = role;
        this.password = password;
        this.email = email;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", date_registered=" + date_registered +

                '}';
    }
}
