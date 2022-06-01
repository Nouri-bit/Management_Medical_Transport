<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>liste des chauffeurs</title>
    <link href="ChauffeursList.css" rel="stylesheet">
    <link href="images/logo_CNAS.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
<title>list des chauffeurs</title>
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
<form action="<%= request.getContextPath() %>/ChauffeurServlet" method="get">
<div class="Title">
   <h1>Chauffeurs</h1>
</div>
<c:forEach items="${products}" var="compte">
<div class="card" style="max-width: 300px;" onclick="location.href='#';">
  
  <img class="image" src="${compte.photo}" alt="Avatar" style="width:70%">
  <div class="container">
    <h4><b>${compte.nom} ${compte.prenom}</b></h4> 
    <p> ${compte.nss}</p>
  </div>
</div>
	</c:forEach>
</form>
<!-- 
<div class="card" style="max-width: 300px;">
  <img class="image" src="image.jpg" alt="Avatar" style="width:70%">
  <div class="container">
    <h4><b>name </b></h4> 
    <p  > 0123456</p>
  </div>
</div>

<div class="card" style="max-width: 300px;">
  <img class="image" src="image.jpg" alt="Avatar" style="width:70%">
  <div class="container">
    <h4><b>name </b></h4> 
    <p  > 0123456</p>
  </div>
</div>

<div class="card" style="max-width: 300px;">
  <img class="image" src="image.jpg" alt="Avatar" style="width:70%">
  <div class="container">
    <h4><b>name </b></h4> 
    <p  > 0123456</p>
  </div>
</div>

<div class="card" style="max-width: 300px;">
  <img class="image" src="image.jpg" alt="Avatar" style="width:70%">
  <div class="container">
    <h4><b>name </b></h4> 
    <p  > 0123456</p>
  </div>
</div>

</div>
-->
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