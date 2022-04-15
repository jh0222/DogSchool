<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/signup.css" type="text/css" >
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
		<br>
		<h2>${sessionScope.uaccountInfo.u_name }(견주님)의 마이페이지</h2>
<form action="U_mypageUpdate">
		<div class="textForm">
			아이디<br>
			${sessionScope.uaccountInfo.u_id  }
		</div>
		
		<div class="textForm">
			비밀번호<br>
			${sessionScope.uaccountInfo.u_pw  }
		</div>
		<div class="textForm">
			이름<br>
			${sessionScope.uaccountInfo.u_name  }
		</div>
		<div class="textForm">
			휴대전화번호<br>
			${sessionScope.uaccountInfo.u_phonenumber  }
		</div>
			<input type="submit" class="btn" value="수정페이지" />
</form>
		<br>
		<input type="submit" class="btn" onclick="delete_u_mypage('${sessionScope.uaccountInfo.u_id }');" value="탈퇴하기" />
</body>
</html>