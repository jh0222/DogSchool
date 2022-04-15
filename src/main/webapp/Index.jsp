<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/menu2.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/board.js"></script>
</head>
<body>

	<jsp:include page="${loginPage }"></jsp:include>
	<div>
		<h1> <a class="mainname" href="HC">강아지 유치원</a> </h1>
	</div>
	<jsp:include page="${contentPage }"></jsp:include>
</body>
</html>