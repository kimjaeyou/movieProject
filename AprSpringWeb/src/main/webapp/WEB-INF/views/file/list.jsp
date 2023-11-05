<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>파일 목록</title>
</head>
<body>
<h3>업로드한 파일 목록</h3>
<form enctype="multipart/form-data" action="/delete" method="get">
<table>
    <tr><th>파일 번호</th><th>파일 이름</th><th>파일 크기</th><th>미리보기</th></tr>
    <c:forEach items="${fList}" var="file">
        <tr>
            <td>${file.fileid}</td>
            <td><a href="/filedownload/${file.fileid}">${file.name}</a></td>
            <td>${file.filesize}</td>
            <td><img src="/mainImg/${file.path}" width="50px" height="50px">
            <input type="submit" value="삭제" name="file" formaction="/delete/${file.fileid}" >
            <!--onclick으로도 -->
            </td>
        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
	function deletefile(id){
		location.href="/deleteFile/"+id;
	}
</script>
</form>
</body>
</html>
