<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
<nav class="topNav">
    <label class="toggle">
        <i class="fa fa-bars"></i>
    </label>
    <ul >
       <li><a href='Kelomtrage'>Liste des séances </a></li>
       <li><a href='CartOperateur'>Cartographie</a></li>
       <li><a href='Login_servlet2'>Déconnecter</a></li>
    </ul> 
    <div class="logo_cnas">
        <a href="DashboardOperateur"><img src="https://elhanaa.cnas.dz/resources/images/cnasfond.png" width="50px" /></a>
    </div>
    <div class="socialtop">
        <div class='top-social'>
            <a href='#'><i class="fa-regular fa-envelope"></i></a>
            <a href='#'><i class="fa-regular fa-bell"></i></a>
            <a href='#'><i class="fa-regular fa-circle-user"></i></a>
        </div>
    </div>
</nav>
<style>
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
z-index: 300;
background: #ffffff;
height: 60px;
width: 100%;
position:fixed;
top:0;
}
.topNav ul{
    z-index: 300;
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
    padding: 0;
    box-sizing: border-box;
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
padding:15px;
line-height: 45px;
color: #0064AC;
font-size:12px;
text-transform:uppercase;
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
.topNav .top-social a {
padding:15px;
color:#0064AC;
}
.topNav .top-social {
line-height: 60px;
}
.topNav .top-social a:hover {
opacity: 0.6;
}

</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $('.toggle i').click(function () {
        $('ul').toggleClass("show");
    });
</script>
  