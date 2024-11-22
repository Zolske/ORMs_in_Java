import org.hibernate.query.Query;

import java.util.List;

public class RecipeRepository {

public void getAllTags() {
    var sessionFactory = Database.getSessionFactory();
    sessionFactory.inTransaction(session -> {
        Query query = session.createQuery("from tags");
        List list = query.list();
        list.forEach(e-> System.out.println(e.toString()));
    });

}
}
