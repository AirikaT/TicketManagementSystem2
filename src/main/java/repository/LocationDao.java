package repository;

import model.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBUtil;

import java.util.List;

public class LocationDao {



    public void createLocation(Location location) {

        Session session = DBUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(location);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void updateLocation(Location location) {
        Session session = DBUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(location);
            transaction.commit();
            System.out.println("The location has been successfully updated.");

        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public Location getLocation(long locationId) {

        try {
            Session session = DBUtil.getSessionFactory().openSession();
            return session.find(Location.class, locationId);
            //session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Unable to find the location you are looking for.");
            return null;
        }
    }

    public List<Location> getLocations() {
        Session session = DBUtil.getSessionFactory().openSession();
        return session.createQuery("FROM locations", Location.class).list();
    }

    public void removeLocation(Location location) {
        Transaction transaction = null;
        Session session = DBUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.delete(location);

            transaction.commit();
            System.out.println("The location has been successfully removed.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
}
