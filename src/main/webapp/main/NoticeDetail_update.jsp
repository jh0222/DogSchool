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

<form action="Noticeboard_updateC?no=${n.n_no }" method="post" name="myForm" onsubmit="return board()">
	<table id="tableMenu" border="1">
		<tr>
			<td colspan="2" class="Menu2sidebar">공지사항 수정</td>
		</tr>
		<tr>
			<td class="td5">제목</td>
			<td class="td5"><input name="title" class="inputtype1" value="${n.n_title }"></td>
		</tr>
		<tr>
			<td class="td5">내용</td>
			<td class="td5"><textarea name="txt" cols="130" rows="5">${n.n_txt }</textarea></td>
		</tr>
		<tr>
			<td class="td5" colspan="2"><button id="button3">수정완료</button></td>
		</tr>
	</table>
</form>
</body>
</html>