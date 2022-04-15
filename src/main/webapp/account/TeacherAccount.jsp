<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${result }
<div class = "Login">
	${sessionScope.taccountInfo.t_name }, 안녕하세요.(선생님)
	<button onClick='location.href="T_mypage"'>마이페이지</button>
	<button onClick='location.href="logoutC"'>로그아웃</button>

</div>
</body>
</html>