<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="dashboard.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<link href="images/logo_CNAS.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
<title>page d'acceuil</title>
</head>
<body>

    <nav class="topNav">
        <label class="toggle">
            <i class="fa fa-bars"></i>
        </label>
        <ul>
           <li><a href='#'>Ajouter une demande</a></li>
           <li><a href='#'>Tableau des �carts</a></li>
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

    <div class="row">
    <div class="col_left" >
      <div class="topboxes">
        <div class="topbox" >
          <img class="icon" src="notif.png" alt="icon">
          <h4 id="nb_pec">1</h4>
          Prise en charge
        </div>
        <div class="topbox" >
          <img class="icon" src="notif.png" alt="icon">
          <h4 id="nb_reclam">15</h4>
          reclamations
        </div>
        <div class="topbox">
          <img class="icon" src="notif.png" alt="icon">
          <h4 id="nb_notif">2</h4>
          notifications
        </div>
      </div>
      <div id="graph">
     
            <canvas id="myChart" style="width:100%;max-width:700px"></canvas>
  
            <script>
              var xValues = ["jan","fev","mar","avr","mai","jun","jul","aout","spt","oct","nov","des"];
              
              new Chart("myChart", {
                type: "line",
                data: {
                  labels: xValues,
                  datasets: [{ 
                    data: [860,1140,1060,1060,1070,1110,1330,2210,7830,2478],
                    borderColor: "red",
                    fill: false
                  }, { 
                    data: [1600,1700,1700,1900,2000,2700,4000,5000,6000,7000],
                    borderColor: "green",
                    fill: false
                  }, { 
                    data: [300,700,2000,5000,6000,4000,2000,1000,200,100],
                    borderColor: "blue",
                    fill: false
                  }]
                },
                options: {
                  title: {
                  display: true,
                  text: "Rembourcement"
                  },
                  legend: {display: false}
                }
              });
              </script>
      </div>
  
    </div>
    <div class="col_side">
      <div class="sidebox" >
        <h2 id="rec_mois" >12</h2>
        
            <canvas id="recChart" style="width:100%;max-width:600px"></canvas>
  
            <script>
            var xValues = ["Italy", "France"];
            var yValues = [55, 49];
            var barColors = [
              "#b91d47",
              "#00aba9",
              "#2b5797",
              "#e8c3b9",
              "#1e7145"
            ];
  
            new Chart("recChart", {
              type: "doughnut",
              data: {
                labels: xValues,
                datasets: [{
                  backgroundColor: barColors,
                  data: yValues
                }]
              },
              options: {
                title: {
                  display: true,
                  text: "Reclamations"
                }
              }
            });
            </script>
  
      </div>
      <div class="sidebox">
       
          <canvas id="pecChart" style="width:100%;max-width:600px"></canvas>
  
          <script>
          var xValues = ["validées", "non validées"];
          var yValues = [55, 49];
          var barColors = [
            "#b91d47",
            "#00aba9"
          ];
  
          new Chart("pecChart", {
            type: "doughnut",
            data: {
              labels: xValues,
              datasets: [{
                backgroundColor: barColors,
                data: yValues
              }]
            },
            options: {
              title: {
                display: true,
                text: "Les prises en charge du mois"
              }
            }
          });
          </script>
  
              </div>
  
      <div class="sidebox">
        <canvas id="demChart" style="width:100%;max-width:600px"></canvas>
        <script>
        var xValues = ["scannées", "non scannées"];
        var yValues = [0, 10];
        var barColors = [
          "#b91d47",
          "#00aba9"
        ];
  
        new Chart("demChart", {
          type: "doughnut",
          data: {
            labels: xValues,
            datasets: [{
              backgroundColor: barColors,
              data: yValues
            }]
          },
          options: {
            title: {
              display: true,
              text: "Les prises en charge du mois"
            }
          }
        });
        </script>
  
            </div>
      
    </div>

    <nav class="bottomNav">
        <label class="toggle1">
                <div class='top-social1'>
                    <a href='#'><i class="fa-solid fa-house"></i></a>
                    <a href='https://web.facebook.com/'><i class="fa-brands fa-facebook"></i></a>
                </div>
        </label>
        <div class="label_cnas">
            <a href=""><img/>Caisse Nationale des Assurances Sociales des Travailleurs Salari�s</a>
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