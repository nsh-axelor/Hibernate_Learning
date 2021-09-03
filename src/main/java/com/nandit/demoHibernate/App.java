package com.nandit.demoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    Name name = new Name();
    name.setFirstName("Nandit");
    name.setMiddleName("Suhagkumar");
    name.setLastName("Shah");
	Aliens nandit = new Aliens();
	nandit.setAid(101);
	nandit.setAname(name);
	nandit.setColor("white");
	
	Name name1 = new Name();
	name1.setFirstName("Nancy");
    name1.setMiddleName("Ahishkumar");
    name1.setLastName("Solanki");
	Aliens nancy = new Aliens();
	nancy.setAid(102);
	nancy.setAname(name1);
	nancy.setColor("yellow");
//	
	Name name2 = new Name();
    name2.setFirstName("Shail");
    name2.setMiddleName("Suhagkumar");
    name2.setLastName("Shah");
	Aliens shail = new Aliens();
	shail.setAid(103);
	shail.setAname(name2);
	shail.setColor("Any Color");
//	
	Name name3 = new Name();
    name3.setFirstName("Purvi");
    name3.setMiddleName("Suhagkumar");
    name3.setLastName("Shah");
	Aliens purvi = new Aliens();
	purvi.setAid(104);
	purvi.setAname(name3);
	purvi.setColor("Pink");
	
//	Configuring Entire Hibernate settings
	Configuration con = new Configuration().configure().addAnnotatedClass(Aliens.class);
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	SessionFactory sf = con.buildSessionFactory(reg);
	Session session = sf.openSession();
	
//	Initialing Transaction
	Transaction tx = session.beginTransaction();
	
//	For Storing the Object to Database
	session.save(nandit);
	session.save(purvi);
	session.save(nancy);
	session.save(shail);
//	
//	Fetching Data from Database
//	Aliens fetchedData = (Aliens) session.get(Aliens.class, 102);
//	System.out.println(fetchedData);
	
	
	tx.commit();
    }
}
