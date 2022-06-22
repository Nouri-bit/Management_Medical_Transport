<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>NavebarPage</title>
  <link href="profil.css" rel="stylesheet">
  <link href="images/logo_CNAS.png">
  <link href="images/alex.png">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<title>CSS User Profile Card</title>
	<link rel="stylesheet" href="styles.css">
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
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

<div class="wrapper" method="get" action="">
    <div class="left">
        <img src="https://i.imgur.com/cMy8V5j.png" 
        alt="user" width="100">
        <h4>Ben Aissa Kamal</h4>
         <p>Chauffeur</P>
    </div>
    <div class="right">
        <div class="info">
            <h3>Identité</h3>
            <div class="info_data">
                 <div class="data">
                    <h4>Nom et Prénom</h4>
                    <p>Ben Aissa Kamal</p>
                 </div>
                 <div class="data">
                   <h4>Numéro de sécurité social</h4>
                    <p>0001213998761</p>
              </div>
            </div>
        </div>
      
      <div class="projects">
            <h3>Autres</h3>
            <div class="projects_data">
                 <div class="data">
                    <h4>Adresse Mail</h4>
                    <p>kl_benaissa@gmail.com</p>
                 </div>
                 <div class="data">
                   <h4>Type de véhicule</h4>
                    <p>Ambilance</p>
              </div>
            </div>
        </div>
    </div>
</div>

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