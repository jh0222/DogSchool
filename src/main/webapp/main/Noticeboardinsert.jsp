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
			<td colspan="2" class="Menu2sidebar">공지사항 추가</td>
		</tr>
		<tr>
			<td class="td5">제목</td>
			<td class="td5">
				<input name="title" class="inputtype1">
			</td>
		</tr>
		<tr>
			<td class="td5">내용</td>
			<td class="td5">
				<textarea name="txt" cols="130" rows="5" ></textarea>
			</td>
		</tr>
		<tr>
			<td class="td5" colspan="2" ><button id="button3">작성하기</button></td>
		</tr>
	</table>
</form>
</body>
</html>