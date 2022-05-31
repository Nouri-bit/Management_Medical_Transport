<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<style>
body{
    background-color:#6EAFC9ff; 
    margin: auto;
    position: relative;
    font-family: Roboto, Courier, monospace;
    color:#0064ACff;
    justify-content: center;
    align-items: center;
    padding: 100px;
    
}
h1{
font-size: 100px;
text-align: center;
text-shadow: 4px 4px 7px #0064ACff;
height: 100px;
color: aliceblue;

}
.cards {
  height:max-content;
 display: grid;
 grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
 grid-auto-rows: auto;
 grid-gap: 2rem;
 
 }
 .card {
 border-radius: 20px; 
 box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
 padding: 10%;
 background-color: aliceblue;
 }
 /* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
 .container{
  margin: auto;
  padding: auto;
  text-align: center;
 }

img{
 
  border-radius: 50%;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 40%;
  
}
</style>
<title>list des chauffeurs</title>
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
                <a href=""><img src="images/logo_CNAS.png" width="80px" height="60px"/></a>
            </div>
        </nav>
    </div>
<div class="Title">
   <h1>Chauffeurs</h1>
</div>
<div class="cards">
<div class="card" style="max-width: 300px;">
  <img src="image.jpg" alt="Avatar" style="width:70%">
  <div class="container">
    <h4><b id="name" >name </b></h4> 
    <p  > 0123456</p>
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