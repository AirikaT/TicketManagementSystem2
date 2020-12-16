package services;

import services.ScheduleMain;
import model.Schedule;
import org.junit.jupiter.api.*;
import repository.ScheduleDao;

import java.time.LocalDateTime;
import java.util.List;


public class ScheduleMainTest {

    @BeforeEach
    public void setUp() {
        ScheduleMain.createScheduleEntry(LocalDateTime.of(2020, 12, 1, 19, 0), 3, 3);
        ScheduleMain.createScheduleEntry(LocalDateTime.of(2020, 12, 2, 19, 0), 2, 4);
        ScheduleMain.createScheduleEntry(LocalDateTime.of(2020, 12, 3, 19, 0), 1, 5);
        ScheduleMain.createScheduleEntry(LocalDateTime.of(2020, 12, 4, 19, 0), 4, 6);
        ScheduleMain.createScheduleEntry(LocalDateTime.of(2020, 12, 4, 19, 0), 2, 7);
    }

    @Test()
    @DisplayName("PrintSchedule")
    public void shouldPrintSchedule() {
        ScheduleDao scheduleDao = new ScheduleDao();
        List<Schedule> schedules = scheduleDao.getSchedules();
        ScheduleMain.printSchedule();

        assert schedules.get(0).getLocation().getLocationId() == 3;
        assert schedules.get(2).getLocation().getLocationId() == 1;
        assert schedules.get(4).getLocation().getLocationId() == 2;
        assert schedules.get(1).getShow().getShowId() == 4;
        assert schedules.get(2).getShow().getShowId() == 5;
        assert schedules.get(3).getShow().getShowId() == 6;
        assert schedules.get(2).getStartTime().equals("03-12-2020 19:00");
        assert schedules.get(4).getStartTime().equals("04-12-2020 19:00");
        assert schedules.get(0).getLocation().getLocationName().equals("The Chamber Hall");
        assert schedules.get(3).getShow().getTitle().equals("Once");

    }
}
