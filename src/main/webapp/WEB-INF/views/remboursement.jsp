<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjoutKm</title>
<link rel="stylesheet" href="remboursement.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NavebarPage</title>
<link href="top_bottom_nav.css" rel="stylesheet">
<link href="images/logo_CNAS.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>

</head>
<body>

  <div class="nav">
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
</div>

<div class="aa_htmlTable">
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
                <td>20</td>
              </tr>
            </c:forEach>  
          </tbody>
        </table>
        <table>
            <thead>
              <tr>
                <th>Total</th>
                <th>5 670 000,00 </th>
              </tr>
            </thead>
          </table>
          <button type="submit">Imprimer</button>
          </c:forEach>
    </form>
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