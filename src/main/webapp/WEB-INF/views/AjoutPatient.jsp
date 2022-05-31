<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Ajouter patient</title>
<link rel="stylesheet" href="AjouterPatient.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NavebarPage</title>
<link href="top_bottom_nav.css" rel="stylesheet">
<link href="images/logo_CNAS.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
</head>

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
    <nav class="topNav">
        <label class="toggle">
            <i class="fa fa-bars"></i>
        </label>
        <ul>
           <li><a href='#'>Ajouter une demande</a></li>
           <li><a href='#'>Tableau des écarts</a></li>
           <li><a href='#'>Planning </a></li>
           <li><a href='#'>Cartographie</a></li>
           <li><a href='#'>Remboursements</a></li>
        </ul> 
        <div class="logo_cnas">
            <a href=""><img src="images/logo_CNAS.png" width="80px" height="60px"/></a>
        </div>
        <div class="socialtop">
            <div class='top-social'>
                <a href='#'><i class="fa-regular fa-envelope"></i></a>
                <a href='#'><i class="fa-regular fa-bell"></i></a>
                <a href='#'><i class="fa-regular fa-circle-user"></i></a>
            </div>
        </div>
    </nav>

<h1>Ajouter un patient</h1>
<form action="<%= request.getContextPath() %>/AjoutPatient" method="post">
			<table style="width: 50%">
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

            <nav class="bottomNav">
                <label class="toggle1">
                        <div class='top-social1'>
                            <a href='#'><i class="fa-solid fa-house"></i></a>
                            <a href='https://web.facebook.com/'><i class="fa-brands fa-facebook"></i></a>
                        </div>
                </label>
                <div class="label_cnas">
                    <a href=""><img/>Caisse Nationale des Assurances Sociales des Travailleurs Salariés</a>
                </div>
                <div class="socialtop1">
                    <div class='top-social1'>
                        <a href='#'><i class="fa-solid fa-circle-question"></i></a>
                        <a href='https://www.youtube.com/'><i class="fa-brands fa-youtube"></i></a>
                    </div>
                </div>
            </nav>
            <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
            <script>
                $('.toggle i').click(function () {
                    $('ul').toggleClass("show");
                });
            </script>
</body>
</html>