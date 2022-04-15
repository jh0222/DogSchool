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
			<td colspan="3" class="Menu2sidebar">공지사항</td>
		</tr>
		<tr>
			<td class="td5">제목</td>
			<td class="td5">
				${n.n_title }
			</td>
		</tr>
		<tr>
			<td class="td5">작성자</td>
			<td class="td5">
				${n.n_id }
			</td>
			
		</tr>
		<tr>
			<td class="td5">내용</td>
			<td class="td5">
				${n.n_txt }
			</td>
		</tr>
		<tr>
			<td class="td5">작성날짜</td>
			<td class="td5">
				${n.n_date }
			</td>
		</tr>
	</table>
</form>
</body>
</html>