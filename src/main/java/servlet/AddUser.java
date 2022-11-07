package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDAO;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_ADD_USERS = "/WEB-INF/addUser.jsp";

    public AddUser() { }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		getServletContext().getRequestDispatcher(VUE_ADD_USERS).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(prenom.isEmpty() || nom.isEmpty()) {
			request.setAttribute("pass",false);
			request.getServletContext().getRequestDispatcher(VUE_ADD_USERS).forward(request, response);
		}else {
			Utilisateur lambda = new Utilisateur(nom,prenom,username,password);
			UtilisateurDAO.addUser(lambda);
			
			response.sendRedirect("Liste");
		}
		
		

	}

}
