package hibernate_xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

  public static void main(String[] args) {
    // Assuming you want to update the student with regdno 2
    int regdnoToUpdate = 12;
    
    @SuppressWarnings("deprecation")
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();
    
    // Retrieve the student object to be updated
    Student s = (Student) session.get(Student.class, regdnoToUpdate);
    
    if (s != null) {
      // Update the student details
      s.setName("ram charan");
      s.setCgpa(10);
      
      // Save the updated student object
      session.update(s);
      tx.commit();
      System.out.println("Student with regdno " + regdnoToUpdate + " updated successfully.");
    } else {
      System.out.println("Student with regdno " + regdnoToUpdate + " not found.");
      tx.rollback();
    }
    
    session.close();
    factory.close();
  }
}
