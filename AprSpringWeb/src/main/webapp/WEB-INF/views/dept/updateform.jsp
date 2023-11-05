<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>${deptno}번 부서 정보 변경</title>
</head>
<body>
	<form method="post" action="/update">
		<input type="hidden" name="_method" value="put">
		<input type="hidden" name="deptno" value="${ deptno}">
		<h1>부서 정보 변경</h1><br> 
			부서번호: <input name="deptno" value="${deptno}" readonly="readonly"><br>
			부서이름: <input name="dname"><br> 
			부서위치: <input name="loc"><br> <input type="submit">
	</form>
</body>
</html>