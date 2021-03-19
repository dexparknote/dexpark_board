<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://localhost:9000/board/css/board.css">
<title>게시판</title>
</head>
<body>
	<div class="container">
		<div class="main">
			<div class="content-head">
				<h4>게시글</h4>
			</div>
			<div class="content-body">
				<div class="article-content">
					<h2 class="article-title">${ btitle }</h2>
					<span class="article-date">${ bdate }</span>
					<span class="article-views">${ views }</span>
					<hr>
					<div class="article-body">
						<div style="text-align: center; margin-top:50px;">
							<img src="http://localhost:9000/board/resources/upload/ ${ bsfile }"
							style="width: 150px; height: 150px;">
						</div>
						<div>${ bcontent }</div>
					</div>
					<div class="btn-area">
						<button type="button" id="delete-btn">삭제</button>
						<button type="button" id="update-btn">수정</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>