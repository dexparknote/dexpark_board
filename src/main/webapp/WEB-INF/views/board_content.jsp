<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://localhost:9000/board/css/board.css">
<script src="http://localhost:9000/board/js/jquery-3.5.1.min.js"></script>
<title>게시판</title>
<script>
	function moveUpdatePage(bid) {
		var chk = confirm('수정 화면으로 넘어가시겠습니까?');
		if(chk) {
			$(location).attr('href','http://localhost:9000/board/board_update.do?bid='+bid);
		}
	}
	
	function moveDeletePage(bid) {
		var chk = confirm('정말로 삭제하시겠습니까?');
		if(chk) {
			$.ajax({
				url: "http://localhost:9000/board/board_delete.do?bid="+bid,
				success: function(result) {
					if(result) {
						alert("삭제가 완료되었습니다.");
						$(location).attr('href','http://localhost:9000/board/board_list.do');
					}
				}	
			});
		}
	}
	
	
</script>
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
						<button type="button" id="delete-btn" onclick="moveDeletePage('${bid}')">삭제</button>
						<button type="button" id="update-btn" onclick="moveUpdatePage('${bid}')">수정</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>