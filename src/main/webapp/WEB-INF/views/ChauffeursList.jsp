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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
<title>list des chauffeurs</title>
</head>
<body>
<%@ include file="topnav.jsp" %>
    
<form action="<%= request.getContextPath() %>/ChauffeurServlet" method="get">
<div class="Title">
   <h1>Chauffeurs</h1>
</div>
<div class="cards">
<c:forEach items="${products}" var="compte">
<div class="card" style="max-width: 300px;" onclick="location.href='ProfileServlet?nss=${compte.nss}';">
  
  <img class="image" src="${compte.photo}" alt="Avatar" style="width:70%">
  <div class="container">
    <h4><b>${compte.nom} ${compte.prenom}</b></h4> 
    <p> ${compte.nss}</p>
  </div>
</div>
</c:forEach>
</div>
</form>

<footer>
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
  </footer>  

  
</body>
</html>