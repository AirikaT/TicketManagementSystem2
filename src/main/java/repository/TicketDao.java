package repository;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBUtil;

import java.util.List;


public class TicketDao {


    public void saveTicket(Ticket ticket) {

        Transaction transaction = null;
        Session session = DBUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(ticket);

            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }

        session.close();
    }

    public void createTicket(double price, long scheduleId, Client client) {

        Ticket ticket = new Ticket();
        TicketDao ticketDao = new TicketDao();

        ticket.setTicketPrice(price);
        ticket.setClient(client);

        ScheduleDao scheduleDao = new ScheduleDao();
        Schedule schedule = scheduleDao.getSchedule(scheduleId);

        ticket.setSchedule(schedule);
        ticketDao.saveTicket(ticket);

    }

    public void updateTicket(Ticket ticket) {
        Session session = DBUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
            System.out.println("The ticket has been successfully updated.");
        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void getTicket(long ticketId) {

        try {
            Session session = DBUtil.getSessionFactory().openSession();
            Ticket ticket = session.find(Ticket.class, ticketId);
            //session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Unable to find the location you are looking for.");
        }
    }

    public List<Ticket> getTickets(long scheduleId) {
        Session session = DBUtil.getSessionFactory().openSession();
        String hql = "from Ticket WHERE schedule_id = :scheduleId";
        return session.createQuery(hql,Ticket.class).setParameter("scheduleId", scheduleId).list();
    }

    public void deleteTicket(Ticket ticket) {
        Transaction transaction = null;
        Session session = DBUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.delete(ticket);

            transaction.commit();
            System.out.println("Your reservation has been successfully cancelled.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
}
