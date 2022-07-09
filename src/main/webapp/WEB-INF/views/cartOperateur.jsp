<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cartographie</title>
<style>
body{
  background-color: #6EAFC9;
  text-transform:uppercase;
  margin: 0%;
  padding: 0%;
  padding-top: 60px;
  font-family: Roboto, Courier, monospace;
}
#googleMap{
z-index: 10;}
</style>
</head>
<body>

 <%@ include file="topnavOpérateur.jsp" %>
 <div id="googleMap" style="width:100%;height:800px;"></div>

<script>
let dataset= [0, 0, 0, 0];
var i=0;
</script>
<form action="<%= request.getContextPath() %>/Cartographie" method="get">
<c:forEach items="${products}" var="compte">
<script>
var myLatLng = { lat: ${compte.x}, lng:${compte.y} };
var contentString =
    '<div id="content" style="width=50px;">' +
    '<div id="siteNotice">' +
    "</div>" +
    "<p> <b>Chauffeur:</b> ${compte.idseance.idchauffeur}</p> " +
    '<div id="bodyContent">' +
    "<p><b>patient: </b>${compte.idseance.idpatient}</p> " +
    "<p><b>destination: </b>${compte.distination}</p>" +
    "<p><b>Position actuelle: </b>lat: ${compte.x}, lng:${compte.y} </p>" +
    "</div>" +
    "</div>";
   
         
     dataset[i]= {id:i, lat:${compte.x}, lng:${compte.y}, contentString:contentString, desc: "000"}
   
        i++;
        /*const data2 = {id:i, lat:myLatLng2.lat, lng:myLatLng2.lng, contentString:contentString, desc: "000"}
        dataset[i]=data2;
        i=i+1;
        const data3 = {id:i, lat:myLatLng3.lat, lng:myLatLng3.lng, contentString:contentString, desc: "000"}
        dataset[i]=data3;*/
       

</script>
</c:forEach>
</form>
<script>
function myMap() {
var mapProp= {
  center:new google.maps.LatLng(36.752887,3.042048),
  zoom:13,
};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

//map.setCenter(markUsr.position);
var markers = [];
for (let k = 0; k < dataset.length; k++) {
    var pos = new google.maps.LatLng(dataset[k].lat, dataset[k].lng);
    markers[k] = new google.maps.Marker({
        position: pos,
        map: map,
        icon: 'ambulance.png',
        description: dataset[k].desc,
        id: k
    });
  
    markers[k].addListener("click", () => {
        infowindow.open({
          anchor: markers[k],
          map,
          shouldFocus: false,
        });});
     
      const infowindow = new google.maps.InfoWindow({
       content: dataset[k].contentString,
     });
}
}
/*function addMarker(location) {
    new google.maps.Marker({
        position: location,
        map,
        title: "Hello",
        icon:'ambulance.png',
      });
    };*/
    </script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCqq8YS_U68oONhUcJQmJRDLzp1qvvf6O8&callback=myMap"></script>



  <%@ include file="bottomnav.jsp" %>
  
</body>
</html>