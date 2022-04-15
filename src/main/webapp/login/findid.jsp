<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/find.css" type="text/css" >
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
	<div class="loginform">
		<h1>아이디 찾기</h1>
		<form action="FindidC" name ="myForm" onsubmit="return findid()" method="post">
			<input name="name" type="text" placeholder="이름"> 
			<input name="phonenumber" type="text" placeholder="전화번호"> 
				<input type="submit" value="아이디 찾기">
		</form>
	</div>
</body>
</html>