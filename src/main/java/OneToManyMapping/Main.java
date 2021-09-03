package OneToManyMapping;


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
			
			Book b1 = new Book();
			b1.setBid(1);
			b1.setBname("DBMS");
			
			Book b2 = new Book();
			b1.setBid(2);
			b1.setBname("DS");
			
			s1.getBook().add(b1);
			s1.getBook().add(b2);
			
			Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);
			ServiceRegistry serRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			SessionFactory sf = config.buildSessionFactory(serRegistry);
			Session session = sf.openSession();
			
			session.beginTransaction();
			
			session.save(s1);
			session.save(b1);
			session.save(b2);
			
			session.getTransaction().commit();
		}
	}


