<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter patient</title>
<link rel="stylesheet" href="style.css">

 <script language="JavaScript">
            var nbCheck = 0;
             
            function isChecked(elmt)
            {
                if( elmt.checked )
                {return true; }
                else
                {return false;}
            }
             
            function clickCheck(elmt)
            {
                if( (nbCheck < 3) || (isChecked(elmt) == false) )
                {
                    if( isChecked(elmt) == true )
                    { nbCheck += 1;}
                    else
                    {nbCheck -= 1;}
                }
                else
                { elmt.checked = ''; }
            }
        </script>
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
				</table>
				<table> 
				<tr>
				<td><input type="checkbox"  id='samedi' value="samedi" name="jour" onclick="clickCheck(this);"/> <label 	>samedi</label></td>
				<td><input type="checkbox" id='dimanche' value="dimanche" name="jour" onclick="clickCheck(this);"/> <label for="dimanche">dimanche</label></td>
				 <td><input type="checkbox" id='lundi' value="Lundi" name="jour" onclick="clickCheck(this);"/> <label for="Lundi">Lundi</label></td>
				 </tr>
				 <tr>
				<td><input type="checkbox" id='Mardi' value="Mardi" name="jour" onclick="clickCheck(this);"/> <label for="Mardi">Mardi</label></td>
				<td><input type="checkbox" id='mercredi' value="mercredi" name="jour" onclick="clickCheck(this);"/> <label for="mercredi" >Mercredi</label></td>
				<td><input type="checkbox" id='Jeudi' value="Jeudi" name="jour" onclick="clickCheck(this);"/> <label for="Jeudi">Jeudi</label></td>
				 </tr>
				 <tr>
				<td><input type="checkbox" id='Vendredi' value="Vendredi" name="jour" onclick="clickCheck(this);"/> <label for="Vendredi">Vendredi</label></td>
				 </tr>
				</table>
				<table>
			
				<tr>
					<td>type </td>
					<td><input type="text" name="type" /></td>
				</tr>
				<tr>
					<td>attente </td>
					<td><input type="text" name="attente" /></td>
				</tr>
				</table>
				<table>
				<tr>
				<td><input type="text" name="tranche" /> <label for="tr1">Tranche 1</label></td>
				 </tr>
				
		</table> 
				
			<input type="submit" value="Submit" /></form>
</body>
</html>