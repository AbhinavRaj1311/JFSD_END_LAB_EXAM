package hibernate_xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertStudent {

  public static void main(String[] args) {
  Student s = new Student();
 
  
  
  @SuppressWarnings("deprecation")
SessionFactory factory = new Configuration().configure().buildSessionFactory();
  Session session = factory.openSession();
  Transaction tx = session.beginTransaction();
  s.setRegdno(121);
  s.setName("Abhi");
  s.setCgpa(9);
  
  session.save(s);
  
  tx.commit();
  
  
  }

}