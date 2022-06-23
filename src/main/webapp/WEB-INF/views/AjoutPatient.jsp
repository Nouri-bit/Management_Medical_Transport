<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ajout patient</title>
  <link href="images">
  <link rel="stylesheet" href="ajoutpatient.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
  <script language="JavaScript">
    var nbCheck = 0;  
    function isChecked(elmt)
    {
        if( elmt.checked )
        {return true; }
        else
        {return false;}
    }
     
    function clickCheck(elmt)
    {
        if( (nbCheck < 3) || (isChecked(elmt) == false) )
        {
            if( isChecked(elmt) == true )
            { nbCheck += 1;}
            else
            {nbCheck -= 1;}
        }
        else
        { elmt.checked = ''; }
    }
    function clickCheck1(elmt)
    {
        if( (nbCheck <4) || (isChecked(elmt) == false) )
        {
            if( isChecked(elmt) == true )
            { nbCheck += 1;}
            else
            {nbCheck -= 1;}
        }
        else
        { elmt.checked = ''; }
    }
    function clickCheck2(elmt)
    {
        if( (nbCheck <5) || (isChecked(elmt) == false) )
        {
            if( isChecked(elmt) == true )
            { nbCheck += 1;}
            else
            {nbCheck -= 1;}
        }
        else
        { elmt.checked = ''; }
    }
    function clickCheck3(elmt)
    {
        if( (nbCheck <6) || (isChecked(elmt) == false) )
        {
            if( isChecked(elmt) == true )
            { nbCheck += 1;}
            else
            {nbCheck -= 1;}
        }
        else
        { elmt.checked = ''; }
    }
  </script>
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
  <form action="<%= request.getContextPath() %>/AjoutPatient" method="post"> 
    <div class="inputs">
       <p class="input_span"><span>Numéro de sécurité social</span></p>
       <input name="nss" type="number" />
       <p class="input_span" ><span>Nom</span></p>
       <input name="nom" type="text">
       <p class="input_span" ><span>Prénom</span></p>
       <input name="prenom" type="text">
       <p class="input_span" ><span>Addresse complète</span></p>
       <input name="addresse" type="text">
       <p class="input_span" ><span>Date début </span></p>
       <input  name="date" type="text">   
    </div>
    <p class="input_span"><span>Numéro de sécurité social</span></p>
    <dev class="container">
      <div class="column">
          <div class="card">
              <div class="checkbox">
                <input  type="checkbox"  id='samedi' value="samedi" name="jour" onclick="clickCheck(this);"/> 
                <label 	>Samedi</label>
              </div>
              <div class="checkbox">
                <input type="checkbox" id='dimanche' value="dimanche" name="jour" onclick="clickCheck(this);"/>
                <label 	>Dimache</label>
              </div>
              <div class="checkbox">
                <input type="checkbox" id='lundi' value="lundi" name="jour" onclick="clickCheck(this);"/>
                <label 	>Lundi</label>
             </div>
          </div>
      </div>
      <div class="column">
        <div class="card">
            <div class="checkbox">
              <input type="checkbox" id='mardi' value="mardi" name="jour" onclick="clickCheck(this);"/> 
              <label 	>Mardi</label>
            </div>
            <div class="checkbox">
              <input type="checkbox" id='mercredi' value="mercredi" name="jour" onclick="clickCheck(this);"/>
              <label 	>Mercredi</label>
            </div>
        </div>
      </div>   
      <div class="column">
        <div class="card">
            <div class="checkbox">
              <input type="checkbox" id='jeudi' value="jeudi" name="jour" onclick="clickCheck(this);"/> 
              <label 	>Jeudi</label>
            </div>
            <div class="checkbox">
              <input type="checkbox" id='vendredi' value="vendredi" name="jour" onclick="clickCheck(this);"/> <label for="Vendredi"> 
              <label >Vendredi</label>
            </div>
        </div>
      </div> 
    </dev>
    <div class="container2">
      <div class="column">
          <div class="card">
              <p class="input_span"><span>Tranche</span></p>
              <div class="checkbox">
                <input  type="radio"  id='tranche1' value="1" name="tranche" onclick="clickCheck1(this);"/> 
                <label 	>Tranche 1</label>
              </div>
              <div class="checkbox">
                <input  type="radio"  id='tranche2' value="2" name="tranche" onclick="clickCheck1(this);"/> 
                <label 	>Tranche 2</label>
              </div>
              <div class="checkbox">
                <input  type="radio"  id='tranche3' value="3" name="tranche" onclick="clickCheck1(this);"/> 
                <label 	>Tranche 3</label>
             </div>
          </div>
      </div>
      <div class="column">
        <div class="card">
          <p class="input_span"><span>Type du véhicule</span></p>
            <div class="checkbox">
              <input   type="radio"  id='type1' value="1" name="type" onclick="clickCheck2(this);"/> 
              <label 	>Type 1</label>
            </div>
            <div class="checkbox">
              <input   type="radio"  id='type2' value="2" name="type" onclick="clickCheck2(this);"/> 
              <label 	>Type 2</label>
            </div>
            <div class="checkbox">
              <input   type="radio"  id='type3' value="3" name="type" onclick="clickCheck2(this);"/> 
              <label 	>Type 3</label>
            </div>
        </div>
      </div>   
      <div class="column">
        <div class="card">
           <p class="input_span"><span>Attente</span></p>
            <div class="checkbox">
              <input   type="radio"  id='oui' value="true" name="attente" onclick="clickCheck3(this);"/> 
              <label 	>Oui</label>
            </div>
            <div class="checkbox">
              <input  type="radio"  id='non' value="false" name="attente" onclick="clickCheck3(this);"/> 
              <label >Non</label>
            </div>
        </div>
      </div> 
    </div>
    <div>
      <button type="submit">Ajouter</button>
    </div>
  </form>

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
    </nav>    
  </div>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $('.toggle i').click(function () {
        $('ul').toggleClass("show");
    });
</script>
  

</body>
</html>