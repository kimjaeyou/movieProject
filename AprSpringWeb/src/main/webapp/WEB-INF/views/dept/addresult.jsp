<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${msg=!null}">
		${msg}입니다<br>
	</c:if>
	${sn}개 부서추가됨
	${dept.dname}(${dept.deptno})부서 추가
</body>
</html>