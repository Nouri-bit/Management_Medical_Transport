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

 <%@ include file="topnav.jsp" %>
 <div id="googleMap" style="width:100%;height:800px;"></div>
<form action="<%= request.getContextPath() %>/Cartographie" method="get">
<c:forEach items="${products}" var="compte">
<script>
function myMap() {
var mapProp= {
  center:new google.maps.LatLng(36.752887,3.042048),
  zoom:15,
};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
const myLatLng = { lat: ${compte.x}, lng: ${compte.y}};
const contentString =
    '<div id="content">' +
    '<div id="siteNotice">' +
    "</div>" +
    '<h1 id="firstHeading" class="firstHeading">${compte.idseance.idchauffeur}</h1>' +
    '<div id="bodyContent">' +
    "<p><b>patient: </b>${compte.idseance.idpatient}</p> " +
    "<p><b>destination: </b>${compte.distination}</p>" +
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
  
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCGR_HXyljWdIP4waW2IbgF1cKgAPnet8A&callback=myMap"></script>
</c:forEach>
</form>


  <%@ include file="bottomnav.jsp" %>
  
</body>
</html>