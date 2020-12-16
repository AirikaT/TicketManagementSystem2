package repository;

import model.Shows;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBUtil;

public class ShowsDao {


    public void createShows(Shows shows) {
        Session session = DBUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(shows);
            transaction.commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }


    public Shows getShow(int showId) {
        Session session = DBUtil.getSessionFactory().openSession();


        try{
            Shows shows = session.find(Shows.class, showId);
            session.close();
            return shows;
        }catch (Exception ex){
            session.close();
            System.out.println("Unable to find the show with this id: " + showId);
            ex.printStackTrace();
            return null;
        }
    }

}