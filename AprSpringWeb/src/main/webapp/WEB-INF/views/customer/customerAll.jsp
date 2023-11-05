<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>고객 정보</title>
</head>
<body>
<h3>모든 고객 정보를 출력합니다.</h3>

<c:forEach items="${customerAll}" var="dept">
	${ dept.custid} / ${dept.name } / ${dept.address } 
	<br>
</c:forEach>

</body>
</html>
