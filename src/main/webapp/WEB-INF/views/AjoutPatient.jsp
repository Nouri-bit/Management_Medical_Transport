<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter patient</title>
</head>
<body>
<h1>Ajouter un patient</h1>
<form action="<%= request.getContextPath() %>/AjoutPatient" method="post">
			<table style="with: 50%">
				<tr>
					<td>Nom</td>
					<td><input type="text" name="nom" /></td>
				</tr>
				<tr>
					<td>Prénom</td>
					<td><input type="text" name="prenom" /></td>
				</tr>
				<tr>
					<td>NSS</td>
					<td><input type="text" name="nss" /></td>
				</tr>
					
				<tr>
					<td>Address</td>
					<td><input type="text" name="addresse" /></td>
				</tr>
				<!--  <tr>
					<td>Id chauffeur </td>
					<td><input type="text" name="idchauffeur" /></td>
				</tr>-->
				<tr>
					<td>Jour de la seance  </td>
					<td><input type="text"  name="jour"/></td>
				</tr>
				<tr>
					<td>titre  </td>
					<td><input type="text"  name="titre" /></td>
				</tr>
				<tr>
					<td>type </td>
					<td><input type="text" name="type" /></td>
				</tr>
				<tr>
					<td>tranche </td>
					<td><input type="text" name="tranche" /></td>
				</tr>
				<tr>
					<td>attente </td>
					<td><input type="text" name="attente" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>