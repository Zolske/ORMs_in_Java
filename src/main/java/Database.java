import Datatypes.Role;
import Datatypes.Unit;
import Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.hibernate.cfg.JdbcSettings.*;

public class Database {
    public static SessionFactory getSessionFactory() {
        // TODO
        var sessionFactory = new Configuration()
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver") // <-- Specifying our H2 in-memory database
                .setProperty(JAKARTA_JDBC_URL, "jdbc:h2:mem:db1")   // <-- Supplying our database's connection string
                .setProperty(JAKARTA_JDBC_USER, "sa")   // <-- Using the default username...
                .setProperty(JAKARTA_JDBC_PASSWORD, "") // <-- ... and password
                .setProperty(SHOW_SQL, TRUE.toString()) // <-- SQL formatting configuration
                .setProperty(FORMAT_SQL, TRUE.toString())
                .setProperty(HIGHLIGHT_SQL, TRUE.toString())
                .setProperty("hibernate.hikari.maximumPoolSize", "20")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Image.class)
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(Rating.class)
                .addAnnotatedClass(Recipe.class)
                .addAnnotatedClass(Tag.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    static void seed() {
        var sessionFactory = getSessionFactory();
        // TODO
//        sessionFactory.inTransaction(session -> {
//            Ingredient ingredient =new Ingredient("eggs", 2, Unit.EACH);
//            session.persist(ingredient);
//            session.flush(); // Synchronise the session with the database
//            session.refresh(ingredient); // Refresh to retrieve the generated ID
//            session.persist(new Recipe("Pancake", "Blueberry Pancake", "Mix ingredients together", 5,
//                    8, 4, 5, 10, null, null, null, null, null ));

//            var ingredientWithId = ingredient.getId(); // Get the generated ID
        sessionFactory.inTransaction(session -> {
            User user = new User("1234", "something@.com", "Simon", Role.ADMIN);
            session.persist(user);
            Tag tag1 = new Tag("cakes");
            session.persist(tag1);
            Tag tag2 = new Tag("newTag");
            session.persist(tag1);
            Tag tag3 = new Tag("tag3");
            session.persist(tag1);


            Ingredient ingredient = new Ingredient("eggs", 5, Unit.EACH);
            session.persist(ingredient);
            Category category = new Category("categoryName");
            session.persist(category);
            session.flush(); // Synchronise the session with the database
            session.refresh(user); // Refresh to retrieve the generated ID
            session.refresh(tag1);
            session.refresh(ingredient);
            session.refresh(category);

//            Rating rating = new Rating(7, 1, user);
//            session.persist(rating);
//            session.flush(); // Synchronise the session with the database
//            session.refresh(rating);


            var tagWithId = tag1.getId();
            var userWithId = user.getId();
//            var ratingWithId = rating.getId();
            System.out.println(userWithId + " <--- userID");
            System.out.println(tagWithId + " <--- tagID");
//            System.out.println(ratingWithId + " <--- ratingID");

            var b = session.find(User.class, userWithId);
            System.out.println("FOUND: " + b.toString());


//            session.close();
        });
    }
}