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

<form action="Noticeboard_uploadC" name="myForm" onsubmit="return board()">
	<table id="tableMenu">
		<tr>
			<td colspan="2" class="Menu2sidebar">�������� �߰�</td>
		</tr>
		<tr>
			<td class="td5">����</td>
			<td class="td5">
				<input name="title" class="inputtype1">
			</td>
		</tr>
		<tr>
			<td class="td5">����</td>
			<td class="td5">
				<textarea name="txt" cols="130" rows="5" ></textarea>
			</td>
		</tr>
		<tr>
			<td class="td5" colspan="2" ><button id="button3">�ۼ��ϱ�</button></td>
		</tr>
	</table>
</form>
</body>
</html>