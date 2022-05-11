<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter patient</title>
</head>
<body>
<h1>Ajouter un patent</h1>
<form action="guru_register" method="post">
			<table style="with: 50%">
				<tr>
					<td>Nom</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Prénom</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>NSS</td>
					<td><input type="text" name="nss" /></td>
				</tr>
					
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contact" /></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>
</body>
</html>