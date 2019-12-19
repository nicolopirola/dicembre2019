package base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestImpiegato {

	public static void main(String[] args) {
		
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	    Metadata meta = new MetadataSources(sr).getMetadataBuilder().build();
	    SessionFactory sf = meta.getSessionFactoryBuilder().build();
	    
	    Session session = sf.openSession();
	    Transaction trx = session.beginTransaction();
	    
	    Impiegato imp = new Impiegato();
	    
	    imp.setId(3);
	    imp.setFirstname("Nicolò");
	    imp.setLastname("Pirola");
	    
	    session.save(imp);
	    trx.commit();
	    
	    imp = session.get(Impiegato.class, 1);
	    System.out.println("Ecco i dati per l'utente con id #1: " + imp.getFirstname() + " " + imp.getLastname());
	    session.close();
	    sf.close();
	    sr.close();
	    
	}

}
