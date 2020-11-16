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
			Employee emp1 = new Employee(3,"vishwaksen","bairisetti",4000);
			emp1.setAddress(add1);
			client_1.insertData(emp1,add1);
			
			Address add2 = new Address("RR Nagar","Bangalor","India","234");
			Employee emp2 = new Employee(5,"raju","kamepalli",8000);
			emp2.setAddress(add2);
			client_1.insertData(emp2,add2);
			
			client_1.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println("Exception is "+e);
		}
	}
	
	public void insertData(Employee empObj,Address addObj) throws HibernateException{
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(empObj);
		session.save(addObj);
		tx.commit();
		System.out.println("Employee and Address are inserted in the database");
		session.close();
		
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		
		List empList = session.createQuery("From Employee").list();
		
		for(Iterator iterator = empList.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.println("First Name: "+emp.getFirstName());
			System.out.println("Last Name: "+emp.getLastName());
			System.out.println("Salary: "+emp.getSalary());
			Address add = emp.getAddress();
			System.out.println("Address");
			System.out.println("Street: "+add.getStreet());
			System.out.println("City: "+add.getCity());
			System.out.println("State: "+add.getState());
			System.out.println("Zipcode: "+add.getZipCode());
			
		}
		session.close();
	}
	
	
}
