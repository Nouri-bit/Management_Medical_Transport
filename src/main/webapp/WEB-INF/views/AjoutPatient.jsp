<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <script src="https://api.mqcdn.com/sdk/place-search-js/v1.0.0/place-search.js"></script>
  <link type="text/css" rel="stylesheet" href="https://api.mqcdn.com/sdk/place-search-js/v1.0.0/place-search.css"/>
  <script language="JavaScript">
    var nbCheck = 0;  
    var nbCheck1 = 0;
    var nbCheck2 = 0;
    var nbCheck3 = 0;
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
            { nbCheck1 += 1;}
            else
            {nbCheck1 -= 1;}
        }
        else
        { elmt.checked = ''; }
    }
    function clickCheck2(elmt)
    {
        if( (nbCheck <5) || (isChecked(elmt) == false) )
        {
            if( isChecked(elmt) == true )
            { nbCheck2 += 1;}
            else
            {nbCheck2 -= 1;}
        }
        else
        { elmt.checked = ''; }
    }
    function clickCheck3(elmt)
    {
        if( (nbCheck <6) || (isChecked(elmt) == false) )
        {
            if( isChecked(elmt) == true )
            {nbCheck3 += 1;}
            else
            {nbCheck3 -= 1;
            elmt.checked = '';
            }
        }
        else
        { elmt.checked = ''; }
    }
  </script>
</head>
<body>
 <%@ include file="topnav.jsp" %>
  <div class="toast">
  <div class="toast-content">
      <i class="fas fa-solid fa-check check"></i>

      <div class="message">
          <span class="text text-1">Succés</span>
          <span class="text text-2">Le patient à été inséré avec succés</span>
      </div>
  </div>
  <i class="fa-solid fa-xmark close"></i>

  <div class="progress"></div>
</div>
  
  <form action="<%= request.getContextPath() %>/AjoutPatient" method="post" onsubmit="alert('Demande ajouté!');"> 
    <div class="inputs">
       <p class="input_span"><span>Numéro de sécurité social</span></p>
       <input class="nss" name="nss" type="number" min="100000000000000" max="999999999999999"/>
       <p class="input_span" ><span>Nom</span></p>
       <input name="nom" type="text" required maxlength="30">
       <p class="input_span" ><span>Prénom</span></p>
       <input name="prenom" type="text" required maxlength="25">
       <p class="input_span" ><span>Addresse complète</span></p>
       <input name="addresse" type="search" id="place-search-input" placeholder="Entrer une addresse" required>
       <p class="input_span" ><span>Structure sanitaire</span></p>
       <input name="addresseh" type="search" id="place-search-input2" placeholder="Addresse de la structure sanitaire" required>
       
       
       <p class="input_span" ><span>Date début </span></p>
       <input  name="date" type="text" required value="06-29-2022" > 
         
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
    <dev class="container2">
      <div class="column">
          <div class="card">
              <p class="input_span"><span>Tranche</span></p>
              <div class="checkbox">
                <input  type="radio"  id='tranche1' value="1" name="tranche" onclick="clickCheck1(this);"/> 
                <label 	>8h-midi</label>
              </div>
              <div class="checkbox">
                <input  type="radio"  id='tranche2' value="2" name="tranche" onclick="clickCheck1(this);"/> 
                <label 	>13h-16h</label>
              </div>
              <div class="checkbox">
                <input  type="radio"  id='tranche3' value="3" name="tranche" onclick="clickCheck1(this);"/> 
                <label 	>17h-8h</label>
             </div>
          </div>
      </div>
      <div class="column">
        <div class="card2">
          <p class="input_span"><span>Type du véhicule</span></p>
            <div class="checkbox">
              <input   type="radio"  id='type1' value="1" name="type" onclick="clickCheck2(this);"/> 
              <label 	>ambulance médicalisée</label>
            </div>
            <div class="checkbox">
              <input   type="radio"  id='type2' value="2" name="type" onclick="clickCheck2(this);"/> 
              <label 	>ambulance sanitaire</label>
            </div>
            <div class="checkbox">
              <input   type="radio"  id='type3' value="3" name="type" onclick="clickCheck2(this);"/> 
              <label 	>véhicule sanitaire léger</label>
            </div>
        </div>
      </div>   
      <div class="column">
        <div class="card3">
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
    </dev>
    <div>
      <button type="submit">Ajouter</button>
    </div>
  </form>
  <script>
	var email = document.querySelector('input.nss');
	email.oninvalid = function(e) {
		e.target.setCustomValidity("");
		if (!e.target.validity.valid) {
			if (e.target.value.length == 0) {
	e.target.setCustomValidity("Ce champ est obligatoire");
			} else {
	e.target.setCustomValidity("Entrer Le numéro de sécurité sociale à 15 chifres");
			}
		}
	};
</script>
<script>
				placeSearch({
				key: '5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9',
				container: document.querySelector('#place-search-input')
				});
				placeSearch({
					key: '5rbG94EZ1CBfSDepJwvayTwiYOG5Fgm9',
					container: document.querySelector('#place-search-input2')
					});
			</script>
<script>
  const button = document.querySelector("button"),
      toast = document.querySelector(".toast")
      closeIcon = document.querySelector(".close"),
      progress = document.querySelector(".progress");

      let timer1, timer2;

      button.addEventListener("click", () => {
        toast.classList.add("active");
        progress.classList.add("active");

        timer1 = setTimeout(() => {
            toast.classList.remove("active");
        }, 5000); //1s = 1000 milliseconds

        timer2 = setTimeout(() => {
          progress.classList.remove("active");
        }, 5300);
      });
      
      closeIcon.addEventListener("click", () => {
        toast.classList.remove("active");
        
        setTimeout(() => {
          progress.classList.remove("active");
        }, 300);

        clearTimeout(timer1);
        clearTimeout(timer2);
      });

</script>
  

   <%@ include file="bottomnav.jsp" %>
  

</body>
</html>