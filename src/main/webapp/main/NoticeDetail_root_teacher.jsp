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
	<table id="tableMenu">
		<tr>
			<td colspan="3" class="Menu2sidebar">��������</td>
		</tr>
		<tr>
			<td class="td5">����</td>
			<td class="td5">
				${n.n_title }
			</td>
		</tr>
		<tr>
			<td class="td5">�ۼ���</td>
			<td class="td5">
				${n.n_id }
			</td>
			
		</tr>
		<tr>
			<td class="td5">����</td>
			<td class="td5">
				${n.n_txt }
			</td>
		</tr>
		<tr>
			<td class="td5">�ۼ���¥</td>
			<td class="td5">
				${n.n_date }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="button3" onclick="location.href='Noticeboard_updateC?no=${n.n_no}'">����</button>
				<button id="button3" onclick="nboarddelete(${n.n_no});">����</button>
			</td>
		</tr>
	</table>
</body>
</html>