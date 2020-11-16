import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
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
//			client_1.InsertRecordInDatabase(1,2322,"Rohit",15,7000);
//			client_1.InsertRecordInDatabase(2,2323,"Virat",25,9000);
			client_1.DisplayRecords();
			
//			client_1.UpdateRecord(1, "Sachin");
//			client_1.DisplayRecords();
//			
			client_1.DeleteRecord(1);
			client_1.DisplayRecords();
		}
		catch(HibernateException e) {
			System.out.println("Exception is "+e);
		}
	}
	
	public void InsertRecordInDatabase(int id,int pNo,String name,int tenure,int amount) throws HibernateException{
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance i1 = new Insurance(id,pNo,name,tenure,amount);
		session.save(i1);
		tx.commit();
		session.close();
		
	}
	
	public void DisplayRecords() throws HibernateException{
		Session session = factory.openSession();
		List insList = session.createQuery("From Insurance").list();
		for(Iterator iterator = insList.iterator(); iterator.hasNext();) {
			Insurance ins = (Insurance) iterator.next();
			System.out.println("Policy No: "+ins.getPolicyNo());
			System.out.println("Policy Holder Name: "+ins.getName());
			System.out.println("Tenure of policy: "+ins.getTenure());
			System.out.println("Amount: "+ins.getAmount());
		}
		session.close();
	}
	
	public void UpdateRecord(Integer PolicyId,String name) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance insurance = (Insurance) session.get(Insurance.class,PolicyId);
		insurance.setName(name);
		session.update(insurance);
		tx.commit();
		session.close();
	}
	
	public void DeleteRecord(Integer PolicyId) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance employee = (Insurance) session.get(Insurance.class,PolicyId);
		session.delete(employee);
		tx.commit();
		session.close();
	}
}
