import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import org.hibernate.Transaction;

public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		
		catch(Throwable ex) {
			System.err.println("Failed to create Session Factory Object "+ex);	
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void main(String args[]) {
		try
		{
			getSessionFactory();
			Client client_1 = new Client();
			
			Address add1 = new Address("Flemingo Road","Washington DC","USA","532");
			Student std1 = new Student(3,"vishwaksen","bairisetti","CSE");
			std1.setAddress(add1);
			client_1.insertData(std1,add1);
			
			Address add2 = new Address("RR Nagar","Bangalor","India","234");
			Student std2 = new Student(5,"raju","kamepalli","ECE");
			std2.setAddress(add2);
			client_1.insertData(std2,add2);
			
			client_1.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println("Exception is "+e);
		}
	}
	
	public void insertData(Student stdObj,Address addObj) throws HibernateException{
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(stdObj);
		session.save(addObj);
		tx.commit();
		System.out.println("Student and Address are inserted in the database");
		session.close();
		
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		
		List stdList = session.createQuery("From Student").list();
		
		for(Iterator iterator = stdList.iterator(); iterator.hasNext();) {
			Student std = (Student) iterator.next();
			System.out.println("First Name: "+std.getFirstName());
			System.out.println("Last Name: "+std.getLastName());
			System.out.println("Branch: "+std.getBranch()
			);
			Address add = std.getAddress();
			System.out.println("Address");
			System.out.println("Street: "+add.getStreet());
			System.out.println("City: "+add.getCity());
			System.out.println("State: "+add.getState());
			System.out.println("Zipcode: "+add.getZipCode());
			
		}
		session.close();
	}
	
	
}
