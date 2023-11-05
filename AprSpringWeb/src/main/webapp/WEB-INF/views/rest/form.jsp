<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>restcontroller</h1>
	post form
	<form method="post">
	<input name="name">
	<input type="submit">
	</form>
	
	put form
	<form method="post">
	<input type="hidden" name="_method" value="put">
	<input name="name">
	<input type="submit">
	</form>
	
	delete form
	<form method="post">
	<input type="hidden" name="_method" value="delete">
	<input name="name">
	<input type="submit">
	</form>
</body>
</html>