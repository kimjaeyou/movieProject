<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*" %>
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
						aria-current="page" href="">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="Ticketing">예매</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#!"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">영화정보</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="reviewBoard">리뷰페이지</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="MovieInfo">Popular
									Items</a></li>
							<li><a class="dropdown-item" href="MovieInfo">New
									Arrivals</a></li>
						</ul></li>
				</ul>
				<form class="d-flex" action="MyPage" method="GET">
					<button class="btn btn-outline-dark" type="submit">
						<i class="bi-emoji-laughing-fill"></i> MyPage <span
							class="badge bg-dark text-white ms-1 rounded-pill">0</span>
					</button>
				</form>
				<form class="d-flex" action="login" method="GET"
					style="padding-left: 10px;">
					<button class="btn btn-outline-dark" type="submit">Login</button>
				</form>
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
		<div>
			<form method="post" action="movieHistory">
				<label for="review">리뷰 작성:</label>
				<textarea id="review" name="review" rows="4" cols="50"></textarea>
				<label for="rating">별점:</label>
            	<select id="rating" name="rating" required>
                	<option value="1">1</option>
                	<option value="2">2</option>
                	<option value="3">3</option>
                	<option value="4">4</option>
                	<option value="5">5</option>
                </select>
                <br> <input type="submit" value="리뷰 제출">
			</form>
		</div>
		<div>
			
		</div>
	</section>
		
	<div>
        <% 
            // 폼이 submit되면 실행될 코드
            if(request.getMethod().equals("POST")) {
                String reviewText = request.getParameter("review");
                int rating = Integer.parseInt(request.getParameter("rating"));

                Connection conn = null;
                PreparedStatement pstmt = null;

                try {
                    // JDBC 드라이버 로딩
                    Class.forName("com.mysql.jdbc.Driver");

                    // 데이터베이스 연결
                    String url = "jdbc:mysql://127.0.0.1:3306/projectMovie";
                    String user = "root";
                    String password = "root";
                    conn = DriverManager.getConnection(url, user, password);

                    // SQL 쿼리 실행
                    String sql = "INSERT INTO review (review_text, rating) VALUES (?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, reviewText);
                    pstmt.setInt(2, rating);
                    pstmt.executeUpdate();

                    out.println("<p>리뷰가 성공적으로 저장되었습니다.</p>");
                } catch (Exception e) {
                    out.println("<p>오류가 발생했습니다: " + e.getMessage() + "</p>");
                } finally {
                    try {
                        // 리소스 해제
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                }
            }
        %>
    </div>	
	
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="../../startbootstrap-shop-homepage-gh-pages/js/scripts.js"></script>
</body>
</html>
