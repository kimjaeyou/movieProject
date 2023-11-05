<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form:form action="/valid/create" modelAttribute="dto">
	작성자 : <input name="writer">
		<form:errors path="writer" element="div" delimiter="/"/><!--writer필드에 문제 있스면 출력 -->
		<br>
	내용 : <textarea rows="5" cols="30" name="content"></textarea>
		<form:errors path="content" element="div"/>
		<br>	
		<input type="submit">
	</form:form>
</body>
</html>