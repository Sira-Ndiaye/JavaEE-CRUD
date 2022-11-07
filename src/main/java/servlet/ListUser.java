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

@WebServlet({"","/Liste"})
public class ListUser extends HttpServlet {
	
	private static final String VUE_USERS = "/WEB-INF/liste.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", UtilisateurDAO.listUsers());
		getServletContext().getRequestDispatcher(VUE_USERS).forward(req, resp);
	}
}
