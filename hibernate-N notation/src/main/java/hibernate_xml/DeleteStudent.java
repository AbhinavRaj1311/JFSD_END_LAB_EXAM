package hibernate_xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

  public static void main(String[] args) {
    // Assuming you want to delete the student with regdno 12
    int regdnoToDelete = 121;
    
    @SuppressWarnings("deprecation")
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();
    Transaction tx = null;
    
    try {
      tx = session.beginTransaction();
      
      // Retrieve the student object to be deleted
      Student s = (Student) session.get(Student.class, regdnoToDelete);
      
      if (s != null) {
        // Delete the student object
        session.delete(s);
        tx.commit();
        System.out.println("Student with regdno " + regdnoToDelete + " deleted successfully.");
      } else {
        System.out.println("Student with regdno " + regdnoToDelete + " not found.");
        if (tx != null) {
          tx.rollback();
        }
      }
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
      factory.close();
    }
  }
}
