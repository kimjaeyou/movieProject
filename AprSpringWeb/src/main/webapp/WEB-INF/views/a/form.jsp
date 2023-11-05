<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form method="post">
	<fieldset>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		생일 : <input type="date" name="birth" placeholder="yyyyMMdd"><br>
		좋아하는 동물<br>
		<input type="checkbox" name="animals" value="고양이" id="cat"><label for="cat">고양이</label>
		<input type="checkbox" name="animals" value="강아지">강아지
		<input type="checkbox" name="animals" value="토끼">토끼
		<input type="submit"/>
	</fieldset>
	</form>




</body>
</html>