import DAO.BookingDAO;
import Entity.Booking;
import org.apache.log4j.Logger;

import java.util.List;

public class TestRun {

    private static final Logger log = Logger.getLogger(TestRun.class);

    public static void main(final String[] args) throws Exception {
        log.info("querying all entities...");

        List<Booking> bookingsEntities = BookingDAO.getInstance().getAll();
        for (Booking entity : bookingsEntities)
            System.out.println(entity.getId());
    }
}
