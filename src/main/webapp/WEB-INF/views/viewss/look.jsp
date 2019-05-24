<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/Login.css" />" rel="stylesheet">
<title>Writer</title>
</head>
<body>

	<div class="container">

		<form action="<c:url value="/viewss/md">
		<c:param name="id" value="${id}"/>
		</c:url>" method="post">
			<div class="form-group">
				<label class="col-form-label" for="inputDefault">Title</label> 
				<div type="text" class="form-control" id="inputDefault">${title}
			</div>
			<div class="form-group">
				<label for="exampleTextarea">Contents</label>
				<div class="form-control" id="exampleTextarea" style="height:400">
				${content}
				</div>
			</div>
			<button class="btn btn-lg btn-primary btn-inline pull-right"
				type="submit" name="button" value="home">홈</button>
			<button class="btn btn-lg btn-primary btn-inline pull-right"
				type="submit" name="button" value="modi,${no}">수 정</button>
			<button class="btn btn-lg btn-primary btn-inline pull-right"
				type="submit" name="button" value="delete,${no}">삭 제</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>