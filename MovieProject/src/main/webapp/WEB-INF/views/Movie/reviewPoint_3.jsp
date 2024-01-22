<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>영화 리뷰</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link
	href="../../startbootstrap-shop-homepage-gh-pages/css/reviewList.css"
	rel="stylesheet" />

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
					<li class="nav-item"><a class="nav-link" href="home">이벤트</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#!"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">영화정보</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="reviewList">영화 리뷰</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="MovieInfo">박스오피스</a></li>
							<c:if test="${not empty userid}">
								<li><a class="dropdown-item" href="movieHistory">내가 작성한
										리뷰</a></li>
							</c:if>
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
				<p class="lead fw-normal text-white-50 mb-0">영화 리뷰</p>
			</div>
		</div>
	</header>

	<div>
		<section>
			<div>
				<div>
					<form method="get" action="search.php">
						<div class="searchReview">
							<input class="searchInput" type="text" name="stx"
								placeholder="제목 입력"> <img class="searchImg"
								src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"
								alt="Submit">
						</div>
					</form>
				</div>
				<div>
					<div></div>
				</div>
			</div>

			<div class="searchLine">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#!"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">별점검색</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="reviewPoint_1">1점</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="reviewPoint_2">2점</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="reviewPoint_3">3점</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="reviewPoint_4">4점</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="reviewPoint_5">5점</a></li>
						</ul>
				</ul>
			</div>
		</section>
	</div>

	<!-- Section-->
	<section class="py-5">
		<div>
			<div style="margin: 3.5% 3.5%;">
				<c:forEach items="${point_3}" var="review">
					<div
						style="display: flex; height: 120px; overflow: hidden; text-overflow: ellipsis;">
						<img src=${review.poster} width="10%">
						<table border="1" width="100%" cellspacing="5">
							<thead>
								<tr align="center">
									<th width="15%">영화 코드</th>
									<th width="40%">리뷰 내용</th>
									<th width="15%">별점</th>
									<th width="30%">작성자</th>
								</tr>
							</thead>

							<tbody>
								<tr align="center">
									<td>${review.movieCd}</td>
									<td
										style="max-width: 100px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">${review.content}</td>
									<td>${review.score}</td>
									<td>${review.user_id}</td>
								</tr>
							</tbody>
						</table>
					</div>
					<br>
				</c:forEach>
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
