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
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
body{
  background-color: #6EAFC9;
  margin: 0%;
  padding: 0%;
} 
/*topNav css*/  
.toggle {
  font-size: 20px;
  color: #0064AC;
  float: left;
  line-height: 60px;
  margin-left: 3%;
  cursor: pointer;
  display: block;
  font-weight: 400;
}
.topNav{
background: #ffffff;
height: 60px;
width: 100%;
position: fixed;
}
.topNav ul{
    z-index: -1;
    margin-top:-15px;
    position: fixed;
    top: -400px;
    right: 0;
    left: 0;
    width:200px;
    background: #ffffff;
    display: inline-block;
    transition: top .4s;
    margin-left: 0;
    box-sizing: border-box;
    padding: 0;
  }
.topNav ul.show{
    top: 60px;
  }
.topNav .socialtop{
    float: right;
    margin-right: 3%;
}

.topNav ul li{
    top: 0;
    width: 100%;
    float: left;
    text-align: center;
}
.topNav ul a{
font-weight: 400;
padding:15px;
line-height: 45px;
color: #0064AC;
font-size:14px;
text-decoration: none;
}
.topNav ul li:hover{
opacity: 0.6;
}
.topNav .logo_cnas{
  position: absolute;
  left: 50%;
  top: 0%;
  content:"";
  margin-left:-40px;
  }

/*Form css*/
body .form{
  display: flex;
  justify-content:center;
  flex-direction: columns;
  align-items: center;
}
form {
    margin-top: 9%;
    background-color: #fff;
    padding: 20px 40px;
    border-radius: 10px;
    min-width: 400px;
  }
  form h1{
    color: #0064AC;
    text-align:center;
  }
  form .inputs {
    display: flex;
    flex-direction: column;
  }
  form .inputs input[type='number'], input[type='password']{
    padding: 15px;
    border-radius: 5px;
    background-color:#F5F8FA;
    outline:none;
    border: none;
  }
  form p.input_span{
    font-size: 12px; 
    margin-bottom: 5px;
    color: #0064AC;
  }
  form .pswd_forget{
    margin-bottom:20px;
    margin-top:20px;
  }
  form .pswd_forget a{
    font-size: 12px;
    color: #A946E9;
    text-decoration: none;
  }
  
  form button{
    text-align: center;
    padding: 15px 25px;
    border-radius: 5px;
    border:none;
    font-size: 15px;
    color: #fff;
    background-color: #0064AC;
    outline:none;
    cursor:pointer;
    font-size:14px;
    text-transform:uppercase;
  }

/*bottomNav css*/  
  .bottomNav{
    background:white;
    height: 100px;
    width: 100%;
    position: fixed;
    bottom: 0;
    }


.toggle1 {
  font-size: 25px;
  margin-left: 5%;
  float: left;
  line-height: 100px;
  font-weight: 400;
  
}
.bottomNav .toggle1 a {
    padding:15px;
    color:#0064AC;
    }
    nav .toggle1 a:hover {
    opacity: 0.6;
    }
.bottomNav .toggle1 a:hover {
        opacity: 0.6;
        }

        .bottomNav .socialtop1{
    font-size: 25px;
    float: right;
    margin-right: 5%;
    font-weight: 400;
    line-height: 100px;
}
.bottomNav .top-social1 a {
padding:15px;
color:#0064AC;
}
.bottomNav .top-social1 a:hover {
opacity: 0.6;
}


.bottomNav .label_cnas a{
    position: absolute;
    left: 27%;
    top: 40%;
    text-decoration: none;
    right:auto;
    font-size: 20px;
    font-weight: 700;
    text-transform:uppercase;
    color:#0064AC;
    }

    </style>
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