package BookingCalendar;

import Entity.BookingsEntity;
import Entity.HibernateUtil;
import org.hibernate.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllBookings() {
        StringBuilder stringBuilder = new StringBuilder();

        final Session session = HibernateUtil.getSession();
        try {
            List bookingsEntities = session.createCriteria(BookingsEntity.class).list();
            for (Object entity : bookingsEntities)
                stringBuilder.append(((BookingsEntity)entity).getDateFrom()).append(" - ")
                        .append(((BookingsEntity)entity).getDateTo()).append("\n");
        } finally {
            session.close();
        }

        if (stringBuilder.length() != 0) return stringBuilder.toString();
        return "No bookings";
    }
}
