package Entity;

import DAO.BookingDAO;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;
    private static final Logger log = Logger.getLogger(HibernateUtil.class);

    static {
        try {
            ourSessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        log.info("querying all entities...");

        List<Booking> bookingsEntities = BookingDAO.getInstance().getAll();
        for (Booking entity : bookingsEntities)
            System.out.println(entity.getId());
    }
}
