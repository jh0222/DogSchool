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

	<form action="TsignupC" name ="myForm" onsubmit="return call()"method="post">
		<br>
		<h2>선생님 회원가입</h2>
				<jsp:include page="${idcheck }"></jsp:include>
		<div class="textForm">
			비밀번호
			<input name="password" type="password" class="pw">
		</div>
		<div class="textForm">
			비밀번호 확인
			<input name="password1" type="password" class="pw">
		</div>
		<div class="textForm">
			이름
			<input name="name" class="name" >
		</div>
		<div class="textForm">
            휴대전화번호<br>
            <select name="phonefirst">
                   <option value="010">010</option>
                   <option value="011">011</option>
                   <option value="016">016</option>
                   <option value="017">017</option>
                   <option value="018">018</option>
                   <option value="019">019</option>
            </select>
            - <input name="phonesecond"class="phonenumber" maxlength='4'>
            - <input name="phonethird"class="phonenumber" maxlength='4'>
        </div>
        <div class="textForm">
			성 별
			<br>남<input name="gender" type="radio" checked="checked" value="man">
				 여<input name="gender" type="radio" value="woman">
		</div>
		<div class="textForm">
			자기소개<br>
			<textarea name='txt'></textarea>
		</div>
			<input type="hidden" name="id1" value="${result1 }"  />
			<input type="submit" class="btn" value="가입하기" />
	</form>
		
</body>

</html>