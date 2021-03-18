<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://localhost:9000/board/css/board.css">
<script src="http://localhost:9000/board/js/jquery-3.5.1.min.js"></script>
<title>게시판</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#enroll-btn").click(function(){
			var chk = confirm("게시물을 등록하시겠습니까?");
			if(chk) {
				writeForm.submit();
			} 
		});
		
		$(".cancel-btn").click(function(){
			$(location).attr("href","http://localhost:9000/board/board_list.do");
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="main">
			<div class="content-head">
				<h4>게시글 작성</h4>
			</div>
			<div class="content-body">
				<form name="writeForm" action="boardWriteProc.do" method="post" enctype="multipart/form-data">
					<div class="update-title-area">
						<input type="search" name="btitle" placeholder="제목을 입력해 주세요.">
					</div>
					<div class="update-body-area">
						<textarea name="bcontent"></textarea>
					</div>
					<div class="update-file-area">
						<input type="file" name="file1">
					</div>
					<div class="update-btn-area">
						<button type="button" class="cancel-btn">취소</button>
						<button type="button" id="enroll-btn">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>