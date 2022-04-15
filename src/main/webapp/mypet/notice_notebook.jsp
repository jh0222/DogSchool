<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/notice_notebook.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<link rel="stylesheet" href="css/mypet.css">

</head>
<body>

<form action="nnoteinsertC" name ="myForm" onsubmit="return call2()"method="post" >
	<table id="tableMenu" >
		<tr hidden="hint">
			<td><input name="mp_tid" value="${sessionScope.applyBean.a_tname}"></td>
			<td><input name="mp_uid" value="${sessionScope.applyBean.a_id}"></td>
			<td><input name="mp_uname" value="${sessionScope.applyBean.a_name}"></td>
		</tr>
		<tr>
			<td class="tdtitle" colspan="3"> 알림장 작성</td>
		</tr>
		<tr>
			<td class="td2"> 제 목</td>
			<td class="td3" colspan="2"><input name="mp_title">  </td>
		</tr>
		<tr>
			<td class="td2"> 건 강</td>
			<td class="td3" colspan="2"><input name="mp_condition">   </td>
		</tr>
		<tr>
			<td class="td2"> 식사 횟수</td>
			<td class="td3" colspan="2"><input name="mp_meal">    </td>
		</tr>
		<tr>
			<td class="td2"> 배변 횟수</td>
			<td class="td3" colspan="2"><input name="mp_defecate">    </td>
		</tr>
		<tr>
			<td class="td2"> 준비물</td>
			<td class="td3" colspan="2"><input name="mp_supplies">    </td>
		</tr>
		<tr>
			<td class="td2"> 특이사항</td>
			<td class="td3" colspan="2"><textarea name="mp_txt"></textarea>    </td>
		</tr>
		<tr>
			<td width="20%"></td>
			<td width="40%"><button type="button"  onclick="location.href='Menu1'"> 뒤로가기 </button></td>
			<td width="40%"><button>작성하기</button></td>
		</tr>
	</table>
</form>
</body>
</html>