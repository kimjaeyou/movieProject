<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>내가 본 영화</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../../startbootstrap-shop-homepage-gh-pages/css/styles.css"
	rel="stylesheet" />
</head>
<body>

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
					<li class="nav-item"><a class="nav-link" href="home">이벤트</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#!"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">영화정보</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="MovieInfo">All
									Products</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="MovieInfo">Popular
									Items</a></li>
							<c:if test="${not empty userid}">
								<li><a class="dropdown-item" href="movieHistory">내가 작성한
										리뷰</a></li>
							</c:if>
						</ul></li>
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
				<p class="lead fw-normal text-white-50 mb-0">리뷰</p>
			</div>
		</div>
	</header>

	<section>
		<div class="big_frame">
			<div style="display: inline-block;">
				<img src="../../../images/HarryPotter_post.jpg"> <span><%=request.getParameter("movieNm")%></span>
			</div>
			<div>
				<form method="post" action="reviewList">
					<input id="user_id" value="${user_id}" name="user_id"
						hidden="hidden"> <input id="movieCd"
						value="<%=request.getParameter("movieCd")%>" name="movieCd"
						hidden="hidden"> <label for="review">리뷰 작성:</label>
					<textarea name="content" rows="5" cols="60" maxlength="300"></textarea>
					<label for="score">별점:</label> <select id="score" name="score"
						size="1" required>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> <br> <input type="submit" value="리뷰 제출">
				</form>
			</div>

		</div>
	</section>

	<div></div>

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
