<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title>영화리뷰사이트-Q&A게시판</title>
		<!-- Favicon-->
		<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
		<!-- Bootstrap icons-->
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
			rel="stylesheet" />
		<!-- Core theme CSS (includes Bootstrap)-->
		<link href="../../startbootstrap-shop-homepage-gh-pages/css/styles.css"
			rel="stylesheet" />
		
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
			    $("#writeBtn").click(function(){
					var id="${userID}";
			    	if(id == "")
			    		location.href ="login";
			    	else if(id !== "")
			    		location.href ="/QandA/write";
			    })
			    $.ajax({url: "QandAList", success: function(result){             
			        var html = "";
			    	result.forEach(function(item){
			        	html+= "<tr> <td><a href = 'view?qaID=" + item.qaID + "'>" + item.qaTitle + "</a>"
			        })
			       $("#listArea").append(html)
			       $('#example').DataTable();
			     }});
			     $("#deleteBtn").click(function(){
			    	location.href ="write";
			     })
			} );
			
		</script>	
	</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="home">Movie=Pro</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="Ticketing">예매</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#!"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">영화정보</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="MovieInfo">All
									Products</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="MovieInfo">Popular
									Items</a></li>
							<li><a class="dropdown-item" href="MovieInfo">New
									Arrivals</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="QandA">Q&A</a></li>
				</ul>
				<c:if test="${not empty userid}">
					<form class="d-flex" action="MyPage" method="GET">
				</c:if>
				<c:if test="${empty userid}">
					<form class="d-flex" action="login" method="GET">
				</c:if>
				<button class="btn btn-outline-dark" type="submit">
					<i class="bi-emoji-laughing-fill"></i> MyPage <span
						class="badge bg-dark text-white ms-1 rounded-pill">0</span>
				</button>
				</form>
				<c:if test="${empty userid}">
					<form class="d-flex" action="login" method="GET"
						style="padding-left: 10px;">
						<button class="btn btn-outline-dark" type="submit">Login
						</button>
					</form>
				</c:if>
				<c:if test="${not empty userid}">
					<form class="d-flex" action="logout" method="GET"
						style="padding-left: 10px;">
						<button class="btn btn-outline-dark" type="submit">
							Logout</button>
					</form>
				</c:if>
			</div>
		</div>
	</nav>
	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">Movie=Pro</h1>
				<p class="lead fw-normal text-white-50 mb-0">영화관 예매 시스템</p>
			</div>
		</div>
	</header>
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div class="row gx-4 gx-lg-5">
				<div class="col-lg-12">
					<div class="text-center">
						<h2 class="section-heading text-uppercase">Q&A게시판</h2>
					</div>
					<div class= "container">
    	<div= "row">
    	    <table class= "table table-stripped" style= "text-align: center; boarder: 1px solid #dddddd">
    	    	<thead>
    	    	<tr>
    	    		<th style= "background-color: #eeeeee; text-align: center;">글번호</th>
    	    		<th style= "background-color: #eeeeee; text-align: center;">제목</th>
    	    		<th style= "background-color: #eeeeee; text-align: center;">작성자</th>
    	    		<th style= "background-color: #eeeeee; text-align: center;">작성일</th>
    	    	</tr>
    	    	</thead>
    	    	<tbody id = "listArea">
    	    	<c:forEach items="${QAList}" var="board">
                    <tr>
                        <td>${board.qaID }</td>
                        <td><a href ="QandA/content/${board.no}">${board.qaTitle}</a></td>
                        <td>${board.userID}</td>
                        <td><fmt:formatDate value="${board.registeredDate}" dateStyle="short"/> </td>
                    </tr>
                </c:forEach>
		        </tbody>
		   	</table>
			<button type="button" class="btn btn-primary" id = "writeBtn" >글쓰기</button>
    	</div>
    </div>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2023</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="../../startbootstrap-shop-homepage-gh-pages/js/scripts.js"></script>
</body>
</html>
