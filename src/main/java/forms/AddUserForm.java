package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDAO;

public class AddUserForm {
	
	private HttpServletRequest req;
	
	private Utilisateur user;
	private Map<String,String> erreurs;
	
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_USERNAME = "username";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordbis";
	
	private static final String MESSAGE_ERROR_FIELD = "Champ obligatoire";
	private static final String INVALIDE_PASSWORD_ERROR_MESSAGE = "Les mots de passe ne sont pas les mêmes";
	
	private boolean status;
	private String statusMessage;
	
	
	
	public AddUserForm(HttpServletRequest request) {
		this.req = request;
		this.erreurs = new HashMap<String, String>();
	}
	
	public boolean ajouter() {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String username = getParameter(CHAMP_USERNAME);
		String password = getParameter(CHAMP_PASSWORD);
		String passwordbis = getParameter(CHAMP_PASSWORD_BIS);
		
		user = new Utilisateur(nom,prenom,username,passwordbis);
		
		validerChamps(CHAMP_NOM,CHAMP_PRENOM,CHAMP_USERNAME,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		validerPasswords();
		
		if(erreurs.isEmpty()) {
			UtilisateurDAO.addUser(user);
			status = true;
			statusMessage= "Utilisateur ajouté avec succes";
		}else {
			status = false;
			statusMessage= "Echec!!";
		}
		return status;
		
	}
	
	private String getParameter(String params) {
		String valeur = this.req.getParameter(params);
		return (valeur ==null || valeur.trim().isEmpty()) ? null : valeur.trim();
	}
	
	private void validerChamps(String... params ) {
		for(String param : params) {
			if(this.getParameter(param) == null){
				erreurs.put(param,MESSAGE_ERROR_FIELD);
			}
		}
	}
	
	private void validerPasswords() {
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordbis = this.getParameter(CHAMP_PASSWORD_BIS);
		
		if(password!=null && !password.equals(passwordbis)) {
			erreurs.put(CHAMP_PASSWORD,INVALIDE_PASSWORD_ERROR_MESSAGE);
			erreurs.put(CHAMP_PASSWORD_BIS,INVALIDE_PASSWORD_ERROR_MESSAGE);

		}
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public boolean getStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	
	
}

