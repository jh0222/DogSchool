<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
<div class="Login">

		${sessionScope.accountInfo.u_id }

		<button onclick='location.href="Index.jsp"'>로그아웃</button>
		<button onclick='location.href=""'>마이페이지</button>
	</div>
	<div>
		<h1>강아지 유치원</h1>
	</div>
	<table id="tableMenu">
		<tr>
			<td class="siteMenu" align="center"><a href="Menu1">유치원 소개</a></td>
			<td class="siteMenu" align="center"><a href="Menu2">선생님 소개</a></td>

		</tr>
	</table>
	<table id="imgtable">
		<tr>
			<td><img src="img/main.jpg" width="1000px" height="250px"></td>
		</tr>
	</table>
	<table id="subMenu">
		<tr>
			<td colspan="4" class="pl">가격표</td>
		</tr>
		<tr>
			<td></td>
			<td>소형견</td>
			<td>중형견</td>
			<td>대형견</td>
		</tr>
		<tr>
			<td>7일</td>
			<td>1000원</td>
			<td>2000원</td>
			<td>3000원</td>
		</tr>
		<tr>
			<td>30일</td>
			<td>10000원</td>
			<td>20000원</td>
			<td>30000원</td>
		</tr>
	</table>
	<table id="subMenu">
		<tr>
			<td><a href="Menu3">공지사항</a></td>
			<td><a href="Menu4">오늘의 시간표</a></td>
			<td><a href="Menu5">선생님 후기</a></td>
		</tr>
		<tr>
			<td><jsp:include page="${contentPage1 }"></jsp:include></td>
			<td><jsp:include page="${contentPage2 }"></jsp:include></td>
			<td><jsp:include page="${contentPage3 }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>