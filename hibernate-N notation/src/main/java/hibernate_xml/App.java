package hibernate_xml;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// Ensure this import for Hibernate 5.x or later

public class App {
    public static void main(String[] args) {
        App nj = new App();
        nj.aggregatefunctions();
    }

    public void aggregatefunctions() {
        // Create a Configuration instance
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Ensure this file exists and is correctly configured
        
        // Build the SessionFactory
        @SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
        
        // Open a new session
        Session session = sf.openSession();
        
            String hql1 = "select count(*) from Student";
            Query qry1=session.createQuery(hql1);
            long count = qry1.getFirstResult();
            System.out.println("Total Students = " + count);
            session.close();
            sf.close();
        }
    }