package util;

import model.Shows;
import model.Client;
import model.Location;
import model.Schedule;
import model.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.Properties;

public class DBUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try{
            // to manage credentials etc in a separate file
            PropertiesConfiguration applicationProperties = new PropertiesConfiguration();
            applicationProperties.load("application.properties");
            applicationProperties.load("application.properties");

            Configuration configuration = new Configuration();
            Properties properties = new Properties();

            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");             // the old one "com.mysql.jdbc.Driver" is replaced with new one "com.mysql.cj.jdbc.Driver"
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/theatre?createDatabaseIfNotExist=true&serverTimezone=UTC");

            // all 3 database logins are here
            // just comment out own to make a connection

            //Airika user
            properties.put(Environment.USER, applicationProperties.getString("dbUsernameAir"));
            properties.put(Environment.PASS, applicationProperties.getString("dbPasswordAir"));

            //Kristiina user
            /*properties.put(Environment.USER, applicationProperties.getString("dbUsernameKri"));
            properties.put(Environment.PASS, applicationProperties.getString("dbPasswordKri"));*/
            //Susanna user
            /*properties.put(Environment.USER, applicationProperties.getString("dbUsernameSus"));
            properties.put(Environment.PASS, applicationProperties.getString("dbPasswordSus"));
*/
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.HBM2DDL_AUTO, "update");                           // this one should use carefully "create-drop" will do full data restart. Best even to comment out or use "update".
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");


            configuration.setProperties(properties);

            //all entities need to be registered
            configuration.addAnnotatedClass(Shows.class);
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Location.class);
            configuration.addAnnotatedClass(Schedule.class);
            configuration.addAnnotatedClass(Ticket.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sessionFactory;
    }
}
