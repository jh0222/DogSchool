<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/teacher.css" type="text/css" >
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/teacher.js"></script>
</head>
<body>
<table id ="tableMenu" border="1">
		<tr class="Menu2sidebar">
			<td colspan="9">${sessionScope.uaccountInfo.u_name } 견주 페이지</td>
		</tr>
		<tr>
			<td class="td2">사용자 아이디</td> 
			<td class="td2">강아지 이름</td> 
			<td class="td2">성별</td>
			<td class="td2">시작 기간</td>
			<td class="td2">종료 기간</td>
			<td class="td2">나이</td>
			<td class="td2">사진</td>
		</tr>
		
		<c:forEach var="a" items="${applyBeans }">
			<tr>
				<td>${a.a_id}</td>
				<td><a href="Menu1_u?tname=${a.a_tname }&name=${a.a_name}">${a.a_name}</a></td>
				<td>${a.a_gender}</td>
				<td>${a.a_start}</td>
				<td>${a.a_end}</td>
				<td>${a.a_age}</td>
				<td><img src="file/${a.a_img }" width="150" height="100" ></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>