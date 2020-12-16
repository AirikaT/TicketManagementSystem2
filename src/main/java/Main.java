import model.Shows;
import services.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

// Separated functionalities to enter data of Client, Show, Location

        //LocationMain.enterLocations();

        //ClientMain.enterClient();

        //Shows newShow = ShowMain.enterShows();

// Compact functionalities to enter:

        // mapping saved Show with date and location
            /*LocalDateTime showTime = LocalDateTime.of(2020, 12, 12, 19, 00);
            ScheduleMain.createScheduleEntry(showTime, 1, 2);*/

        // entering a new Show with date and location
            Shows newShow = ShowMain.enterShows();
            LocalDateTime showTime = LocalDateTime.of(2020, 12, 12, 19, 00);
            ScheduleMain.createScheduleEntry(showTime, 1, newShow.getShowId());

        // the full process of buying a ticket with creating a client.
            TicketMain ticketMain = new TicketMain();
            ticketMain.purchaseTickets();
    }
}
