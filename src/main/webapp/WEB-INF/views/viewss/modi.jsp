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

      <form action="<c:url value="/viewss/ud"/>" method="post">
        <div class="form-group">
                <label class="col-form-label" for="inputDefault">Title</label>
                <input type="text" class="form-control" id="inputDefault" value="${title}" name="title">
              </div>
        <div class="form-group">
                    <label for="exampleTextarea">Contents</label>
                    <textarea class="form-control" id="exampleTextarea" rows="20" name="content">${content}</textarea>
                  </div>
        <button class="btn btn-lg btn-primary btn-inline pull-right" type="submit" name="button" value="yes,${no}">확 인</button>
        <button class="btn btn-lg btn-primary btn-inline pull-right" type="submit" name="button" value="no,${no}">취 소</button>
      </form>

    </div> <!-- /container -->
</body>
</html>