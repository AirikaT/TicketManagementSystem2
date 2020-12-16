package services;

//import menu.LocationMain;
import model.Location;
import org.junit.jupiter.api.*;

public class LocationMainTest {
    public Location location1;
    public Location location2;

    @BeforeEach
    public void setUp() {
     location1 = new Location("Name of the Hall", 200);
     location2 = new Location("Name of another Hall", 10);
    }

    @Test()
    @DisplayName("EnterLocations")
    public void shouldEnterLocations() {
        LocationMain.enterLocations();
        assert location1.getLocationName().equals("Name of the Hall");
        assert location2.getMaxSeats()==10;
    }
}
