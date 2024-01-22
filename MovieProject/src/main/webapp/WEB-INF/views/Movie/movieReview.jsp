<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>영화 포스터</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link
	href="../../startbootstrap-shop-homepage-gh-pages/css/movieReview.css"
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
				<p class="lead fw-normal text-white-50 mb-0">영화 리뷰시스템</p>
			</div>
		</div>
	</header>



	<div class="big_frame">
		<!-- section -->
		<section id="movieDetail">
			<div id="movieCoverLeft">
				<div>
					<img class="card-img-top" src=${post } alt="..." />
				</div>
			</div>

			<div id="movieCoverRight">
				<div>
					<div>
						<div id="starValue">평균 별점 DB에서 가져오기</div>
					</div>
					<br>
					<div class="movieTitle"><b>${movieTitle}</b></div>
					<br>
					<div>
						<div>${str}</div>
					</div>
					<div></div>
				</div>
			</div>
		</section>
	</div>

	<div class="big_frame">
		<!-- section -->
		<section id="movieReview">
			<header>
				<h3>코멘트</h3>
				<span>${fn:length(getReview)}</span>
				<div id="comment_plus">
					<div>
						<a href="reviewList">더보기</a>
					</div>
				</div>
			</header>
			<ul id="movieComment">
				<c:forEach items="${getReview}" var="option" varStatus="loop">
					<c:if test="${loop.index < 8}">
						<li class="movieCommentList">
							<div class="commentBox">
								<div>${option.user_id}</div>
								<hr>
								<div class="ellipsis">${option.content}</div>
								<hr>
								<div>
									<img src="../../../images/like.png"><em>0</em>&nbsp;<img
										src="../../../images/comment.png"><em>0</em>
								</div>
								<hr>
								<div>
									<input type="button" value="좋아요">
								</div>
							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>
			<c:if test="${not empty userid}">
				<a
					href="reviewScript?movieCd=${movieCd}&movieNm=${movieNm}&movieCd=${movieCd}&post=${post}&movieTitle=${movieTitle}"><input
					type="button" value="리뷰 작성하기"></a>
			</c:if>
			<c:if test="${empty userid}">
				<a href="login"><input type="button" value="리뷰 작성하기"></a>
			</c:if>
		</section>
	</div>


	<aside id="a">
		<div>게시판</div>
		<div>영화</div>
	</aside>
	</div>

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
