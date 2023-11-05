<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>부서명 검색 결과</title>
</head>
<body>
	결과<br>
	<c:forEach items="${deptAll}" var="dept">
	<a href="update?deptno=${dept.deptno}">${dept.deptno}</a>
	/ ${dept.dname } / ${dept.loc} 
	<br>
</c:forEach>
</body>
</html>