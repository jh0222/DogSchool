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
${r }
${c }
<form action="galleryUpdateC" method="post" enctype="multipart/form-data">
	<table id="tableMenu" >
			<tr>
				<td class="tdtitle" colspan="3"> 갤러리 수정페이지 </td>
			</tr>
			<tr hidden="hiden">
			<td>번호 </td> 
				<td class="td3" colspan="2"><input name="g_no" value="${gallery.g_no }">  </td>
			</tr>
			<tr>
				<td>제목 </td>
				<td class="td3" colspan="2"><input name="g_title" value="${gallery.g_title }">  </td>
			</tr>
			<tr hidden="hiden">
				<td>사진 </td>
				<td class="td3" colspan="2"><input name="g_img" value="${gallery.g_img }"><img src ="file/${gallery.g_img }">  </td>
			</tr>
			<tr>
				<td>사진 </td>
				<td class="td3" colspan="2"><img src ="file/${gallery.g_img }"><br><input type="file" name="g_img1" value="${gallery.g_img }">  </td>
			</tr>
			<tr hidden="hiden">
				<td>작성자 </td>
			
				<td><input name="g_id" value="${gallery.g_tid }" ></td>
			</tr>
			<tr>
				<td></td>
				<td> <button type="button" onclick="location.href='Menu1'"> 뒤로가기 </button> </td>
				<td> <button> 수정하기 </button> </td>	
			</tr>
	
	</table>
</form>
</body>
</html>