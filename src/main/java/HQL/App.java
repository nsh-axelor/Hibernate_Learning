package HQL;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry ser = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(ser);
		Session session = sf.openSession();
		
		session.beginTransaction();
		
//		for(int i = 1;i<=50;i++) {
//			Student student = new Student();
//			student.setName("Student "+i);
//			student.setRollno(i);
//			student.setMark(random.nextInt(100));
//			session.save(student);
//		}

//		Query query = session.createQuery("from Student where mark>50");
//		List<Student> students = query.list();

	
//		for(Student student:students) {
//			System.out.println(student);
//		}
		
		
//		Query query = session.createQuery("from Student where mark=72");
//		Student student = (Student) query.uniqueResult();
		
//		session.getTransaction().commit();
//		System.out.println(student);
		
		
//		Query query = session.createQuery("select name,rollno,mark from Student where mark>=66");
//		List<Object[]> results = (List<Object[]>)query.list();
	
//		for(Object[] result:results) {
//			System.out.println(result[0]+" "+result[1]+" "+result[2]);
//		}
	
		
//		Query query = session.createQuery("select name from Student where mark>=66");
//		List<String> names = (List<String>)query.list();
//		for(String name:names) {
//			System.out.println(name);
//		}
		
//		int b = 40;
//		Query query = session.createQuery("select sum(mark) from Student where rollno> :rollNoValue");
//		query.setParameter("rollNoValue",b);
//		Long sumofMarks = (Long)query.uniqueResult();
//		
//		System.out.println(sumofMarks);
		
		session.getTransaction().commit();
	}

}
