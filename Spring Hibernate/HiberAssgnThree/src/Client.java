import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import oracle.net.TNSAddress.Address;


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
			Client c = new Client();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Set<Student> vvitStudents = new HashSet<Student>();
			Set<Student> rvrStudents = new HashSet<Student>();
			vvitStudents.add(new Student(510,"Vishwaksen Bairisett","CSE"));
			vvitStudents.add(new Student(417,"Avinahs Rachamalla","ECE"));
			rvrStudents.add(new Student(513,"Hemanth Bonkuri","MECH"));
			rvrStudents.add(new Student(401,"Ayyappa Challa","IT"));
			

			College vvit = new College("VVIT", "Vasireddy Venkatadri Institute of Technology","Guntur",vvitStudents);
			College rvr = new College("RVR", "Rayapati Venkata Rangarao Of Engineering","Vijayawada",rvrStudents);

			session.save(vvit);
			session.save(rvr);
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List clgList = session.createQuery("From College").list();
		displayColleges(clgList);
		List stdList = session.createQuery("From Student").list();
		displayStudents(stdList);
	}
	
	public void displayColleges(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			College clg = (College) iterator.next();
			System.out.println(clg.toString());
		}
	}
	
	public void displayStudents(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Student std = (Student) iterator.next();
			System.out.println(std.toString());
		}
	}
	
	
}
