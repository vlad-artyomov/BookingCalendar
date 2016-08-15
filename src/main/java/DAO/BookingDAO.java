package DAO;

import Entity.Booking;
import Entity.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static BookingDAO instance;

    private BookingDAO() {}

    public static BookingDAO getInstance() {
        if (instance == null)
            instance = new BookingDAO();
        return instance;
    }

    public void add(Booking item) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(Booking item) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Booking getById(Long id) throws SQLException {
        Session session = null;
        Booking booking = null;
        try {
            session = HibernateUtil.getSession();
            booking = (Booking) session.load(Booking.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return booking;
    }

    public List<Booking> getAll() throws SQLException{
        Session session = null;
        List<Booking> bookings = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            bookings = session.createCriteria(Booking.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bookings;
    }

    public void delete(Booking item) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
