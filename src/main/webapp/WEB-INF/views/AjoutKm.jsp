

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjoutKm</title>
<link rel="stylesheet" href="AjoutKm.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NavebarPage</title>
<link href="top_bottom_nav.css" rel="stylesheet">
<link href="images/logo_CNAS.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>



</head>
<body>
<%@ include file="topnav.jsp" %>

<h1>Mes séances</h1>
<div class="main">
<c:forEach items="${products}" var="compte">
<form action="<%= request.getContextPath() %>/Kelomtrage" method="post" >
<div>
    
    <div class="séance">
       
        <div>
            <div >
             
                <h2>${compte.titre}</h2>
                 <p>${compte.date}</p>
           
                 <p>${compte.idpatient}</p>
                 <p>${compte.idchauffeur}</p>
                 <p>${compte.etat}</p>

                 <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden" name="idchauffeur" value="${compte.idchauffeur}">
                   
                    <input type="hidden" name="idseance" value="${compte.idseance}">
                   
                	
                <c:if test="${compte.kmreel == 0.0}">
                	<input type="text" name="kmreel" />
                    <input type="hidden" name="idseance" value="${compte.idseance}">
                    <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden"  name="idchauffeur" value="${compte.idchauffeur}">
                	<button id="btn">Ajouter Km</button>
                </c:if>
                <p > <b >${compte.kmreel} </b> km</p>
         
            </div>
        </div>
        <hr style="height:1px;border:none;color:rgb(168, 168, 168);background-color:rgb(168, 168, 168)" />
          
    </div>
   
</div>



</form>

 </c:forEach> 
 </div>
 
 

</body>
</html>