<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
  <head>
        <title>admin login page</title>
  </head>
   <body>
   <h2>Admin Login form </h2> 
   <h2 class="color:red">${errorMessage}</h2>
   <hr>
  <form action="${contextPath}/admin/loginSuccess"  , method ="post", align ="center"> 
  <p>user id <input type ="text" name ="email" placeholder="admin email id"></p>
  <p>user id <input type ="password" name ="password" placeholder="admin password"></p>
  <p><button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button></p>
  </form>
   </body>



</html>


