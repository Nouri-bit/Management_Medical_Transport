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

<h1>Les séances</h1>
    <form action="<%= request.getContextPath() %>/Kelomtrage" method="post" >
<div class="main">
<div>
    <c:forEach items="${products}" var="compte">
    <div class="séance">
       
        <div>
            <div >
             
                <h1 >${compte.titre}</h1>
                 <p >${compte.date}</p>
                <p>texte descriptif</p>
            
                    <input type="text" name="kmreel" />
                    <input type="hidden" type="text" name="idseance">
                <p id="kmtxt"> <b >${compte.kmreel} </b> km</p>
                
                    <button id="btn">Ajouter Km</button>
                    <script>
                        const btn = document.getElementById('btn');
                    
                        btn.addEventListener('click', () => {
                          const kmtxt=document.getElementById('kmtxt');
                          const form = document.getElementById('form');
                          if(btn.innerHTML == "Ajouter Km" || btn.innerHTML == "Modifier")
                          {
                            kmtxt.style.visibility = 'hidden';
                            form.style.display = 'block';
                           btn.innerHTML = "Sauvgarder";
                            btn.style.backgroundColor="#895aee"
                        } 
                           else{
                            if(btn.innerHTML == "Sauvgarder")
                          {  
                            
                           form.style.display = 'none';
                           kmtxt.style.visibility = 'visible';
                           btn.innerHTML = "Modifier";} 
                           }
                    

                          
                          /*if (kmtxt.style.visibility === 'hidden') {
                            kmtxt.style.visibility = 'visible';
                            } else {
                            kmtxt.style.visibility = 'hidden';
                            }*/
                        });
                        
                       

                        
                        </script>
                     
            </div>
        </div>
        <hr style="height:1px;border:none;color:rgb(168, 168, 168);background-color:rgb(168, 168, 168)" />
          
    </div>
    </c:forEach> 
</div>


</div>
</form>
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
</html>