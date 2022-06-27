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
<div class="card" style="max-width: 300px;" onclick="location.href='ProfileServlet';">
  
  <img class="image" src="${compte.photo}" alt="Avatar" style="width:70%">
  <div class="container">
    <h4><b>${compte.nom} ${compte.prenom}</b></h4> 
    <p> ${compte.nss}</p>
  </div>
</div>
</c:forEach>
</div>
</form>

<%@ include file="bottomnav.jsp" %>
  
</body>
</html>