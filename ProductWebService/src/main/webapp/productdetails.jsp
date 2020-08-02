<%@page isELIgnored="false" %>
<%@page import="com.sterlite.demo.spring.entities.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta name="author" content="Dharmaraj Pawale">
	<meta name="copyright" content="Sterlite Technologies Ltd.">
	<meta name="version" content="1.0">
	<meta name="creationdate" content="25-Jun-2020">
    <title> Product Details</title>
<link href="styles/bootstrap.min.css" rel="stylesheet">
    <script src="scripts/jquery-3.5.1.min.js"></script>
    <script src="scripts/bootstrap.min.js"></script>
</head>
<body>
<div>
<div class="container" style="margin:50px">
    <div class="row text-center"><strong> Products</strong></div>
    <div class="row" style="border:1px solid green;padding:10px">
        <div class="col-md-3 text-center"><strong>Product Id</strong></div>
        <div class="col-md-3 text-center"><strong>Name</strong></div>
        <div class="col-md-3 text-center"><strong>Brand</strong></div>
        <div class="col-md-3 text-center"><strong>Price</strong></div>
    </div>
    
    <p>${products}</p>
    
    
    <c:forEach var="product" items="${products}">
        <div class="row" style="border:1px solid green;padding:10px">
	         <div class="col-md-3 text-center">${product.id}</div>
	         <div class="col-md-3 text-center" >${product.name}</div>
	         <div class="col-md-3 text-center">${product.brand}</div>
	         <div class="col-md-3 text-center">${product.price}</div>    
        </div>
    </c:forEach>

</div>
</div>
</body>
</html>