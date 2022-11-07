<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	final String APP_ROOT = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ADD</title>
	<link href="<%=APP_ROOT%>/ressources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@include file='/WEB-INF/menu.jsp' %>
	<div class="container mt-3">
		<h1>Ajouter un nouvel utilisateur</h1>
		<form method="post" action="AddUser" class="mt-5">
		  <div class="form-group">
		  	<label for="prenom">Prenom : </label>
			<input type="text" class="form-control" name="prenom" id="prenom"/>
		  </div>
		  
		  <div class="form-group">
		    <label for="nom">Nom: </label>
			<input type="text" class="form-control" name="nom" id="nom"/>
		  </div>
		  
  		  <div class="form-group">
		    <label for="username"> Username: </label>
			<input type="text" class="form-control" name="username" id="username"/>
		  </div>
		  
		  <div class="form-group">
		    <label for="password">Password:</label>
		    <input type="password" class="form-control" name="password" id="password">
		  </div>
		  
		  <button type="submit" class="btn btn-primary">VALIDER</button>
		  
		</form>
		<%
			if(request.getAttribute("pass")!=null){
		%>
				<p class="text-danger mt-3">Remplissez au moins votre Nom et Prenom</p>
		<%	
			}
		%>
	
	</div>
</body>
</html>