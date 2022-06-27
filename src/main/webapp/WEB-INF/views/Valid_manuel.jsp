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

<h1>SÃ©ances non ValidÃ©es</h1>
<div class="main">
<c:forEach items="${products}" var="compte">
<form action="<%= request.getContextPath() %>/ValidManuelServlet" method="post" >
<div>
    
    <div class="sÃ©ance">
       
        <div>
            <div >
             
                <h2>${compte.titre}</h2>
                <p> NSS du chauffeur: ${compte.idchauffeur}</p>
                 <p>date :${compte.date}</p>
                 <p > Distance minÃ©male : <b >${compte.distance}</b> km</p>
                   <p > Etat : <b >${compte.etat}</b> </p>
                <p > Distance donnÃ©e par l'opÃ©rateur : <b >${compte.kmreel}</b> km</p>
                  <input type="hidden" name="idseance" value="${compte.idseance}">
                    <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden"  name="idchauffeur" value="${compte.idchauffeur}">
                     <c:if test="${compte.etat == 'Non valide'}">
                    <input type="hidden" name="idseance" value="${compte.idseance}">
                    <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden"  name="idchauffeur" value="${compte.idchauffeur}">
                	<button class="btn" style="background-color:#61da61;">Valider</button> 
                </c:if>
                <button class="btn" style="background-color:#e23d3d ;">RÃ©clamer</button>
                <button class="btn" style="background-color:#0064AC ;">Visualiser sur la map</button>
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