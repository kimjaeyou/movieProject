<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사원명 검색 결과</title>
</head>
<body>
	결과<br>
	<c:if test="${ename}!=0">
		<c:forEach items="${ename}" var="emp">
			사번 : ${emp.empno}/이름 :  ${emp.ename } /소속 : ${emp.dname} 
			<br>
		</c:forEach>
	</c:if>
	<c:if test="${ename}=0"><h1>no match!!!<h1></c:if>
</body>
</html>