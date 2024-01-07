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
<link href="../../startbootstrap-shop-homepage-gh-pages/css/styles.css"
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
	<header class="bg_header">
		<section id="moviePost">
			<div>
				<div id="postText">
					<h1>뒤에 있는 포스터는 api로 가져옴</h1>
					<br>
					<h3><%=request.getParameter("movieNm")%></h3>
					<div><%=request.getParameter("movieNm")%></div>
					<div><%=request.getParameter("prdYear")%>
						-
						<%=request.getParameter("typeNm")%></div>
					<div>대충 DB에서 가져온 영화 연령값 or 아무거나</div>
					<div>대충 DB에서 가져온 영화 예매률 or 아무거나</div>
				</div>
			</div>
		</section>
	</header>

	<div class="big_frame">
		<!-- section -->
		<section id="movieDetail">
			<div id="movieCoverLeft">
				<div>
					<div id="imgDiv"></div>
				</div>
			</div>

			<div id="movieCoverRight">
				<div>
					<div>
						<div id="starValue">평균 별점 DB에서 가져오기</div>
					</div>
					<br> <br>
					<div>
						<div>해리 포터는 위압적인 버논 숙부와 냉담한 이모 페투니아, 욕심 많고 버릇없는 사촌 더들리 밑에서
							갖은 구박을 견디며 계단 밑 벽장에서 생활한다. 이모네 식구들 역시 해리와의 동거가 불편하기는 마찬가지. 이모
							페투니아에겐 해리가 이상한(?) 언니 부부에 관한 기억을 떠올리게 만드는 달갑지 않은 존재다. 11살 생일이 며칠
							앞으로 다가왔지만 한번도 생일파티를 치르거나 제대로 된 생일선물을 받아 본 적이 없는 해리로서는 특별히 신날 것도
							기대 할 것도 없다. 11살 생일을 며칠 앞둔 어느 날 해리에게 초록색 잉크로 쓰여진 한 통의 편지가 배달된다. 그
							편지의 내용은 다름 아닌 해리의 11살 생일을 맞이하여 전설적인“호그와트 마법학교”에서 보낸 입학초대장이었다. 그리고
							해리의 생일을 축하하러 온 거인 해그리드는 해리가 모르고 있었던 해리의 진정한 정체를 알려주는데. 그것은 바로 해리가
							굉장한 능력을 지닌 마법사라는 것!</div>
						<div>↑↑↑movie_list에 줄거리를 입력해서 가져오는 방법이 있음↑↑↑</div>
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
								<div>좋아요&댓글수</div>
								<hr>
								<div><input type="button" value="좋아요"></div>
							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>
			<c:if test="${not empty userid}">
				<a href="reviewScript?movieCd=${movieCd}&movieNm=${movieNm}"><input
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
