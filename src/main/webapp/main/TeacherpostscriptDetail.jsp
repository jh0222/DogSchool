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

<form action="">
	<table id="tableMenu">
		<tr>
			<td colspan="2" class="Menu2sidebar"> ������ �ı� </td>		
		</tr>
		<tr>
			<td class="td5">����</td>
			<td class="td5">
				${p.p_title }
			</td>
		</tr>
		<tr>
			<td class="td5">�ۼ���</td>
			<td class="td5">
				${p.p_id }
			</td>
			
		</tr>
		<tr>
			<td class="td5">����</td>
			<td class="td5">
				${p.p_txt }
			</td>
		</tr>
		<tr>
			<td class="td5">�ۼ���¥</td>
			<td class="td5">
				${p.p_date }
			</td>
		</tr>
	</table>
</form>
</body>
</html>