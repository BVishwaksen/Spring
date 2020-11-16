import java.util.List;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
//			client_1.InsertRecordInDatabase(1,"Rohit","S",7000);
//			client_1.InsertRecordInDatabase(2,"Virat","K",9000);
//			client_1.InsertRecordInDatabase(3,"Rahul","KL",11000);
//			client_1.InsertRecordInDatabase(4,"Shreyas","A",6000);
//			client_1.InsertRecordInDatabase(5,"Dhoni","M",8000);
//			client_1.DisplayRecords();
			
//			client_1.UpdateRecord(1, 2000);
//			client_1.DisplayRecords();
////			
//			client_1.DeleteRecord(1);
			client_1.DisplayRecords();
		}
		catch(HibernateException e) {
			System.out.println("Exception is "+e);
		}
	}
	
	public void InsertRecordInDatabase(int id,String fname,String lname,int salary) throws HibernateException{
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee e1 = new Employee(id,fname,lname,salary);
		session.save(e1);
		tx.commit();
		session.close();
		
	}
	
	public void DisplayRecords() throws HibernateException{
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		
		cr.add(Restrictions.gt("salary",800));
		
		List employees = cr.list();
		for(Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.println("First Name: "+emp.getFirstName());
			System.out.println("Last Name: "+emp.getLastName());
			System.out.println("Salary: "+emp.getSalary());
		}
		session.close();
	}
	
	public void DisplayRecords_NativeSQL() throws HibernateException{
		Session session = factory.openSession();
		String sql = "SELECT * FROM hibernate_create_insert_update_delete where salary>8000";
		SQLQuery query = session.createSQLQuery(sql);
		List results = query.list();
		for(Iterator iterator = results.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.println("First Name: "+emp.getFirstName());
			System.out.println("Last Name: "+emp.getLastName());
			System.out.println("Salary: "+emp.getSalary());
		}
		session.close();
	}
	
	public void UpdateRecord(Integer EmployeeId,int salary) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class,EmployeeId);
		employee.setSalary(salary);
		session.update(employee);
		tx.commit();
		session.close();
	}
	
	public void DeleteRecord(Integer EmployeeId) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class,EmployeeId);
		session.delete(employee);
		tx.commit();
		session.close();
	}
}
