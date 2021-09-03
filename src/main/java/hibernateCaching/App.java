package hibernateCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
//		Name n = new Name();
//		n.setFirstName("Nandit");
//		n.setLastName("Shah");
//		
//		Alien alien = new Alien();
//		alien.setAid(3);
//		alien.setName(n);
//		alien.setColor("White");
		
		
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		session.beginTransaction();
		
//		session.save(alien);
		
		Alien fetchedAlien = (Alien) session.get(Alien.class, 1);
		System.out.println(fetchedAlien);
		
		Alien fetchedAlien2 = (Alien) session.get(Alien.class, 1);
		System.out.println(fetchedAlien2);
		
		
		session.getTransaction().commit();
	
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
//		session.save(alien);
		
		Alien fetchedAlien3 = (Alien) session2.get(Alien.class, 1);
		System.out.println(fetchedAlien3);
		
		Alien fetchedAlien4 = (Alien) session2.get(Alien.class, 1);
		System.out.println(fetchedAlien4);
		
		session2.getTransaction().commit();
		
	}
}
