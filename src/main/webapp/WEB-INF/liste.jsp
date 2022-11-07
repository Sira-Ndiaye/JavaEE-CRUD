<%@page import="beans.Utilisateur, java.util.ArrayList"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%
	final String APP_ROOT = request.getContextPath();
	ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) request.getAttribute("users"); 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link href="<%=APP_ROOT%>/ressources/bootstrap.min.css" rel="stylesheet">
	<script src="<%= APP_ROOT %>/js/script.js"></script>
</head>
<body>
	<%@include file='/WEB-INF/menu.jsp' %>
	<div class="container mt-3">
		<h1 id="titre-principal">Liste des utilisateurs</h1>
		<div class="my-5">
			<%
				if(users.isEmpty())
				{%>
					<p>La liste des utilisateurs est pour le moment vide !</p><%
				}
				else
				{%>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>ID</th>
								<th>Prénom</th>
								<th>Nom</th>
								<th>Login</th>
								<th>Password</th>
								<th colspan="2">Actions</th>
							</tr>
						</thead>
						<tbody>
						<%
						for (Utilisateur user : users)
						{%>
							<tr>
								<td><%= user.getId() %></td>
								<td><%= user.getPrenom() %></td>
								<td><%= user.getNom() %></td>
								<td><%= user.getUsername() %></td>
								<td><%= user.getPassword() %></td>
								<td><a href="<%= APP_ROOT %>/update?id=<%= user.getId() %>">Modifier</a></td>
								<td><a href="<%= APP_ROOT %>/delete?id=<%= user.getId() %>" onclick="return confirmSuppression()">Supprimer</a></td>
							</tr><%
						}%>
						</tbody>
					</table>
					<%
				}
			%>
		</div>
		<div class="small" id="pied">Copyright Sira Ndiaye &copy; November 2022</div>
	</div>
	
</body>
</html>