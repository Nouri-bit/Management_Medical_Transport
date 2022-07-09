<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjoutKm</title>
<link rel="stylesheet" href="valid_man.css">




</head>
<body>
<%@ include file="topnav.jsp" %>
<h1>Séances non Validées</h1>
<div class="main">
<c:forEach items="${products}" var="compte">
<form action="<%= request.getContextPath() %>/ValidManuelServlet" method="post" >
<div>
    
    <div class="séance">
       
        <div>
            <div >
             
                <h2>${compte.titre}</h2>
                <p> <b> NSS du chauffeur:</b> ${compte.idchauffeur}</p>
                 <p><b> date :</b> ${compte.date}</p>
                 <p ><b > Distance minimale :</b> ${compte.distance} km</p>
                   <p ><b> Etat :</b> ${compte.etat} </p>
                <p > <b > Distance donnée par l'opérateur :</b> ${compte.kmreel} km</p>
                  <input type="hidden" name="idseance" value="${compte.idseance}">
                    <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden"  name="idchauffeur" value="${compte.idchauffeur}">
                     <c:if test="${compte.etat == 'Non valide'}">
                    <input type="hidden" name="idseance" value="${compte.idseance}">
                    <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden"  name="idchauffeur" value="${compte.idchauffeur}">
                	<button class="btn" style="background-color:#61da61;">Valider</button> 
                </c:if>
                <a href="reclam" class="btn" style="background-color:#e23d3d ;">Réclamer</button>
                
                <a href="Cartographie" class="btn" style="background-color:#0064AC ;">Visualiser sur la map</a>
            </div>
        </div>
        <hr style="height:1px;border:none;color:rgb(168, 168, 168);background-color:rgb(168, 168, 168)" />
          
    </div>
   
</div>
</form>

 </c:forEach> 

 </div>
 <div class="bottomdiv">
 
 </div>

</body>
</html>