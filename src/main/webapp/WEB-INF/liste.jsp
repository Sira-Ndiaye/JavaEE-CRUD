<%@page import="beans.Utilisateur, java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<c:choose>
				<c:when test="${empty requestScope.users }">
					<p>La liste des utilisateurs est pour le moment vide !</p>
				</c:when>
				<c:otherwise>
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
							<c:forEach items="${users}" var="user">
								<tr>
									<td>${user.id }</td>
									<td>${user.prenom }</td>
									<td>${user.nom }</td>
									<td>${user.username }</td>
									<td>${user.password }</td>
									<td><a href="<c:url value='/update?id=${user.id}'/>">Modifier</a></td>
									<td><a href="<c:url value='/delete?id=${user.id}'/>" onclick="return confirmSuppression()">Supprimer</a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
						
				</c:otherwise>
			</c:choose>
		</div>
		<div class="small" id="pied">Copyright Sira Ndiaye &copy; November 2022</div>
	</div>
	
</body>
</html>