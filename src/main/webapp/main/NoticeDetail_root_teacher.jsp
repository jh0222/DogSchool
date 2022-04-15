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
		<tr>
			<td colspan="2">
				<button id="button3" onclick="location.href='Noticeboard_updateC?no=${n.n_no}'">수정</button>
				<button id="button3" onclick="nboarddelete(${n.n_no});">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>