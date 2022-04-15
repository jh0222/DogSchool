<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="Schedule_updateC" method="post">
	<table id="tableMenu3" border="1">
		<tr>
		 	<td colspan="8" class="Menu2sidebar">일주일 시간표</td>
		</tr>
		<tr>
			<td></td>
			<td class="td5">월</td>
			<td class="td5">화</td>
			<td class="td5">수</td>
			<td class="td5">목</td>
			<td class="td5">금</td>
			<td class="td5">토</td>
			<td class="td5">일</td>
		</tr>
		<tr>
			<td class="td5">1교시</td>
			<td class="td5"><input name="mon1" value="${mon[0] }"></td>
			<td class="td5"><input name="tue1" value="${tue[0] }"></td>
			<td class="td5"><input name="wed1" value="${wed[0] }"></td>
			<td class="td5"><input name="thur1" value="${thur[0] }"></td>
			<td class="td5"><input name="fri1" value="${fri[0] }"></td>
			<td class="td5"><input name="sat1" value="${sat[0] }"></td>
			<td class="td5"><input name="sun1" value="${sun[0] }"></td>
		</tr>
		<tr>
			<td class="td5">2교시</td>
			<td class="td5"><input name="mon2" value="${mon[1] }"></td>
			<td class="td5"><input name="tue2" value="${tue[1] }"></td>
			<td class="td5"><input name="wed2" value="${wed[1] }"></td>
			<td class="td5"><input name="thur2" value="${thur[1] }"></td>
			<td class="td5"><input name="fri2" value="${fri[1] }"></td>
			<td class="td5"><input name="sat2" value="${sat[1] }"></td>
			<td class="td5"><input name="sun2" value="${sun[1] }"></td>
		</tr>
		<tr>
			<td class="td5">3교시</td>
			<td class="td5"><input name="mon3" value="${mon[2] }"></td>
			<td class="td5"><input name="tue3" value="${tue[2] }"></td>
			<td class="td5"><input name="wed3" value="${wed[2] }"></td>
			<td class="td5"><input name="thur3" value="${thur[2] }"></td>
			<td class="td5"><input name="fri3" value="${fri[2] }"></td>
			<td class="td5"><input name="sat3" value="${sat[2] }"></td>
			<td class="td5"><input name="sun3" value="${sun[2] }"></td>
		</tr>
		<tr>
			<td class="td5">4교시</td>
			<td class="td5"><input name="mon4" value="${mon[3] }"></td>
			<td class="td5"><input name="tue4" value="${tue[3] }"></td>
			<td class="td5"><input name="wed4" value="${wed[3] }"></td>
			<td class="td5"><input name="thur4" value="${thur[3] }"></td>
			<td class="td5"><input name="fri4" value="${fri[3] }"></td>
			<td class="td5"><input name="sat4" value="${sat[3] }"></td>
			<td class="td5"><input name="sun4" value="${sun[3] }"></td>
		</tr>
		<tr>
			<td class="td5">5교시</td>
			<td class="td5"><input name="mon5" value="${mon[4] }"></td>
			<td class="td5"><input name="tue5" value="${tue[4] }"></td>
			<td class="td5"><input name="wed5" value="${wed[4] }"></td>
			<td class="td5"><input name="thur5" value="${thur[4] }"></td>
			<td class="td5"><input name="fri5" value="${fri[4] }"></td>
			<td class="td5"><input name="sat5" value="${sat[4] }"></td>
			<td class="td5"><input name="sun5" value="${sun[4] }"></td>
		</tr>
		<tr>
			<td class="td5">6교시</td>
			<td class="td5"><input name="mon6" value="${mon[5] }"></td>
			<td class="td5"><input name="tue6" value="${tue[5] }"></td>
			<td class="td5"><input name="wed6" value="${wed[5] }"></td>
			<td class="td5"><input name="thur6" value="${thur[5] }"></td>
			<td class="td5"><input name="fri6" value="${fri[5] }"></td>
			<td class="td5"><input name="sat6" value="${sat[5] }"></td>
			<td><input name="sun6" value="${sun[5] }"></td>
		</tr>
		<tr>
			<td class="td5">7교시</td>
			<td class="td5"><input name="mon7" value="${mon[6] }"></td>
			<td class="td5"><input name="tue7" value="${tue[6] }"></td>
			<td class="td5"><input name="wed7" value="${wed[6] }"></td>
			<td class="td5"><input name="thur7" value="${thur[6] }"></td>
			<td class="td5"><input name="fri7" value="${fri[6] }"></td>
			<td class="td5"><input name="sat7" value="${sat[6] }"></td>
			<td class="td5"><input name="sun7" value="${sun[6] }"></td>
		</tr>			
		<tr>
			<td  class="td5" colspan="8"><button id="button3">추가완료</button></td>
		</tr>
	</table>
</form>
</body>
</html>