package repository;

import services.ScheduleMain;
import model.Schedule;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScheduleDaoTest {
    ScheduleDao scheduleDao = new ScheduleDao();

    @BeforeEach
    public void setUp() {
        ScheduleMain.createScheduleEntry(LocalDateTime.of(2020, 12, 1, 19, 0), 3, 3);
        ScheduleMain.createScheduleEntry(LocalDateTime.of(2020, 12, 2, 19, 0), 2, 4);
    }

    @Test
    @DisplayName("Get all the entries in a schedule")
    void getSchedules() {
        List<Schedule> schedules = scheduleDao.getSchedules();
        Assertions.assertNotNull(schedules);
        assert schedules.get(0).getLocation().getLocationId()==3;
    }
}
