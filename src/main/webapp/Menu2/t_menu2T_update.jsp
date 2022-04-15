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
		<h2>${r } ${sessionScope.taccountInfo.t_name }(선생님)의 수정페이지</h2>

<form action="T_Menu2UpdateC" name ="myForm" onsubmit="return call()"method="post">
		<div class="textForm">
			아이디
			<input name="id" class="id" value="${sessionScope.taccountInfo.t_id  }" disabled="disabled">
		</div>
		<div class="textForm">
			비밀번호
			<input name="password" class="pw" value="${sessionScope.taccountInfo.t_pw  }" >
		</div>
		<div class="textForm">
			이름
			<input name="name" class="name" value="${sessionScope.taccountInfo.t_name  }">
		</div>
		<div class="textForm">
			휴대전화번호
			<input name="phonenumber"class="phonenumber" value="${sessionScope.taccountInfo.t_phonenumber  }">
		</div>
		<div class="textForm">
			성 별
			<br>남<input name="gender" type="radio" checked="checked" value="man">
				 여<input name="gender" type="radio" value="woman">
		</div>
		<div class="textForm">
			자기소개<br>
			<textarea name='txt'>${sessionScope.taccountInfo.t_text  }</textarea>
		</div>
			<input type="hidden" name="id1" value="${sessionScope.taccountInfo.t_id  }"  />
			<input type="submit" class="btn" value="수정페이지" />
</form>
</body>

</body>
</html>