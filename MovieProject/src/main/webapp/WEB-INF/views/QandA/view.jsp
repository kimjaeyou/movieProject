<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					
		<style>
			#container {width: 70%;}
			table{width: 100%;}
		</style>
					
	</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="../../home">Movie=Pro</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="../../home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="Ticketing">예매</a></li>
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
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="../../QandA">Q&A</a></li>
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
        <div class="container-fluid"> <!-- container-fluid를 사용하여 전체 화면 너비로 설정 -->
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div id="container" style = "margin-left: 150px">
                        <table class="table table-bordered w-100 p-4">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col">${dto.qaTitle}</th>
                                    <th scope="col">작성자: ${dto.userID}</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td colspan="2" align="left">
                                    <pre>${dto.content}</pre>
                                    </td>
                                </tr>
                                <tr>
                                    <td>등록일: <fmt:formatDate value="${dto.registeredDate}" dateStyle="long" /></td>
                                    <td>조회수: ${dto.readCount}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="right">
                                        <c:if test="${userID == dto.userID}">
                                            <a href="/QandA/update/${dto.qaID}" class="btn btn-primary">글 수정</a>
                                            <a href="../../QandA/delete/${dto.qaID}" class="btn btn-danger">글 삭제</a>
                                        </c:if>
                                        <a href="../../QandA" class="btn btn-secondary">목록 이동</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <!-- ... -->

    <!-- Bootstrap core JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS -->
    <script src="../../startbootstrap-shop-homepage-gh-pages/js/scripts.js"></script>
</body>
</html>