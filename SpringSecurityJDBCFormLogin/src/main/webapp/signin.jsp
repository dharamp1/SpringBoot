<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/login" var="loginUrl"/> 
<!DOCTYPE html>
<html>
<head>
<!-- 	<link rel="stylesheet" href="/styles/bootstrap.min.css"> -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<title>Sterlite Demo-Authentication</title>
</head>
<body>
<div class="container p-3 my-3 bg-dark text-white">
<h1 class=""> User Authentication </h1>
<form action="${loginUrl}" method="post"> 
	<div class="bg-warning text-danger">        
    <c:if test="${param.error != null}">          
        <h3>  
            Invalid username and password.  
        </h3>  
    </c:if>  
    <c:if test="${param.logout != null}">         
        <h3>  
            You have been logged out.  
        </h3>  
    </c:if> 
    </div> 
    <div class="form-group">  
        <label for="username">Username</label>  
        <input type="text" class="form-control" id="username" name="username"/>      
    </div>  
    <div class="form-group">   
        <label for="password">Password</label>  
        <input type="password" class="form-control" id="password" name="password"/>      
    </div>  
    <input type="hidden"                          
        name="${_csrf.parameterName}"  
        value="${_csrf.token}"/>  
    <button type="submit" class="btn btn-primary">Sign In</button>  
</form>
</div> 
</body>
</html>