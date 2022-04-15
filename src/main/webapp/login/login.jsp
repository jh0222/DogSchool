<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css" type="text/css" >
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>

</head>
<body>

<div class="loginform">

        <h1> <a href="HC">강아지 유치원</a></h1>
        <form action="LoginController" name ="myForm" onsubmit="return logincall()"method="post">
            <input name = "id" type="text" placeholder="아이디">
            <input name = "pw" type="password" placeholder="비밀번호">
            <input type="submit" value="로그인">
        </form>
        
        <div class="forgot">
            <a href="FindidC">아이디 찾기</a>
            <a href="FindpassC">비밀번호 찾기</a>
        </div>
    </div>
</body>
</html>