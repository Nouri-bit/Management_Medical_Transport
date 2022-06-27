<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="Login.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="nav">
        <nav class="topNav">
          
            <ul>
               <li><a href='#'>page d'accueil</a></li>
            </ul> 
            <div class="logo_cnas">
                <a href=""><img src="https://elhanaa.cnas.dz/resources/images/cnasfond.png" width="50px" /></a>
            </div>
        </nav>
    </div>
    <div class="form">
        <form action="<%= request.getContextPath() %>/Login_servlet" method="POST"> 
            <h1>Se connecter</h1>
            <div class="inputs">
              <p class="input_span"><span>Numéro de sécurité social</span></p>
              <input type="number" name="nss"/>
              <p class="input_span" ><span>Mot de passe</span></p>
              <input type="password" name="pwd">
            </div>
            <div class="pswd_forget">
              <a href="#">Mot de passe oublié ?</a>
            </div>
            <div align="center">
              <button type="submit">Se connecter</button>
            </div>
          </form>
    </div>

    <div>
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
    </div>

    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
        $('.toggle i').click(function () {
            $('ul').toggleClass("show");
        });
    </script>
    
</body>
</html>