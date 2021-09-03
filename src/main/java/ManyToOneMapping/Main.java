package ManyToOneMapping;


	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.service.ServiceRegistry;
	import org.hibernate.service.ServiceRegistryBuilder;

	public class Main {
		public static void main(String[] args) {
			Student s1 = new Student();
			s1.setMarks(100);
			s1.setName("Nandit");
			s1.setRollNo(55);
			
			Student s2 = new Student();
			s2.setMarks(100);
			s2.setName("Nandit");
			s2.setRollNo(55);
			
			Book b1 = new Book();
			b1.setBid(1);
			b1.setBname("DBMS");
			
			b1.getStudent().add(s1);
			b1.getStudent().add(s2);
			
			s1.getBook().add(b1);
			s2.getBook().add(b1);
			
			Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);
			ServiceRegistry serRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			SessionFactory sf = config.buildSessionFactory(serRegistry);
			Session session = sf.openSession();
			
			session.beginTransaction();
			
			session.save(s1);
			session.save(s2);
			session.save(b1);
			
			session.getTransaction().commit();
		}
	}


