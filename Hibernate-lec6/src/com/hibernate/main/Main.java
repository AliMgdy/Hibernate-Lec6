package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hibernate.model.Friends;
import com.hibernate.model.Post;
import com.hibernate.model.User;
import com.hibernate.model.UserDetails;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				Configuration configuration = new Configuration()
						.addAnnotatedClass(User.class)
						.addAnnotatedClass(UserDetails.class)
						.addAnnotatedClass(Friends.class)
						.addAnnotatedClass(Post.class)
						.configure("hibernate.cfg.xml");
				
	 SessionFactory sessionFactory = configuration.buildSessionFactory();
				
	 Session session = sessionFactory.getCurrentSession();
						
	 Transaction transaction =  session.beginTransaction();
	 	 
	 // this part for add with cascade OneToOne
	 User user = new User ("ali", 25);
	 UserDetails userDetails = new UserDetails ("alex" , "011");
	 
	 userDetails.setUser(user);
	 
	 session.persist(userDetails);
	 
	 // this part for fetch
     UserDetails userDetailsFt = session.get(UserDetails.class , 1);
	 
	 System.out.println("UserDeatils ==> " + userDetailsFt.getAddress() + " - " + userDetailsFt.getPhone());
	 
	 System.out.println("UserDeatils ==> " + userDetailsFt.getUser().getAge() + " - " + userDetailsFt.getUser().getName());
	 
	// this part for add with cascade ManyToMany
	 Friends friend1 = new Friends("eslam");
	 Friends friend2 = new Friends("ahmed");
	 Friends friend3 = new Friends("moataz");
	 
	 User user1 = new User ("mohamed",26);
	 User user2 = new User ("sara",27);
	 User user3 = new User ("diab",28);
	 
	 List<User> users = new ArrayList<User>();
	 users.add(user1);
	 users.add(user2);
	 users.add(user3);
	 
	 friend1.setUsers(users);
	 friend2.setUsers(users);
	 friend3.setUsers(users);
	 
	 session.persist(friend1);
	 session.persist(friend2);
	 session.persist(friend3);
	 
	// this part for add with cascade ManyToOne
     User user = new User ("ali", 25);
	 
	 Post post1 = new Post ("info","java");
	 Post post2 = new Post ("ext","php");
	 Post post3 = new Post ("lan","c++");
	 
	 post1.setUser(user);
	 post2.setUser(user);
	 post3.setUser(user);
	 
	 session.persist(post1);
	 session.persist(post2);
	 session.persist(post3);
	 
	 
	// this part for add without cascade OneToOne
	 User user = new User ("ali", 25);
	 UserDetails userDetails = new UserDetails ("alex" , "011");
	 
	 userDetails.setUser(user);
	 
	 session.save(user);
	 session.save(userDetails);
	 
	// this part for add without cascade ManyToMany
	 Friends friend1 = new Friends("eslam");
	 Friends friend2 = new Friends("ahmed");
	 Friends friend3 = new Friends("moataz");
	 
	 User user1 = new User ("mohamed",26);
	 User user2 = new User ("sara",27);
	 User user3 = new User ("diab",28);
	 
	 List<User> users = new ArrayList<User>();
	 users.add(user1);
	 users.add(user2);
	 users.add(user3);
	 
	 friend1.setUsers(users);
	 friend2.setUsers(users);
	 friend3.setUsers(users);
	 
	 session.save(user1);
	 session.save(user2);
	 session.save(user3);
	 
	 session.save(friend1);
	 session.save(friend2);
	 session.save(friend3);
	 
	// this part for add without cascade ManyToOne
	 User user = new User ("ali", 25);
	 
	 Post post1 = new Post ("info","java");
	 Post post2 = new Post ("ext","php");
	 Post post3 = new Post ("lan","c++");
	 
	 post1.setUser(user);
	 post2.setUser(user);
	 post3.setUser(user);
	 
	 session.save(user);
	 session.save(post1);
	 session.save(post2);
	 session.save(post3);
	 
	 
	transaction.commit();
	session.close();
	sessionFactory.close();
	 
	 
	}

}
