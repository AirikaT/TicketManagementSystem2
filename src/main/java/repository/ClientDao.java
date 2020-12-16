package repository;

import model.Client;
import util.DBUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDao {

    public void createClient(Client client) {
        Session session = DBUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
    public void updateClient(Client client) {
        Session session = DBUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
            System.out.println("The client has been successfully updated.");
        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public Client getClient(long clientId) {
        Session session = DBUtil.getSessionFactory().openSession();

        try {
            //return session.find(Client.class, clientId);
            Client client = session.find(Client.class, clientId);
            return client;
        } catch (Exception ex) {
            System.out.println("Unable to find the client you are looking for.");
            ex.printStackTrace();
            return null;
        }
    }


    public void deleteClient(Client client) {
        Transaction transaction = null;
        Session session = DBUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.delete(client);

            transaction.commit();
            System.out.println("Your client has been successfully deleted from database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

}
