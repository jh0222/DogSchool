<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/mypet.css">
<script type="text/javascript" src="js/notice_notebook.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<title>Insert title here</title>
</head>
<body>

<form action="galleryinsertC" name ="myForm" onsubmit="return galler_updatecall()" method="post" enctype="multipart/form-data">
	<table id="tableMenu" >
		<tr>
			<td class="tdtitle" colspan="3"> 이미지 작성</td>
		</tr>
		<tr hidden="hint">
			<td><input name="g_tid" value="${sessionScope.applyBean.a_tname}"></td>
			<td><input name="g_uid" value="${sessionScope.applyBean.a_id}"></td>
			<td><input name="g_uname" value="${sessionScope.applyBean.a_name}"></td>
		</tr>
		<tr>
			<td class="td2"> 제 목</td>
			<td class="td3" colspan="2"><input name="g_title">  </td>
		</tr>
		<tr>
			<td class="td2"> 이미지</td>
			<td class="td3" colspan="2"><input name="g_img" type="file">   </td>
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