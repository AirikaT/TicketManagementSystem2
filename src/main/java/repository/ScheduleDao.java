package repository;

import model.Schedule;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBUtil;

import java.util.List;

public class ScheduleDao {

    public void createSchedule(Schedule schedule) {
        Transaction transaction = null;
        Session session = DBUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(schedule);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void updateSchedule(Schedule schedule) {
        Session session = DBUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(schedule);
            transaction.commit();
            System.out.println("The schedule has been successfully updated.");

        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public Schedule getSchedule(Long scheduleId) {

        try{
            Session session = DBUtil.getSessionFactory().openSession();
            return session.find(Schedule.class, scheduleId);
        }catch (Exception ex){
            System.out.println("Unable to find the schedule with id: " + scheduleId);
            ex.printStackTrace();
            return null;
        }
    }

    public List<Schedule> getSchedules(){
        Session session = DBUtil.getSessionFactory().openSession();
        return session.createQuery("from Schedule", Schedule.class).list();
    }

    public Schedule getScheduleEntry(long scheduleId) {

        try {
            Session session = DBUtil.getSessionFactory().openSession();
            return session.find(Schedule.class, scheduleId);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Unable to find the show you are looking for.");
            return null;
        }
    }

    public void removeScheduleEntry(Schedule schedule) {
        Transaction transaction = null;
        Session session = DBUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.delete(schedule);
            transaction.commit();
            System.out.println("The schedule entry has been successfully removed.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
}
