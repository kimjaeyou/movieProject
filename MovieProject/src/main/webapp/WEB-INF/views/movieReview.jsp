<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>리뷰게시판</title>
		<style>
			section
			{
				border : 2px solid blue;
			}
			aside
			{	
				margin-top :30px; 
				border : 2px solid yellow;
			}
			#all
			{
				margin : 0 3.5%;
			}
			#menuBar
			{
				position: fixed;
				top: 0px; /* 탭이 페이지 위에 숨겨져 있을 때의 위치 */
				left: 0;
				width: 100%;
				background-color: olive;
				color: #fff;
				padding: 20px;
				text-align : center;
				z-index : 1;
				transition: top 0.3s ease;
			}
			@media screen and (max-width: 600px) {
   				 #menuBar {
					padding: 10px;
    				}
    				#menuBar ul li {
      					display: block;
      					padding: 10px 0;
				}
			}
			#menuBar ul
			{
				margin : 0;
				padding : 0;	
			}
			#menuBar ul li
			{	
				display : inline-block;
				list-style-type : none;
				padding : 0px 15px;	
			}
			#menuBar ul li a
			{
				color : white;
				text-decoration : none;
				transition : color 0.3s ease;	
			}
			#menuBar ul li a:hover
			{
				color: violet;
			}
			#moviePost
			{
				position: relative;
				width : 100%;
				height : 500px;
				margin-top: 100px;
				background-image : url();
				background-position : center;
				background-size: cover;
			}
			#postText
			{	
				position : absolute;
            				bottom : 0;
            				left : 0;
				margin-bottom : 100px;
				color : black;
				padding : 10px;
			}
			#movieDetail
			{
				display : flex;
				align-items : center;
			}
		        	#movieCoverLeft
			{
				background-image : url('한전KDN빛가람SW_Kiosk_img\\RoomDB_img.png');
				background-position : center;
				background-size: cover;
				width : 20%;
				height : 200px;
        			}
			#movieCoverRight
			{
				width : 80%;
				text-align : center;
			}
			#movieComment
			{	
				display : grid;
				grid-template-columns : repeat(4, minmax(0px, 1fr));
				gap : 8px;	
				padding-left : 0px;	
			}
			.movieCommentList
			{
				verticle-align : top;
				box-sizing : border-box;
				width : 100%;
				display : block;
				padding : 0px;
			}
			.commentBox
			{
				border : 2px solid red;
				box-shadow : 0 4px 8px rgba(0, 0, 0, 0.1);
				padding : 10px;
				margin-bottom : 10px;
			}
		</style>
	</head>
	<body>
		<div id="all">
		<header>
			<nav id="menuBar">
				<ul>
					<li><input type="text" placeholder="키워드 입력"></li>
					<li><a href="#">로그인</a></li>
					<li><a href="#">회원가입</a></li>
				</ul>
			</nav>
		</header>

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
						<div>좋아요 및 댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요 및 댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요 및 댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요 및 댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요 및 댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요 및 댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요 및 댓글수</div>
						<div>좋아요 버튼</div>
					</div>
				</li>
				<li class="movieCommentList">
					<div class="commentBox">
						<div>프로필</div>
						<div>내용</div>
						<div>좋아요 및 댓글수</div>
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
	</body>	
	
</html>