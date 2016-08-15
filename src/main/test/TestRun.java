import DAO.BookingDAO;
import Entity.Booking;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class TestRun {

    private static final Logger log = Logger.getLogger(TestRun.class);

    public static void main(final String[] args) throws Exception {
        log.info("querying all entities...");

        //Testing add to DB
        Booking booking = new Booking();
        booking.setDateFrom(Date.valueOf("2016-04-01"));
        booking.setDateTo(Date.valueOf("2016-04-10"));
        BookingDAO.getInstance().add(booking);

        List<Booking> bookingsEntities = BookingDAO.getInstance().getAll();
        for (Booking entity : bookingsEntities)
            System.out.println(entity.getId() + "   " + entity.getDateFrom() + " - " + entity.getDateTo());

        //Testing delete from DB
        BookingDAO.getInstance().delete(booking);
    }
}
