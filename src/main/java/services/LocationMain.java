package services;

import model.Location;
import repository.LocationDao;

public class LocationMain {

    public static void enterLocations() {

        Location grandAuditorium = new Location("The Grand Auditorium", 540);
        Location smallAuditorium = new Location("The Small Auditorium", 155);
        Location chamberHall = new Location("The Chamber Hall", 60);
        Location cellarHall = new Location("The Cellar Hall", 145);

        LocationDao locationDao = new LocationDao();

        locationDao.createLocation(grandAuditorium);
        locationDao.createLocation(smallAuditorium);
        locationDao.createLocation(chamberHall);
        locationDao.createLocation(cellarHall);

    }
}
