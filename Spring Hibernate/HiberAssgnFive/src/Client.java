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
			client_1.InsertRecordInDatabase(1,"Rohit",48,12123);
			client_1.InsertRecordInDatabase(2,"Virat",24,70772);
			client_1.InsertRecordInDatabase(3,"Rahul",52,76542);
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
	
	public void InsertRecordInDatabase(int id,String name,int age,int trainNo) throws HibernateException{
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Passenger p1 = new Passenger(id,name,age,trainNo);
		session.save(p1);
		tx.commit();
		session.close();
		
	}
	
	public void DisplayRecords() throws HibernateException{
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Passenger.class);
		
		cr.add(Restrictions.lt("age",45));
		
		List passengers = cr.list();
		for(Iterator iterator = passengers.iterator(); iterator.hasNext();) {
			Passenger psg = (Passenger) iterator.next();
			System.out.println("First Name: "+psg.getName());
			System.out.println("Age : "+psg.getAge());
			System.out.println("TrainNo: "+psg.getTrainNo());
		}
		session.close();
	}
	
	
}
