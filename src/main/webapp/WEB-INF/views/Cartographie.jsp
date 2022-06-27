<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <%@ include file="topnav.jsp" %>
 <div id="googleMap" style="width:100%;height:800px;"></div>

<script>
function myMap() {
var mapProp= {
  center:new google.maps.LatLng(36.752887,3.042048),
  zoom:15,
};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

const myLatLng = { lat: 36.752887, lng: 3.042048 };
const myLatLng2 = { lat: 36.752887, lng: 3 };
const myLatLng3 = { lat: 36.752888, lng: 3.004 };
const contentString =
    '<div id="content">' +
    '<div id="siteNotice">' +
    "</div>" +
    '<h1 id="firstHeading" class="firstHeading">Chauffeur</h1>' +
    '<div id="bodyContent">' +
    "<p><b>patient: </b> Name </p> " +
    "<p><b>destination: </b> Hopitale </p>" +
    "</div>" +
    "</div>";
  const infowindow = new google.maps.InfoWindow({
    content: contentString,
  });

  marker = new google.maps.Marker({
    position: myLatLng,
    map,
    title: "Hello",
    icon:'ambulance.png',
  });
  marker.addListener("click", () => {
    infowindow.open({
      anchor: marker,
      map,
      shouldFocus: false,
    });});
    /* ______________________ */ 
  new google.maps.Marker({
    position: myLatLng2,
    map,
    title: "Hello",
    icon:'ambulance.png',
  });
  new google.maps.Marker({
    position: myLatLng3,
    map,
    title: "Hello",
    icon:'ambulance.png',
  });
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCGR_HXyljWdIP4waW2IbgF1cKgAPnet8A&callback=myMap"></script>

  <%@ include file="bottomnav.jsp" %>
</body>
</html>