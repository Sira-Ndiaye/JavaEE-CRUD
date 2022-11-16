package dao;

import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDAO {
	
	private static final ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
	private static int lastId=1;
	static {
		users.add(new Utilisateur("admin","admin","admin","admin"));
	}
	
	
	public static void addUser(Utilisateur u) {
		u.setId(lastId++);
		users.add(u);
	}
	
	public static ArrayList<Utilisateur> listUsers () {
		return users;
	}
	
	public static void remove (int id) {
		for(Utilisateur user : users) {
			if(user.getId() == id) {
				users.remove(user);
				break;
			}
		}
	}
	
	// TODO:HANDLE ERROR WHEN PREVIOUSLY DELETED USER
	public static void update (int id,Utilisateur modifiedUser) {
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getId() == id) {
				modifiedUser.setId(id);
				users.set(i, modifiedUser);
				break;
			}
		}
	}
	
	public static Utilisateur findUser (int id) {
		for(Utilisateur user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	
	public static Utilisateur findUser (String username) {
		for(Utilisateur user : users) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	public static Utilisateur login (String username, String password) {
		for(Utilisateur user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
}
