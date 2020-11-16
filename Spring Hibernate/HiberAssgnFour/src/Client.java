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

			Student vis = new Student(510,"Vishwaksen Bairisett","CSE");
			Student avi = new Student(417,"Avinahs Rachamalla","ECE");
			Student hem = new Student(513,"Hemanth Bonkuri","MECH");
			Student ayy = new Student(401,"Ayyappa Challa","IT");
			
			
			Set<Student> shiftone = new HashSet<Student>();
			shiftone.add(vis);
			shiftone.add(avi);
			
			Set<Student> shifttwo = new HashSet<Student>();
			shifttwo.add(hem);
			shifttwo.add(ayy);
						
			Teacher kp = new Teacher(1, "Data Structures", "Prasad","Palli" ,shifttwo);
			Teacher sk = new Teacher(2, "Data Science", "Suresh", "Kolluri" ,shiftone);
			Teacher st = new Teacher(3, "Data Mining", "Sudheer","Tirumalasetty", shifttwo);
			Teacher hm = new Teacher(4, "Machine Learning", "Harsha","Mulugu", shiftone);

			session.save(kp);
			session.save(sk);
			session.save(st);
			session.save(hm);
			
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List teachersList = session.createQuery("From Teacher").list();
		display(teachersList);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Teacher teacher = (Teacher) iterator.next();
			System.out.println("Students studying under "+teacher.getFirstName()+" "+teacher.getLastName()+":\n");
			Set<Student> student = teacher.getStudent();
			Iterator iter = student.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next().toString());
			}
		}
	}
	
	
}
