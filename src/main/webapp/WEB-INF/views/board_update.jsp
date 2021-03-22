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
	$(document).ready(function() {
		$("#updateProc-btn").click(function(){
			var chk = confirm('정말로 수정하시겠습니까?');
			if(chk) {
				update.submit();
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="main">
			<div class="content-head">
				<h4>게시글 수정</h4>
			</div>
			<div class="content-body">
				<form name="update" action="boardUpdateProc.do?bid=${ bid }" method="post" enctype="multipart/form-data">
					<div class="update-title-area">
						<input type="text" name="btitle" value="${ btitle }">
					</div>
					<div class="update-body-area">
						<textarea name="bcontent">${ bcontent }</textarea>
					</div>
					<div class="update-file-area">
						<input type="file" name="file1"><!--  <span class="file-name">${ bfile }</span>-->
					</div>
					<div class="update-btn-area">
						<button type="button" class="cancel-btn" onclick="location.href='http://localhost:9000/board/board_list.do'">취소</button>
						<button type="button" id="updateProc-btn">수정</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>