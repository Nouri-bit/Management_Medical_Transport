<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjoutKm</title>
<link rel="stylesheet" href="AjoutKm.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>



</head>
<body>
<%@ include file="topnavOpérateur.jsp" %>

<h1>Mes séances</h1>
<div class="main">
<c:forEach items="${products}" var="compte">
<form action="<%= request.getContextPath() %>/Kelomtrage" method="post" >
<div>
    
    <div class="séance">
       
        <div>
            <div >
             
                <h2>${compte.titre}</h2>
                 <p><b> Date :</b> ${compte.date}</p>
                 <p><b>NSS patient :</b>${compte.idpatient}</p>
                 <c:if test="${compte.attente==true && compte.duree!=0.0}">
                 <p><b>Durée d'attente :</b> ${compte.duree} h</p>
                 </c:if>
                 <p><b>Validation :</b> ${compte.etat}</p>
            
                    <input type="hidden" name="idseance" value="${compte.idseance}">
                    <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden"  name="idchauffeur" value="${compte.idchauffeur}">
                 
                
                <c:if test="${compte.kmreel== 0.0 }">
                <br>
                <c:if test="${compte.attente==true && compte.duree==0.0}">
                	<p >Durée d'attente </p>
                	<input type="text" name="duree"  /> h
                	<input type="hidden" name="idseance" value="${compte.idseance}">
                    <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden"  name="idchauffeur" value="${compte.idchauffeur}">
                  
                </c:if>
                    <p >Distance </p>
                	<input type="text" name="kmreel" />
                	<button id="btn">Ajouter Km</button>
                	<input type="hidden" name="duree" value="${compte.duree}">
                	<input type="hidden" name="idseance" value="${compte.idseance}">
                    <input type="hidden" name="idpatient" value="${compte.idpatient}">
                    <input type="hidden"  name="idchauffeur" value="${compte.idchauffeur}">
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