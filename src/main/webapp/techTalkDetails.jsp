<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
    <!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Bootstrap Theme Simply Me</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/start/jquery-ui.css" type="text/css" media="all" />
  
  <style>
  body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color: #f5f6f7;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  .bg-1 { 
      background-color: #1abc9c; /* Green */
      color: #ffffff;
  }
  .bg-2 { 
      background-color: #474e5d; /* Dark Blue */
      color: #ffffff;
  }
  .bg-3 { 
      background-color: #ffffff; /* White */
      color: #555555;
  }
  .bg-4 { 
      background-color: #2f2f2f; /* Black Gray */
      color: #fff;
  }
  .container-fluid {
      padding-top: 70px;
      padding-bottom: 70px;
  }
  .navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 12px;
      letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
      color: #1abc9c !important;
  }
  </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><img alt="" src="./images/tt1.png"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      <li><a href="logoutServlet">Logout</a></li>
      <li><a href="#">Welcome <% Object name=session.getAttribute("name"); %> <%=name %></a></li>
       <!--  <li><a href="./login.jsp">Login</a></li>
        <li><a href="./register.jsp">Register</a></li> -->
        
      </ul>
    </div>
  </div>
</nav>

<!-- First Container -->
<div class="container-fluid bg-1 text-center">
  <h3 class="margin">ATMECS</h3>
  <img src="./images/logo1.jpg" class="img-responsive img-circle margin" style="display:inline" alt="Bird" width="350" height="350">
  <h3> Passionate Minds</h3>
</div>

<!-- Second Container -->
<div class="container-fluid bg-2 text-center">

<table class="table" border="2">
    <thead>
      <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Presenter</th>
        <th>Date</th>
        <th>Register</th>
        
       
      </tr>
    </thead>
    <tbody>
      
         <c:forEach items="${list}" var="current">
        <tr>
          <td>${current.title}</td>
          <td>${current.description}</td>
          <td>${current.presenter}</td>
          <td>${current.date}</td>
          <!-- <td><a href="RegisterEmployeeServlet" onclick="return confirm_alert(this);">Going</a></td> -->
         
         
          <td style="font-size:x-large;"><a onclick="return confirm_alert(this);" href="RegisterEmployeeServlet?srNo=${current.srNo}&title=${current.title}&description=${current.description}&presenter=${current.presenter}&date=${current.date}"/>Going</a></td>
          
          
          
    
          </tr>
         
      </c:forEach>
  
      
    </tbody>
  </table>
 

</div>

<script type="text/javascript">
function confirm_alert(node) {
	
    return confirm("You Have Sucessfully Register");
}


</script>


</body>
</html>

