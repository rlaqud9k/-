<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" isELIgnored="false"  %>
<!doctype html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/Home.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:700&amp;subset=korean" rel="stylesheet">
<title>Home!</title>
<!-- JS -->
</head>
<div class="blog-masthead">
	<div class="container">
		<nav class="blog-nav">
			<a class="blog-nav-item active" href="#">Home</a> 
			<a class="blog-nav-item" href="<c:url value = "/logout"/>">LogOut</a> <a class="blog-nav-item"
				href="<c:url value = "/member/delete"/>">Delete Member</a>
		</nav>
	</div>
</div>
<body class="container">
	<div class="jumbotron">
		<h1>Hello, ${sessionScope.id}!</h1>
		<p>The time on the server is ${serverTime}.</p>
	</div>
	<h2 class="h2c" style="font-family: 'Nanum Gothic', sans-serif;">게 시 글</h2>
	<a href="<c:url value="/viewss/writer"/>">
		<button class="btn btn-lg btn-primary pull-right" type="submit"
			style="font-weight: bold; font-family:">글쓰기</button>
	</a>	
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th style="width: 10%">번호</th>
					<th style="width: 40%">제목</th>
					<th style="width: 15%">작성자</th>
					<th style="width: 20%">날짜</th>
					<th style="width: 15%">조회수</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${listt}" var="list" varStatus="">
				<tr>
					<td>${list.fno}</td>
					<td><a href='<c:url value="/viewss/lookdo2">
					<c:param name="no" value="${list.no}"/>
					<c:param name="id" value="${list.id}"/>
					</c:url>'>	
					${list.title}</a></td>
					<td>${list.id}</td>
					<td>${list.date}</td>
					<td>${list.count}</td>

				</tr>
				</c:forEach>

			</tbody>
		</table>
		<nav class="text-center" aria-label="...">
			<ul class="pagination pagination-sm">
				<c:forEach var="i" begin="0" end="${pagenum}" step="1">
					<li class="page-item"><a class="page-link"
						href='<c:url value="/"><c:param name="no" value="${i+1}"/></c:url>'>${i+1}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</body>
</html>