<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<title>TRM</title>

 <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery3.js"></script> 
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script> 

<style type="text/css">
img{
max-width: 100%;
}

.dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover{
	font-weight:bold;
	color: #000;
    text-decoration: none;
    background-color: #3560b1;
}
li{
list-style: none;
display: inline-block;
}

</style>

</head>
<body>


  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <div class="row">
  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <%-- <div class="navbar-header">
    
    
      <a class="navbar-brand" rel="home" href="#" title="Buy Sell Rent Everyting">
        <img style="max-width:100px; max-height: 100%"
             src="${pageContext.request.contextPath}/image/trm.jpg">
    </a>
    </div> --%>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Services<span class="caret"></span></a>
        <ul class="dropdown-menu" >
          <li><a href="#">BilledUnbilledDataSave</a></li>
          <li><a href="#">BilledUnbilledDetails</a></li>
          <li><a href="#">CheckUserDetails</a></li>
            <li><a href="#">CheckValidUser</a></li>
            <li><a href="#">CollDetails</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
      <li><a href="logout.html">Logout</a></li>
    </ul>
    </div></div>
  </div>
</nav>
  
<div class="container">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu for the "Page 1" button in the navigation bar.</p>
</div>


</body>
</html>