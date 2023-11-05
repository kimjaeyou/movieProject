<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 쓰기</title>
</head>
<body>
	게시글 쓰기 입력 폼:
	<form method="post">
		<!-- 여러개 넘기면 배열 -->
		<input type="hidden" name="parentId" value="10" />
		<input type="hidden" name="parentId" value="11" /> 
		<input type="hidden" name="parentId" value="12" /> 
		제목: <input type="text" name="title" /><br/>
		내용: <textarea name="content"></textarea><br/>
		<input type="submit" />
	</form>
</body>
</html>
