<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/Login.css" />" rel="stylesheet">
<title>member, join</title>
</head>
<body>

	<div class="container">

		<form class="form-signin" action="<c:url value="/viewss/deletedo"/>" method="post">
			<h2 class="form-signin-heading">Delete Content</h2>
			<button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="yes,${no}">YES</button>
			<button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="no,${no}">NO</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>