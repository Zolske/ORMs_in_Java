import Datatypes.Unit;
import Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static java.lang.Boolean.TRUE;
import static org.hibernate.cfg.JdbcSettings.*;

public class Database {
    public static SessionFactory getSessionFactory(){
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

    static void seed(){
        var sessionFactory = getSessionFactory();
        // TODO
        sessionFactory.inTransaction(session -> {
            Ingredient ingredient =new Ingredient("eggs", 2, Unit.EACH);
            session.persist(ingredient);
            session.flush(); // Synchronise the session with the database
            session.refresh(ingredient); // Refresh to retrieve the generated ID
            session.persist(new Recipe("Pancake", "Blueberry Pancake", "Mix ingredients together", 5,
                    8, 4, 5, 10, null, null, null, null, null ));

            var ingredientWithId = ingredient.getId(); // Get the generated ID

        });
    }
}