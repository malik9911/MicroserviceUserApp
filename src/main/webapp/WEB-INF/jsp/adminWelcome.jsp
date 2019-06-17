<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Welcome ${adminName}</h1>
<hr>
<br/>
  <div class="container">
    
    
     <h2>${users}</h2>
     
       <!-- 
       <table>
       <th>login  Users </th>
       <tr><td>user name </td><td>user email</td></tr>
          <c:forEach var="user" items="${users}">
            <tr><td><c:out value="${user.userName}"/></td><td><c:out value="${user.email}"/></td></tr>
          </c:forEach>
       </table>
        -->
       
  </div>
  
</body>
</html>