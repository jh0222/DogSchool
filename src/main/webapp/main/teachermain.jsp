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
			<td class="siteMenu" align="center"><a href="IntC">��ġ�� �Ұ�</a></td>
			<td class="siteMenu" align="center"><a href="Menu2_Teacher">������ �Ұ�</a></td>
			<td class="siteMenu" align="center"><a href="TeacherC">������ ������</a></td>
		</tr>
</table>
<table id ="imgtable" border="1">
		<tr>
			<td><img src="img/main.jpg" width="100%" height="280px"></td>
		</tr>
</table>
<table id ="tableMenu" border="1">
		<tr class="Menu2sidebar"><td colspan="4" class="pl">����ǥ</td></tr>
		<tr>
			<td></td>
			<td> ������ </td>
			<td> ������ </td>
			<td> ������ </td>
		</tr>
		<tr>
			<td>7��</td>
			<td> 1000�� </td>
			<td> 2000�� </td>
			<td> 3000�� </td>
		</tr>
		<tr>
			<td>30��</td>
			<td> 10000�� </td>
			<td> 20000�� </td>
			<td> 30000�� </td>
		</tr>
</table>

<table id ="tableMenu" border="1">
	<tr>
	<td >
			<table id ="tableMenu1"  border="1">
				<tr class="td9">
					<td colspan="3" height="10px"><a href="Noticeboard_root_teacherC">��������</a></td>
				</tr>
				<tr>
					<td>
						����
					</td>
					<td>
						�ۼ���
					</td>
					<td>
						�ۼ���¥
					</td>
				</tr>
				<c:forEach var="n" items="${n }">
				<tr>
					<td>
						<a href="NoticeDetail_root_teacherC?no=${n.n_no}&id=${n.n_id }">${n.n_title }</a>
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
					<td colspan="3" height="10px"><a href="TeacherpostscriptC">������ �ı�</a></td>
				</tr>
				<tr>
						<td >
							����
						</td>
						<td>
							�ۼ���
						</td>
						<td>
							�ۼ���¥
						</td>
					</tr>
					<c:forEach var="p" items="${p }">
					<tr>
						<td>
							<a href="PostscriptDetailC?no=${p.p_no}">${p.p_title }</a>
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
					<td colspan="2" height="10px"><a href="Scheduleboard_root_teacherC">������ �ð�ǥ</a></td>
				</tr>
				<tr>
					<td width="40%">1����</td>
					<td width="60%">${day[0] }</td>
					
				</tr>
				<tr>
					<td width="40%">2����</td>
					<td>${day[1] }</td>
				</tr>
				<tr>
					<td width="40%">3����</td>
					<td>${day[2] }</td>
				</tr>
				<tr>
					<td width="40%">4����</td>
					<td>${day[3] }</td>
				</tr>
				<tr>
					<td width="40%">5����</td>
					<td>${day[4] }</td>
				</tr>
				<tr>
					<td width="40%">6����</td>
					<td>${day[5] }</td>
				</tr>
				<tr>
					<td width="40%">7����</td>
					<td>${day[6] }</td>
				</tr>
			</table>
	</td>
	</tr>
</table>
</body>
</html>