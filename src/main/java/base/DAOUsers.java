package base;

import java.util.List;

import entity.Users;

public interface DAOUsers {
	
	//metodo per accedere all'utente della tabella (se restituisce un oggetto di tipo int perche si rifà all id
	Users getUsers(int id); 
	//per recuperare tutti gli utenti all interno della tabella
	List <Users> getAllUsers();
	
	//per aggiungere un utente, quello che gli passo io nel metodo
    void addUser (Users user);
    
    //per fare l upgrade
    void updUser (Users user);
    
    //per cancellarlo mi basta avere l id
    void deleteUser (int id);

}
