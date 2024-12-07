package hibernate_xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectStudent {

  public static void main(String[] args) {
    // Assuming you want to select the student with regdno 12
    int regdnoToSelect = 12;
    
    @SuppressWarnings("deprecation")
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();
    
    // Retrieve the student object
    Student s = (Student) session.get(Student.class, regdnoToSelect);
    
    if (s != null) {
      System.out.println("Student details: ");
      System.out.println("Regdno: " + s.getRegdno());
      System.out.println("Name: " + s.getName());
      System.out.println("CGPA: " + s.getCgpa());
    } else {
      System.out.println("Student with regdno " + regdnoToSelect + " not found.");
    }
    
    session.close();
    factory.close();
  }
}
