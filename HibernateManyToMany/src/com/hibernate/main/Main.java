package com.hibernate.main;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hibernate.model.Course906;
import com.hibernate.model.Email;
import com.hibernate.model.StudentGroup906;
import com.hibernate.model.StudentGroupDetails906;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration()
				.addAnnotatedClass(StudentGroup906.class)
				.addAnnotatedClass(StudentGroupDetails906.class)
				.addAnnotatedClass(Email.class)
				.addAnnotatedClass(Course906.class)
				.configure("hibernate.cfg.xml");
		
		  SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		   Session session = sessionFactory.getCurrentSession();
				
		   Transaction transaction =  session.beginTransaction();
		   
		 
		   StudentGroup906 studentGroup906f = new StudentGroup906("ali" , 123);
		   StudentGroup906 studentGroup906s = new StudentGroup906("eslam" , 456);
		   StudentGroup906 studentGroup906t = new StudentGroup906("ahmed" , 789);
		   
		   List<StudentGroup906> students = new ArrayList<StudentGroup906>();
		   students.add(studentGroup906f);
		   students.add(studentGroup906s);
		   students.add(studentGroup906t);
		   
		   Course906 course906f = new Course906();
		   course906f.setCourse("java");
		   course906f.setStudentGroup906(students);
		   
		   Course906 course906s = new Course906();
		   course906s.setCourse("python");
		   course906s.setStudentGroup906(students);
		   
		   Course906 course906t = new Course906();
		   course906t.setCourse("c++");
		   course906t.setStudentGroup906(students);
	
		
	// this part for save without cascade 
		   session.save(studentGroup906f);
		   session.save(studentGroup906s);
		   session.save(studentGroup906t);

		   session.save(course906f);
		   session.save(course906s);
		   session.save(course906t);
		   
    // this part for save with cascade 	   
		   session.persist(course906f);
		   session.persist(course906s);
		   session.persist(course906t);
		   
		   
    // this part for select without cascade   
      StudentGroup906 studentGroup906Sel = session.get(StudentGroup906.class, 1);
       System.out.println("Student: " + studentGroup906Sel.getUserName() + " - " + studentGroup906Sel.getPassword());
       
	   Course906 courseSel = session.get(Course906.class, 1);
	   System.out.println("---->" + courseSel.getId() + " - " + courseSel.getCourse());
		        
    // this part for update without cascade 
		 StudentGroup906 studentUpdate = session.get(StudentGroup906.class, 2);
		 System.out.println("---->" + studentUpdate.getUserName() + " - " + studentUpdate.getPassword());
		
		 studentUpdate.setUserName("lol");
		 studentUpdate.setPassword(999);
		 System.out.println("---->" + studentUpdate.getUserName() + " - " + studentUpdate.getPassword());
		 
		 Course906 courseUpdate = session.get(Course906.class, 1);
		 System.out.println("---->" + courseUpdate.getCourse());
		 
		 courseUpdate.setCourse("php");
		 System.out.println("---->" + courseUpdate.getCourse());
		 
		 session.update(studentUpdate);
		 session.update(courseUpdate);
		 
	// this part for update with cascade 
		StudentGroup906 studentUpdateCascade = session.get(StudentGroup906.class, 2);
		System.out.println("---->" + studentUpdateCascade.getUserName() + " - " + studentUpdateCascade.getPassword());
		
		studentUpdateCascade.setUserName("lol");
		studentUpdateCascade.setPassword(999);
		System.out.println("---->" + studentUpdateCascade.getUserName() + " - " + studentUpdateCascade.getPassword());
		
		Course906 courseUpdateCascade = session.get(Course906.class, 1);
		System.out.println("---->" + courseUpdateCascade.getCourse());
		 
		courseUpdateCascade.setCourse("php");
		System.out.println("---->" + courseUpdateCascade.getCourse());
		
		session.merge(courseUpdateCascade);
		
	  // this part for delete without cascade
		 StudentGroup906 studentDelete = session.get(StudentGroup906.class, 3);
		 
		 Course906 courseDelete = session.get(Course906.class, 3);
		 
		 session.delete(courseDelete);
		 session.delete(studentDelete);
		
	// this part for delete with cascade
		Course906 courseRemove = session.get(Course906.class, 3);

		courseRemove.getStudentGroup906().clear();

		session.remove(courseRemove);
		
	// this part for refresh with cascade
		 Course906 courseRes = session.get(Course906.class, 1);
	        System.out.println("courseRes:" + courseRes.getCourse());

	       
	        courseRes.setCourse("c++");
	      System.out.println("courseUpdate: " + courseRes.getCourse());

	        
	      session.refresh(courseRes);
	       System.out.println("courseRefresh: " + courseRes.getCourse());

		 		  
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}

}

/*
 
		Transaction transaction = session.beginTransaction();
		
		StudentGroup906 studentGroup906Res = session.get(StudentGroup906.class, 2);
		
		studentGroup906Res.setName("updated name 12345");

 * StudentGroup906 studentGroup906 = new StudentGroup906("ahmed", 22, "alex");
session.save(studentGroup906);*/

/*StudentGroup906 studentGroup906Res = session.get(StudentGroup906.class, 1);

System.out.println("---->" + studentGroup906Res.toString());

studentGroup906Res.setName("test_update");
session.update(studentGroup906Res);

System.out.println("---->" + studentGroup906Res.toString());*/

/*StudentGroup906 studentGroup906Res = session.get(StudentGroup906.class, 1);
session.delete(studentGroup906Res);*/





/*System.out.println("==> " + studentGroupDetails906.getId() + " - " + studentGroupDetails906.getAddress());

System.out.println("==> " + studentGroupDetails906.getStudentGroup906().getUserName() + " - " + studentGroupDetails906.getStudentGroup906().getPassword());
*/
//session.merge(studentGroupDetails906);

// * student  
//StudentGroup906 studentGroup906 = new StudentGroup906("eslam", 123);

// * student details + student
/*StudentGroupDetails906 studentGroupDetails906 = 
		new StudentGroupDetails906(15,"alex");

studentGroupDetails906.setStudentGroup906(studentGroup906);

//session.save(studentGroup906);

//session.save(studentGroupDetails906);

session.persist(studentGroupDetails906);*/

/*
 * 
 * StudentGroupDetails906 studentGroupDetails906 = session.get(StudentGroupDetails906.class, 3);
		
		System.out.println("==> " + studentGroupDetails906.getId() + " - " + studentGroupDetails906.getAddress());
		
		System.out.println("==> " + studentGroupDetails906.getStudentGroup906().getUserName() + " - " + studentGroupDetails906.getStudentGroup906().getPassword());
		
		studentGroupDetails906.setAddress("updated Address7");
		
		studentGroupDetails906.getStudentGroup906().setUserName("updated username7");
		
		session.detach(studentGroupDetails906);
		*/
