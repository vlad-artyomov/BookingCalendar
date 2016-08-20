package BookingCalendar;

import DAO.BookingDAO;
import Entity.Booking;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    //private EntityManager em;
    //persistence unit

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return "Got it!";
//    }

    private static final Logger log = Logger.getLogger(MyResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllBookings() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Booking> bookingsEntities;

        try {
            log.info("querying all entities...");
            bookingsEntities = BookingDAO.getInstance().getAll();
            for (Booking entity : bookingsEntities)
                stringBuilder.append(entity.getDateFrom()).append(" - ")
                        .append(entity.getDateTo()).append("\n");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e);
        }

        if (stringBuilder.length() != 0)
            return stringBuilder.toString();
        return "No bookings";
    }
}
