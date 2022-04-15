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
<form action="Teacherpostscript_updateC?no=${p.p_no }" method="post" name="myForm" onsubmit="return board()">
	<table id="tableMenu" border="1">
		<tr>
			<td colspan="2" class="Menu2sidebar">선생님 후기 수정</td>
		</tr>
		<tr>
			<td class="td5">제목</td>
			<td class="td5"><input name="title" class="inputtype1" value="${p.p_title }"></td>
		</tr>
		<tr>
			<td class="td5">내용</td>
			<td class="td5"><textarea name="txt" cols="130" rows="5">${p.p_txt }</textarea></td>
		</tr>
		<tr>
			<td class="td5" colspan="2"><button id="button3">수정완료</button></td>
		</tr>
	</table>
</form>
</body>
</html>