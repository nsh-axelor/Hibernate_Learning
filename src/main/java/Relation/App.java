package Relation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setMarks(100);
		s1.setName("Nandit");
		s1.setRollNo(55);
		
		Laptop l1 = new Laptop();
		l1.setLid(1);
		l1.setLname("HP");
		l1.getStudent().add(s1);
		
		s1.getLaptop().add(l1);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry serRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(serRegistry);
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(s1);
		session.save(l1);
		
		session.getTransaction().commit();
	}
}
