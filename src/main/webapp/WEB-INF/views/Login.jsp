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
        <nav>
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
                <a href=""><img src="./logo_CNAS.png" width="80px" height="60px"/></a>
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
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
        $('.toggle i').click(function () {
            $('ul').toggleClass("show");
        });
    </script>
    <section></section>
</body>
</html>