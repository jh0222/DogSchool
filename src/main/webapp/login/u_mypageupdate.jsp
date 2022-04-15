<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
		<h2>${r } ${sessionScope.uaccountInfo.u_name }(견주님)의 수정페이지</h2>

<form action="U_mypageUpdateC" name ="myForm" onsubmit="return call()"method="post">
		<div class="textForm">
			아이디
			<input name="id" class="id" value="${sessionScope.uaccountInfo.u_name  }" disabled="disabled">
		</div>
		<div class="textForm">
			비밀번호
			<input name="password" class="pw" value="${sessionScope.uaccountInfo.u_pw  }" >
		</div>
		<div class="textForm">
			비밀번호 확인
			<input name="password1" class="pw" >
		</div>
		<div class="textForm">
			이름
			<input name="name" class="name" value="${sessionScope.uaccountInfo.u_name  }">
		</div>	
		<div class="textForm">
			휴대전화번호</br>
			<c:choose>
				<c:when test="${fn:substring(sessionScope.uaccountInfo.u_phonenumber, 0, 3) eq '010'}">
					<select name="phonefirst">
		   				<option value="010" selected>010</option>
		   				<option value="011">011</option>
		   				<option value="016">016</option>
		   				<option value="017">017</option>
		   				<option value="018">018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:when test="${fn:substring(sessionScope.uaccountInfo.u_phonenumber, 0, 3) eq '011'}">
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011" selected>011</option>
		   				<option value="016">016</option>
		   				<option value="017">017</option>
		   				<option value="018">018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:when test="${fn:substring(sessionScope.uaccountInfo.u_phonenumber, 0, 3) eq '016'}">
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011">011</option>
		   				<option value="016" selected>016</option>
		   				<option value="017">017</option>
		   				<option value="018">018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:when test="${fn:substring(sessionScope.uaccountInfo.u_phonenumber, 0, 3) eq '017'}">
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011">011</option>
		   				<option value="016">016</option>
		   				<option value="017" selected>017</option>
		   				<option value="018">018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:when test="${fn:substring(sessionScope.uaccountInfo.u_phonenumber, 0, 3) eq '018'}">
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011">011</option>
		   				<option value="016">016</option>
		   				<option value="017">017</option>
		   				<option value="018" selected>018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:otherwise>
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011">011</option>
		   				<option value="016">016</option>
		   				<option value="017">017</option>
		   				<option value="018">018</option>
		   				<option value="019" selected>019</option>
					</select>
				</c:otherwise>
			</c:choose>					
			-
			<input name="phonesecond"class="phonenumber" maxlength='4' value="<c:out value="${fn:substring(sessionScope.uaccountInfo.u_phonenumber, 3, 7)}"></c:out>">
			-
			<input name="phonethird"class="phonenumber" maxlength='4' value="<c:out value="${fn:substring(sessionScope.uaccountInfo.u_phonenumber, 7, 11)}"></c:out>">
		</div>
		<div class="textForm">
			성 별
			<br>남<input name="gender" type="radio" checked="checked" value="man">
				 여<input name="gender" type="radio" value="woman">
		</div>

			<input type="hidden" name="id1" value="${sessionScope.uaccountInfo.u_id  }"  />
			<input type="submit" class="btn" value="수정페이지" />
</form>
</body>

</body>
</html>