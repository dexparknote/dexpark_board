<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div class="container">
		<div class="main">
			<div class="content-head">
				<h4>게시글 목록</h4>
				<button>새 글 쓰기</button>
				<form>
					<div>
						<input type="search" placeholder="검색어">
						<span>
							<button>검색</button>
						</span>
					</div>
					<div>
						<ul>
							<li><a href="#">최신순</a></li>
							<li><a href="#">추천순</a></li>
							<li><a href="#">조회순</a></li>
						</ul>
					</div>
				</form>
			</div>
			<div class="content-body">
				<table class="article-list">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<tr>
						<td>1</td>
						<td>게시판 혼자 만들어보기!</td>
						<td>2021-03-16 pm 2:50</td>
						<td>1</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>