<%@page import="beans.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	final String APP_ROOT = request.getContextPath();
	Utilisateur user = (Utilisateur) request.getAttribute("user"); 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modification</title>
	<link href="<%=APP_ROOT%>/ressources/bootstrap.min.css" rel="stylesheet">
	
</head>
<body>
	<%@include file='/WEB-INF/menu.jsp' %>
	<div class="container">
	
	<h1>Modification...</h1>
	<%
		if(user == null){
			out.print("<p>Cet utilisateur n'existe pas.</p>");
		}else{
	%>		
		
		<form method="post" class="mt-5">
			<input type="text" style="display:none;" value="${user.id }" name="id" id="id"/>
		
		  <div class="form-group">
		  	<label for="prenom">Prenom : </label>
			<input type="text" value="${ user.prenom }" class="form-control" name="prenom" id="prenom"/>
		  </div>
		  
		  <div class="form-group">
		    <label for="nom">Nom: </label>
			<input type="text" value="${user.nom }" class="form-control" name="nom" id="nom"/>
		  </div>
		  
  		  <div class="form-group">
		    <label for="username"> Username: </label>
			<input type="text" value="${ user.username }" class="form-control" name="username" id="username"/>
		  </div>
		  
		  <div class="form-group">
		    <label for="password">Password:</label>
		    <input type="text" value="${ user.password }" class="form-control" name="password" id="password">
		  </div>
		  
		  <button type="submit" class="btn btn-primary">VALIDER</button>
		  
		</form>
	<%}	%>
	</div>
</body>
</html>