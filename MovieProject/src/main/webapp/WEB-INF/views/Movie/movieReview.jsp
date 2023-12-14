<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Movie_review</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../../startbootstrap-shop-homepage-gh-pages/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="home">Movie=Pro</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="Ticketing">예매</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#!" role="button" data-bs-toggle="dropdown" aria-expanded="false">영화정보</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="MovieInfo">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="MovieInfo">Popular Items</a></li>
                                <li><a class="dropdown-item" href="MovieInfo">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex" action="MyPage" method="GET">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-emoji-laughing-fill"></i>
                            MyPage
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>
                    <form class="d-flex" action="login" method="GET"  style="padding-left:10px;">
                        <button class="btn btn-outline-dark" type="submit">
                            Login
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Header-->
        
        <section id="moviePost">		
			<div> 
				<div id="postText">
					<h3>대충 영화 제목 가져오는 api</h3>
					<div>대충 영화 제목 가져오는 api</div>
					<div>대충 영화 개봉년, 장르, 국가 가져오는 api</div>
					<div>대충 영화 연령 가져오는 api</div>
					<div>대충 영화 예매률 가져오는 api</div>
				</div>
			</div>
		</section>
		<hr>
		<p>
		<section id="movieDetail">
			<div id="movieCoverLeft"></div>
			<div id="movieCoverRight">
				<div id="starValue">평균 별점</div>
				<div>줄거리</div>
			</div>
		</section>
		<p>
		<hr>
		<section id="movieReview">
			<header>
				<div><h4>코멘트</h4></div>
				<p>
			</header>
			<ul id="movieComment">
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요&댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요&댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요&댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요&댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요&댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요&댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요&댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요&댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
			</ul>
		</section>
		
		

		<aside id="a">
			<div>게시판</div>
			<div>영화</div>
		</aside>
	</div>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-5 justify-content-center">
                <c:forEach items="${mlist}" var="option">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="../../image/imageMovie.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">"${option.movieNm}"</h5>
                                    <!-- Product price-->
                                    "${option.typeNm}"
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                            </div>
                        </div>
                    </div>
                    
                </c:forEach>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; MovieBox 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../../startbootstrap-shop-homepage-gh-pages/js/scripts.js"></script>
    </body>
</html>
