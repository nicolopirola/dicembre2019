package base;

import java.util.Scanner;

import entity.Users;

public class TestDAOUsersWithAnnotations {

	static Users user; // DTO
	static Scanner sc = new Scanner(System.in);
	static DAOUsers dui = new DAOUsersImplWithAnnotations();

	public static void main(String[] args) {

		int scelta;

		((DAOUsersImplWithAnnotations) dui).connessione();

		do {
			System.out.println("***GESTIONE UTENTI***");
			System.out.println("Specificare una delle seguenti opzioni: ");
			System.out.println("1. Inserimento");
			System.out.println("2. Modifica");
			System.out.println("3. Lettura");
			System.out.println("4. Lettura di tutti gli utenti");
			System.out.println("5. cancellazione");
			System.out.println("9. Uscita");

			scelta = sc.nextInt();
			switch (scelta) {
			case 1:
				inserimento();
				break;
			case 2:
				modifica();
				break;
			case 3:
				lettura();
				break;
			case 4:
				letturaAll();
				break;
			case 5:
				cancellazione();
				break;
			case 9:
				((DAOUsersImplWithAnnotations) dui).uscita();
				System.out.println("**ARRIVEDERCI**");

				break;
			default:
				System.out.println("Scelta efffettuata non valida: riprovare");
			}
		} while (scelta != 9);
	}

	private static void cancellazione() {

		System.out.println("Inserire numero ID che si vuole cancellare: ");
		int idsel = sc.nextInt();
		sc.nextLine();

		dui.deleteUser(idsel);

	}

	private static void letturaAll() {

		for (Users k : dui.getAllUsers()) {
			k.printUtente();
		}
	}

	private static void lettura() {

		System.out.println("Specificare l'id dello user di cui si vogliono vedere i dettagli");
		user = dui.getUsers(sc.nextInt());
		sc.nextLine();
		if (user != null) {
			user.printUtente();
		}
	}

	private static void modifica() {

		user = new Users();

		System.out.println("Indicare l'ID dell'utente di cui modificare i parametri");
		user.setId(sc.nextInt());
		sc.nextLine();

		if (((DAOUsersImplWithAnnotations) dui).checkUserId(user.getId()) == true) {

			System.out.println("Specificare il nome del nuovo utente: ");
			user.setName(sc.nextLine());
			System.out.println("Specificare l'indirizzo del nuovo utente: ");
			user.setAddress(sc.nextLine());
			System.out.println("Specificare l'email del nuovo utente: ");
			user.setEmail(sc.nextLine());
			System.out.println("Specificare il telefono del nuovo utente: ");
			user.setPhone(sc.nextLine());

			dui.updUser(user);
		} else
			System.out.println("ID ricercato non presente in tabella");
	}

	private static void inserimento() {

		user = new Users();
		System.out.println("Specificare l'id del nuovo utente: ");
		user.setId(sc.nextInt());
		sc.nextLine();

		if (((DAOUsersImplWithAnnotations) dui).checkUserId(user.getId()) == false) {
			System.out.println("Specificare il nome del nuovo utente: ");
			user.setName(sc.nextLine());
			System.out.println("Specificare l'indirizzo del nuovo utente: ");
			user.setAddress(sc.nextLine());
			System.out.println("Specificare l'email del nuovo utente: ");
			user.setEmail(sc.nextLine());
			System.out.println("Specificare il telefono del nuovo utente: ");
			user.setPhone(sc.nextLine());

			dui.addUser(user);
		} else
			System.out.println("L'id inserito è gia presente in tabella, impossibile effettuare l'operazione");
	}

}
