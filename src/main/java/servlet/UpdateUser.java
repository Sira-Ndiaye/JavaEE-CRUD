package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDAO;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_USERS = "/WEB-INF/liste.jsp";
	private static final String VUE_MODIFY_USER = "/WEB-INF/modifyUser.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.valueOf(req.getParameter("id"));

		
		req.setAttribute("user", UtilisateurDAO.findUser(id));
		
		getServletContext().getRequestDispatcher(VUE_MODIFY_USER).forward(req, resp);
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id =  Integer.valueOf(req.getParameter("id"));
			System.out.print(id);
			String prenom = req.getParameter("prenom");
			String nom = req.getParameter("nom");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			Utilisateur lambda = new Utilisateur(nom,prenom,username,password);
			UtilisateurDAO.update(id,lambda);
			
			resp.sendRedirect("Liste");
		}

	private String getParameter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
