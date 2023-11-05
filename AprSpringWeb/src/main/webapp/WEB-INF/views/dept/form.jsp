<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>부서 추가</title>
</head>
<body>
	<form method="post">
		<h1>부서 추가</h1><br> 
		부서이름: <input name="dname"><br> 
		부서번호: <input name="deptno" value="${nw}" readonly="readonly"><br> 
		부서위치: <input name="loc"><br>
		<input type="submit">
	</form>
</body>
</html>