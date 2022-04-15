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
			<td colspan="2" class="Menu2sidebar"> 선생님 후기 </td>		
		</tr>
		<tr>
			<td class="td5">제목</td>
			<td class="td5">
				${p.p_title }
			</td>
		</tr>
		<tr>
			<td class="td5">작성자</td>
			<td class="td5">
				${p.p_id }
			</td>
			
		</tr>
		<tr>
			<td class="td5">내용</td>
			<td class="td5">
				${p.p_txt }
			</td>
		</tr>
		<tr>
			<td class="td5">작성날짜</td>
			<td class="td5">
				${p.p_date }
			</td>
		</tr>
	</table>
</form>
</body>
</html>