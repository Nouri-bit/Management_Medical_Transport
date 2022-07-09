<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="dashboard.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<link href="images/logo_CNAS.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>page d'acceuil</title>
</head>
<body>
 <%@ include file="topnavOpérateur.jsp" %>

    
    <div class="row">
    <div class="col_left" >
      <div class="topboxes">
        <div class="topbox" >
          <img class="icon" src="pec.png" alt="icon" width="50px">
          <h4 id="nb_pec">1</h4>
          Km non ajoutées
        </div>
        <div class="topbox" >
          <img class="icon" src="pec.png" alt="icon" width="50px">
          <h4 id="nb_patients">8</h4>
          Nombre des patients 
        </div>
        <div class="topbox">
          <img class="icon" src="bell.png" alt="icon" width="50px">
          <h4 id="nb_notif">2</h4>
          notifications
        </div>
      </div>
      <div id="graph">
     
            <canvas id="myChart" style="width: 600px;"></canvas>
  
            <script>
              var xValues = ["jan","fev","mar","avr","mai","jun","jul","aout","spt","oct","nov","des"];
              
              new Chart("myChart", {
                type: "line",
                data: {
                  labels: xValues,
                  datasets: [{ 
                    data: [860,1140,1060,1060,1070],
                    borderColor: "red",
                    fill: false,
                    title:"2022"
                  }, { 
                    data: [1600,1700,1700,1900,2000,2700,4000,5000,6000,7000,4000,2000],
                    borderColor: "green",
                    fill: false
                  }, { 
                    data: [300,700,2000,5000,6000,4000,2000,1000,2000,1500,800,1000],
                    borderColor: "blue",
                    fill: false
                  }]
                },
                options: {
                  title: {
                  display: true,
                  text: "Remboursement"
                  },
                  legend: {display: false}
                }
              });
              </script>
      </div>
  
    </div>
    <div class="col_side">
      <div class="sidebox" >
            <canvas id="recChart" style="width:100%;max-width:600px ; min-width: 400px;"></canvas>
  
            <script>
            var xValues = ["non traitées", "traitées"];
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
       
          <canvas id="pecChart" style="width:100%;max-width:600px ; min-width: 400px;"></canvas>
  
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

      
    </div>
    </div>
   <%@ include file="bottomnav.jsp" %>
  
  </body>