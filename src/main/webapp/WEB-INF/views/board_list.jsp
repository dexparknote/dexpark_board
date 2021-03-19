<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://localhost:9000/board/css/board.css">
<script src="http://localhost:9000/board/js/jquery-3.5.1.min.js"></script>
<title>게시판</title>
<script>
	$(document).ready(function() {
		$("#write_btn").click(function(){
			$(location).attr("href","http://localhost:9000/board/board_write.do");
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="main">
			<div class="content-head">
				<h4>게시글 목록</h4>
				<button type="button" id="write_btn">새 글 쓰기</button>
				<form>
					<div class="search-part">
						<input type="search" placeholder="검색어">
						<span>
							<button type="button" id="search-btn">검색</button>
						</span>
					</div>
					<div class="sort-part">
						<ul>
							<li><a href="#" class="sort-item">최신순</a></li>
							<li><a href="#" class="sort-item">추천순</a></li>
							<li><a href="#" class="sort-item">조회순</a></li>
						</ul>
					</div>
				</form>
			</div>
			<div class="content-body">
				<ul class="article-list">
					<c:forEach var="vo" items="${ list }">
						<li class="article-items" onclick="location.href='http://localhost:9000/board/board_content.do?bid=${ vo.bid }'">
							<div class="article-num">#${ vo.rno }</div>
							<div class="article-title">${ vo.btitle }</div>
							<div class="article-detail">
								<span class="article-date">${ vo.bdate }</span>
								<span class="article-views">${ vo.views }</span>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>