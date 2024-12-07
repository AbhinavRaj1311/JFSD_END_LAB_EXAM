package hibernate_xml;

import java.util.List;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class hcqloperations {
   public static void main(String args[])   {
   hcqloperations operations = new hcqloperations();   
   //operations.addStudent();
   //operations.restrictionsdemo();  
   //operations.orderdemo();
   //operations.hcqlusecase();  
   //operations.aggregatefunctions();
   operations.paginationdemo();   
   // add student by using Persistent Object(PO)   public void addEmployee()
       Configuration configuration = new Configuration();
       configuration.configure("hibernate.cfg.xml");       
       SessionFactory sf = configuration.buildSessionFactory();      
       Session session = sf.openSession();
           Transaction t =  session.beginTransaction();
            Student s = new Student();
        s.setRegdno(72); 
        s.setName("shyam");
        s.setCgpa(10);        
        session.persist(s);
        t.commit();        
        System.out.println("Student Added Successfully");    
       session.close();        
       sf.close();
   }
   

public void orderdemo() {
	// ascending / descending 
 Configuration configuration = new Configuration(); 
    configuration.configure("hibernate.cfg.xml"); 
     
    SessionFactory sf = configuration.buildSessionFactory(); 
    Session session = sf.openSession(); 
     
   CriteriaBuilder cb = ((EntityManager) session).getCriteriaBuilder(); 
 CriteriaQuery<Student> cq = cb.createQuery(Student.class); 
 Root<Student> root = cq.from(Student.class); 
  
 // ascending order based on cgpa 
 cq.orderBy(cb.asc(root.get("cgpa"))); 
  
 //descending order based on name 
 //cq.orderBy(cb.desc(root.get("name"))); 
  
 System.out.println("****Order by Demo****"); 
 List<Student> stu =  session.createQuery(cq).getResultList(); 
 System.out.println("Students Count="+stu.size()); 
 for(Student s : stu) 
 { 
  System.out.println(s.toString()); 
  System.out.println("Name="+s.getName()+"  Cgpa="+s.getCgpa()); 
 } 
  
session.close(); 
 sf.close(); 
}


public void restrictionsdemo() {      
	 Configuration configuration = new Configuration(); 
	    configuration.configure("hibernate.cfg.xml"); 
	     
	    SessionFactory sf = configuration.buildSessionFactory(); 
	    Session session = sf.openSession(); 
	  
	    //Transaction t =  session.beginTransaction(); 
	  
	 CriteriaBuilder cb = ((EntityManager) session).getCriteriaBuilder(); 
	 CriteriaQuery<Student> cq = cb.createQuery(Student.class); 
	 // from Student; [Complete Object] To read all proper 
	 Root<Student> root = cq.from(Student.class); 
	  
	  //cq.select(root).where(cb.equal(root.get("name"), "lahari")); 
	 //cq.select(root).where(cb.lessThan(root.get("cgpa"), 10)); 
	  //cq.select(root).where(cb.greaterThan(root.get("cgpa"), 9)); 

	 // not with any existing criteria 
	 //cq.select(root).where(cb.not(cb.equal(root.get("id"), "123"))); 
	  
	 List<Student> stu =  session.createQuery(cq).getResultList(); 
	 System.out.println("Students Count="+stu.size()); 
	 for(Student s : stu) 
	 { 
	  // use getter methods to print every property in Student object (s) 
	  System.out.println(s.toString());  // Generate toString() method in POJO Class 
	  System.out.println("Name="+s.getName()+"  Salary="+s.getCgpa()); 
	 } 
	    session.close(); 
	    sf.close();    
	}



public void paginationdemo() 
{ 
  Configuration cfg = new Configuration(); 
  cfg.configure("hibernate.cfg.xml"); 
   
  SessionFactory sf = cfg.buildSessionFactory(); 
  Session session = sf.openSession(); 
  
  String hql = "from Student"; 
  Query<Student> qry = session.createQuery(hql, Student.class); 
   
  qry.setFirstResult(0); 
  qry.setMaxResults(8); 
   
  List<Student> stu =  qry.getResultList(); 
   
   
  System.out.println("Total Student="+stu.size()); 
   
  for( Student s :stu) 
  { 
    System.out.println("Regdno:"+s.getRegdno()); 
    System.out.println("Name:"+s.getName()); 
    //System.out.println("Designation:"+e.getstudesignation()); 
    System.out.println("Cgpa:"+s.getCgpa()); 
  } 
  session.close(); 
  sf.close();   
}
}