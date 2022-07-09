<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ecarts</title>
<link rel="stylesheet" href="ecart.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NavebarPage</title>
<link href="top_bottom_nav.css" rel="stylesheet">


</head>
<body>
 <%@ include file="topnav.jsp" %>
 
<div class="aa_htmlTable">
  <form action="<%= request.getContextPath() %>/ChauffeurServlet" method="get">
        <table>
          <thead>
            <tr>
              <th>Séance prise en charge</th>
              <th>KM réel</th>
              <th>KM idéal</th>
              <th>Ecart</th>
            </tr>
          </thead>
          
<c:forEach items="${products}" var="compte">
          <tbody>
              <tr>
                <td>${compte.titre}</td>
                <td>${compte.kmreel}</td>
                <td>${compte.distance}</td>
                <td>${compte.kmreel-compte.distance}</td>
              </tr>
          </tbody>
          </c:forEach>
        </table>
    </form>
  </div>
    <div class="bottomdiv">
    </div>
 <%@ include file="bottomnav.jsp" %>
  </body>