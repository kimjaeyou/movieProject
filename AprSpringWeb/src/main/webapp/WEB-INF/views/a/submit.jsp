<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
이름 : ${a.name}<br>
나이 : ${a.age}<br>

생일 : ${a.birth}<br>
좋아하는 동물 : ${a.animals}<br><br>

여기부터 다름<br><hr><hr>
내가 선택한 내용 : ${a.animals}

</body>
</html>