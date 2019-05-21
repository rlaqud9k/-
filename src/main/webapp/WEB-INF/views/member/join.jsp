<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/Login.css" />" rel="stylesheet">
<title>Login</title>
</head>
<body>

    <div class="container">

      <form class="form-signin" action="<c:url value="/login"/>" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <label for="inputEmail" class="sr-only">ID</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="ID" name="id">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="pw">
        <div class="checkbox">
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
</body>
</html>