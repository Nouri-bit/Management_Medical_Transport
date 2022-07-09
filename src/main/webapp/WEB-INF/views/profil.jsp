<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Profile</title>
  <link href="profil.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ include file="topnav.jsp" %>
<form action="<%= request.getContextPath() %>/ProfileServlet" method="get">
<div class="main" >
<div class="wrapper">

    <div class="left">
        <img src="https://img.freepik.com/photos-gratuite/image-profil-jeune-hipster-mode-coiffure-mode-barbe-epaisse-au-gingembre_343059-3602.jpg?t=st=1656411950~exp=1656412550~hmac=f333c0fb3c0e670ff20f629c04d538d1b34c0af92e8a3a49cd5ea1f24686782b&w=740"
         width="100">
        <h4 >${nom} ${prenom}</h4>
         <p>Chauffeur</P>
    </div>
    <div class="right">
        <div class="info">
            <h3>${nom} ${prenom}</h3>
            <div class="info_data">
                 <div class="data">
                   <h4>Numéro de sécurité social</h4>
                    <p>${nss}</p>
              </div>
              <div class="data">
                <h4>Adresse Mail</h4>
                <p>${mail}</p>
             </div>
    
            </div>
        </div>
      
      <div class="projects">
           
            <div class="projects_data">
                 
                 <div class="data">
                  
              </div>
            </div>
        </div>
    </div>
  
</div>
</div>
</form>
</body>
</html>