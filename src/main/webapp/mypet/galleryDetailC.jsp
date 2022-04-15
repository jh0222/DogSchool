<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mypet.css">
<script type="text/javascript" src="js/notice_notebook.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${r }
${c }


<table id="tableMenu" >
		<tr>
			<td class="tdtitle" colspan="3"> 상세 페이지 </td>
		</tr>
		<tr hidden="hint">
			<td>번호 </td>
			<td class="td3" colspan="2">${gallery.g_no }  </td>
		</tr>
		<tr>
			<td>제목 </td>
			<td class="td3" colspan="2">${gallery.g_title }  </td>
		</tr>
		<tr>
			<td>이미지 </td>
			<td class="td3" colspan="2"><img src ="file/${gallery.g_img }">  </td>
		</tr>
		<tr>
			<td>작성자 </td>
			<td class="td3" colspan="2">${gallery.g_tid }  </td>
		</tr>
		<tr>
			<td>작성일 </td>
			<td class="td3" colspan="2">${gallery.g_date }  </td>
		</tr>
</table>
<table id="tableMenu">
		<tr>
			<td> <button onclick="location.href='Menu1_t'"> 뒤로가기 </button> </td>
			<td> <button onclick="location.href='galleryUpdatePage?g_no=${gallery.g_no}'"> 수정하기 </button> </td>
			<td> <button onclick="deletegy(${gallery.g_no});">삭제하기</button> </td>
		</tr>
</table>
</body>
</html>