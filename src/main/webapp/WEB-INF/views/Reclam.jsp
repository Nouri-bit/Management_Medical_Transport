<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="reclamation.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/aadb09bf28.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="topnav.jsp" %>
    <div class="form">
        <form action="<%= request.getContextPath() %>/reclam" method="post">
            <h1>Réclamation</h1>
            <div class="inputs">
                <p class="input_span"><span>Rédiger votre Réclamation</span></p>
                <textarea class="reclamation" placeholder="Saisissez ici..."></textarea>
              </div>
            <div class="btn">
              <button type="submit">Envoyer</button>
            </div>
          </form>
    </div>
   <div class="bottomdiv"></div>
  <%@ include file="bottomnav.jsp" %>
</body>
</html>