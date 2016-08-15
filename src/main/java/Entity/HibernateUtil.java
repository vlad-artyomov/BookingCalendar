package Entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            ourSessionFactory = new Configuration().
                    configure().
                    buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            List bookingsEntities = session.createCriteria(BookingsEntity.class).list();
            for (Object entity : bookingsEntities)
                System.out.println(((BookingsEntity) entity).getId());
        } finally {
            session.close();
        }
    }
}
