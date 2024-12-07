package hibernate_xml;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ReadData {
public static void main(String[]args) {
  @SuppressWarnings("deprecation")
SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();
    String hq1 = "FROM Student";
    org.hibernate.Query query = session.createQuery(hq1);
    List<Student>highcgpa = query.list();

    for(Student student : highcgpa) {
      System.out.println("regd_no: "+ student.getRegdno());
      System.out.println("s_name: "+ student.getName());
      System.out.println("S_cgpa: "+ student.getCgpa());
      tx.commit();
      session.close();
    }
}
  
}