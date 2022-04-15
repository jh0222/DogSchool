<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/notice_notebook.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<link rel="stylesheet" href="css/mypet.css">
<title>Insert title here</title>
</head>
<body>

<form action="nnoteUpdateC" name ="myForm" onsubmit="return call2()"method="post">
	<table id="tableMenu" >
		<tr>
			<td class="tdtitle" colspan="3"> 알림장 수정페이지</td>
		</tr>
		<tr hidden="hiden">
			<td class="td2"> 번 호</td>
			<td class="td3" colspan="2"><input name="mp_no" value="${nnotebook.mp_no }">  </td>
		</tr>
		<tr>
			<td class="td2"> 제 목</td>
			<td class="td3" colspan="2"><input name="mp_title" value="${nnotebook.mp_title }">  </td>
		</tr>
		<tr>
			<td class="td2"> 건 강</td>
			<td class="td3" colspan="2"><input name="mp_condition" value="${nnotebook.mp_condition }">   </td>
		</tr>
		<tr>
			<td class="td2"> 식사 횟수</td>
			<td class="td3" colspan="2"><input name="mp_meal" value="${nnotebook.mp_meal }">    </td>
		</tr>
		<tr>
			<td class="td2"> 배변 횟수</td>
			<td class="td3" colspan="2"><input name="mp_defecate" value="${nnotebook.mp_defecate }">    </td>
		</tr>
		<tr>
			<td class="td2"> 준비물</td>
			<td class="td3" colspan="2"><input name="mp_supplies" value="${nnotebook.mp_supplies }">    </td>
		</tr>
		<tr>
			<td class="td2"> 특이사항</td>
			<td class="td3" colspan="2"><textarea name="mp_txt">${nnotebook.mp_txt }</textarea>    </td>
		</tr>
		<tr>
			<td width="20%"></td>
			<td width="40%"> <button type="button" onclick="location.href='nnoteDetailC?mp_no=${nnotebook.mp_no}'"> 뒤로가기 </button> </td>
			<td width="40%"><button> 수정하기 </button> </td>
		</tr>
	</table>
</form>
</body>
</html>