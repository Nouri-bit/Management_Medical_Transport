<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter patient</title>
<link rel="stylesheet" href="style.css">
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
					<td>attente </td>
					<td><input type="text" name="attente" /></td>
				</tr>
				</table>
				
								<br>
				<h3>Jours de la semaine</h3>
				<table id ="table_jours"> 
				<tr>
				<td><input type="checkbox" name="samedi" /> <label for="samedi">samedi</label></td>
				<td><input type="checkbox" name="dimanche" /> <label for="dimanche">dimanche</label></td>
				 <td><input type="checkbox" name="Lundi" /> <label for="Lundi">Lundi</label></td>
				 </tr>
				 <tr>
				<td><input type="checkbox" name="Mardi" /> <label for="Mardi">Mardi</label></td>
				<td><input type="checkbox" name="mercredi" /> <label for="mercredi">Mercredi</label></td>
				<td><input type="checkbox" name="Jeudi" /> <label for="Jeudi">Jeudi</label></td>
				 </tr>
				 <tr>
				<td><input type="checkbox" name="Vendredi" /> <label for="Vendredi">Vendredi</label></td>
				 </tr>
				</table>
				<br>
				<h3>Tranche</h3>
				<table id ="table_tranche"> 
				<tr>
				<td><input type="checkbox" name="tr1" /> <label for="tr1">Tranche 1</label></td>
				<td><input type="checkbox" name="tr2" /> <label for="tr2">Tranche 2</label></td>
				 <td><input type="checkbox" name="tr3" /> <label for="tr3">Tranche 3</label></td>
				 </tr>
				
				</table>
				
			<input type="submit" value="Submit" /></form>
</body>
</html>