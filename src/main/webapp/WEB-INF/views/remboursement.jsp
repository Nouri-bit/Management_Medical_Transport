<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remboursement</title>
<link rel="stylesheet" href="remboursement.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NavebarPage</title>
<link href="top_bottom_nav.css" rel="stylesheet">


</head>
<body>
 <%@ include file="topnav.jsp" %>
 
<div class="aa_htmlTable">
<button type="submit" onclick="window.print();return false;" >Imprimer</button>
   <form action="<%= request.getContextPath() %>/RembourssementServlet" method="get">
   <c:forEach items="${products}" var="compte">
        <div class="inputs">
          <div class="left">
            <p class="input_span"><span>${compte.nom}  ${compte.prenom}</span></p>
           <!--  <input type="text" />--> 
          </div>
          <div class="right">
            <p class="input_span" ><span>${compte.nss}</span></p>
            <!--  <input type="number"> -->
          </div>
        </div>
        <c:if test="${compte.total!=0.0}">
        <table>
        
          <thead>
          
            <tr>
              <th>Date</th>
              <th>Tranche</th>
              <th>kilométrage</th>
              <th>Type</th>
              <th>Attente</th>
              <th>Montant</th>
            </tr>
            
          </thead>
          
          <tbody>
          <c:forEach items="${compte.seance}" var="ce">
              <tr>
                <td>${ce.date}</td>
                <td>${ce.tranche}</td>
                <td>${ce.kmreel}</td>
                <td>${ce.type}</td>
                <td>${ce.attente}</td>
                <td>${ce.montant}</td>
              </tr>
            </c:forEach>  
          </tbody>
        </table>
        </c:if>
        <table>
            <thead>
              <tr>
                <th>Total</th>
                <th>${compte.total}</th>
              </tr>
            </thead>
          </table>
          <div class="bottomdiv"></div>
           <hr style="height:1px;border:none;color:rgb(168, 168, 168);background-color:rgb(168, 168, 168)" />
          </c:forEach>
          
    </form>
  </div>
   <div class="bottomdiv"></div>
 <%@ include file="bottomnav.jsp" %>
  </body>