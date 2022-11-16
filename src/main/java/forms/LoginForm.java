package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDAO;

public class LoginForm {
	
	private HttpServletRequest req;
	
	private Utilisateur user;
	
	private static final String CHAMP_USERNAME = "username";
	private static final String CHAMP_PASSWORD = "password";
	
	private static final String INEXISTANT_USER = "Cet Utilisateur n'existe pas";
	private static final String INVALIDE_PASSWORD_ERROR_MESSAGE = "Mot de passe incorrect";
	
	private boolean status;
	private String statusMessage;
	
	
	public LoginForm(HttpServletRequest request) {
		this.req = request;
	}
	
	public boolean login() {
		String username = getParameter(CHAMP_USERNAME);
		String password = getParameter(CHAMP_PASSWORD);
		status = false;
		user = UtilisateurDAO.findUser(username);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				HttpSession session = req.getSession();
				session.setAttribute("isConnected",true);
				status=true;
			}else {
				statusMessage=INVALIDE_PASSWORD_ERROR_MESSAGE;
			}
		}else{
			statusMessage=INEXISTANT_USER;
		}
		
		return status;
		
	}
	
	
	private String getParameter(String params) {
		String valeur = this.req.getParameter(params);
		return (valeur ==null || valeur.trim().isEmpty()) ? null : valeur.trim();
	}
	

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public boolean getStatus() {
		return status;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}

	
	
}

