<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>spring 시작!!</title>

</head>
<body>
	${hello}
	<c:forEach var="i" begin="1" end="9">
		<li>4 * ${i} = ${4 * i}</li>
	</c:forEach>
</body>
</html>