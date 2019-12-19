package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import entity.Users;

public class DAOUsersImplWithAnnotations implements DAOUsers {

	Users user;
	List<Users> list;
	Scanner sc = new Scanner(System.in);

	Session session;
	Transaction trx;
	static StandardServiceRegistry sr;
	static SessionFactory sf;

	public void connessione() {
		SessionFactory sf;
		System.out.println("Connessione in corso");

		sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg2.xml").build();
	    Metadata meta = new MetadataSources(sr).getMetadataBuilder().build();
	    sf = meta.getSessionFactoryBuilder().build();
		session = sf.openSession();
		trx = session.beginTransaction();

	}

	@Override
	public Users getUsers(int id) {

		user = session.get(Users.class, id);

		return user;
	}

	@Override
	public List<Users> getAllUsers() {

		List<Users> list = new ArrayList<>();
		Query<Users> query = session.createQuery("from Users");
		list = query.list();

		return list;
	}

	@Override
	public void addUser(Users user) {

		this.user = new Users();
		if (user != null) {
			if (StringUtils.isNumeric(user.getPhone()) == true) {

				System.out.println("*** Inserimento avvenuto con successo***");
			} else
				System.out.println("Operazione senza successo: errore nell'inserimento del numero");

		} else
			System.out.println("Nessun riferimento è stato passato per elaborare i dati");
		session.save(user);
	}

	@Override
	public void updUser(Users user) {

		this.user = new Users();

		if (StringUtils.isNumeric(user.getPhone()) == true) {

			this.user = session.get(Users.class, user.getId());
			this.user.setName(user.getName());
			this.user.setAddress(user.getAddress());
			this.user.setEmail(user.getEmail());
			this.user.setPhone(user.getPhone());

			System.out.println("*** Update avvenuto con successo***");

		} else
			System.out.println("Operazione senza successo: errore nell'inserimento del numero");

		session.save(this.user);
	}

	@Override
	public void deleteUser(int id) {

		user = session.get(Users.class, id);
		session.delete(user);
		System.out.println("Utente cancellato correttamente");

	}

	public boolean checkUserId(int id) {

		user = session.get(Users.class, id);
		return (user != null);
	}

	public void uscita() {
		String risposta;

		System.out.println("Vuoi salvare le modifiche? (Si/No)");
		risposta = sc.nextLine();
		if (risposta.equalsIgnoreCase("si")) {
			System.out.println("E' stato un piacere, alla prossima");
			trx.commit();
			session.close();
//			sf.close();
			sr.close();

		} else if (risposta.equalsIgnoreCase("no")) {
			System.out.println("ok");
			trx.rollback();
			session.close();
			System.out.println(sf);
			System.out.println(sr);
//			sf.close();
			sr.close();
		} else
			System.out.println("La risposta non è valida");
	}
}
