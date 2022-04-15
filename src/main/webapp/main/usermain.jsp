<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${result }
<table id ="tableMenu">
		<tr>
			<td class="siteMenu" align="center"><a href="IntC">유치원 소개</a></td>
			<td class="siteMenu" align="center"><a href="Menu2_User">선생님 소개</a></td>
			<td class="siteMenu" align="center"><a href="applyC">신청서</a></td>
			<td class="siteMenu" align="center"><a href="mypetlist">마이펫 페이지</a></td>
		</tr>
</table>
<table id ="imgtable" border="1">
		<tr>
			<td><img src="img/main.jpg" width="100%" height="280px"></td>
		</tr>
</table>
<table id ="tableMenu" border="1">
		<tr class="Menu2sidebar"><td colspan="4" class="pl">가격표</td></tr>
		<tr>
			<td></td>
			<td> 소형견 </td>
			<td> 중형견 </td>
			<td> 대형견 </td>
		</tr>
		<tr>
			<td>7일</td>
			<td> 1000원 </td>
			<td> 2000원 </td>
			<td> 3000원 </td>
		</tr>
		<tr>
			<td>30일</td>
			<td> 10000원 </td>
			<td> 20000원 </td>
			<td> 30000원 </td>
		</tr>
</table>

<table id ="tableMenu" border="1">
	<tr>
	<td >
			<table id ="tableMenu1"  border="1">
				<tr class="td9">
					<td colspan="3" height="10px"><a href="NoticeboardC">공지사항</a></td>
				</tr>
				<tr>
					<td>
						제목
					</td>
					<td>
						작성자
					</td>
					<td>
						작성날짜
					</td>
				</tr>
				<c:forEach var="n" items="${n }">
				<tr>
					<td>
						<a href="NoticeDetailC?no=${n.n_no}">${n.n_title }</a>
					</td>
					<td>
						${n.n_id }
					</td>
					<td>
						${n.n_date }
					</td>
				</tr>
				</c:forEach>
			</table>
	</td>
	<td>
			<table id ="tableMenu1"  border="1">
				<tr class="td9">
					<td colspan="3" height="10px"><a href="Teacherpostscript_root_userC">선생님 후기</a></td>
				</tr>
				<tr>
						<td >
							제목
						</td>
						<td>
							작성자
						</td>
						<td>
							작성날짜
						</td>
					</tr>
					<c:forEach var="p" items="${p }">
					<tr>
						<td>
							<a href="PostscriptDetail_root_userC?no=${p.p_no}&id=${p.p_id }">${p.p_title }</a>
						</td>
						<td>
							${p.p_id }
						</td>
						<td>
							${p.p_date }
						</td>
					</tr>
					</c:forEach>
			</table>
	</td>
	<td>
			<table id ="tableMenu1" border="1" >
				<tr class="td9">
					<td colspan="2" height="10px"><a href="ScheduleboardC">오늘의 시간표</a></td>
				</tr>
				<tr>
					<td width="40%">1교시</td>
					<td width="60%">${day[0] }</td>
					
				</tr>
				<tr>
					<td width="40%">2교시</td>
					<td>${day[1] }</td>
				</tr>
				<tr>
					<td width="40%">3교시</td>
					<td>${day[2] }</td>
				</tr>
				<tr>
					<td width="40%">4교시</td>
					<td>${day[3] }</td>
				</tr>
				<tr>
					<td width="40%">5교시</td>
					<td>${day[4] }</td>
				</tr>
				<tr>
					<td width="40%">6교시</td>
					<td>${day[5] }</td>
				</tr>
				<tr>
					<td width="40%">7교시</td>
					<td>${day[6] }</td>
				</tr>
			</table>
	</td>
	</tr>
</table>
</body>
</html>