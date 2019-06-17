<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
      <form method="POST" action="${contextPath}/user/loginSuccess" class="form-signin">
        <h2 class="form-heading" align ="center">Log in   ${message}</h2>
         <table align ="center">
           <tr><td>user name</td>
            <td> <input name="email" type="text" class="form-control" placeholder="email" autofocus="true"/>  </td>
         <tr>
         <td>user password</td>
         <td> <input name="password" type="password" class="form-control" placeholder="Passsword"/>  </td>
         </tr>
         <tr>
         <td>  <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>  </td>
        </tr>
        </table>
        <h4 class="text-center" align ="center"><a href="${contextPath}/user/registration">Create an account</a></h4>
      </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
