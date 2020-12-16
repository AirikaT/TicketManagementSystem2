package services;

import model.*;
import repository.*;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleMain {

    public static void createScheduleEntry(LocalDateTime startTime, int locationId, int showId) {

        Schedule schedule = new Schedule(startTime);

        LocationDao locationDao = new LocationDao();
        Location location = locationDao.getLocation(locationId);
        schedule.setLocation(location);

        ShowsDao showsDao = new ShowsDao();
        Shows show = showsDao.getShow(showId);
        schedule.setShow(show);

        ScheduleDao scheduleDao = new ScheduleDao();
        scheduleDao.createSchedule(schedule);

        System.out.println(schedule.getStartTime());

    }

    public static void printSchedule() {
        ScheduleDao scheduleDao = new ScheduleDao();
        List<Schedule> schedules = scheduleDao.getSchedules();

        if(schedules.isEmpty()) {
            System.out.println("No upcoming shows at the moment");
        } else {
            for (Schedule s : schedules) {
                System.out.println(s.getScheduleId() + "\t" + String.format("%-24s", s.getShow().getTitle()) + String.format("%-20s", s.getStartTime()) + String.format("%-22s", s.getLocation().getLocationName()));
            }
        }
    }

    public static boolean checkAvailability(long scheduleId, int numberOfTickets) {
        ScheduleDao scheduleDao = new ScheduleDao();
        List<Schedule> schedules = scheduleDao.getSchedules();

        int indexOfShow = 0;

        for (Schedule s : schedules) {
            if (schedules.contains(scheduleId)) {
                indexOfShow = (int) scheduleId;
                break;
            }
        }

        Schedule sch = schedules.get(indexOfShow);
        Location loc = sch.getLocation();
        int max = loc.getMaxSeats();

        TicketDao ticketDao = new TicketDao();
        List<Ticket> tickets = ticketDao.getTickets(scheduleId);

        if (tickets.size() >= max) {
            System.out.println("Sorry, we are sold out!");
            return false;

        } else if (numberOfTickets > (max - tickets.size())) {
            System.out.println("Sorry, we don't have that many tickets available. You can purchase maximum of " +
                    (max - tickets.size()) + " ticket(s).");
            return false;

        } else if (numberOfTickets <= (max - tickets.size())){
            System.out.println("What type of tickets would you like to purchase?\n");
            System.out.println("1 --- ADULT");
            System.out.println("2 --- STUDENT/CHILD");
            System.out.println("3 --- ELDERLY\n");
            System.out.println("Please enter your code here: ");

            return true;
        }
        return true;
    }
}
