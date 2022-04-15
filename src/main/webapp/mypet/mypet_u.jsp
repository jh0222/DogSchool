<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="css/mypet.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${r }
------

<table id ="tableMenu" >
		<tr>
			<td class="td1" align="center" colspan="3" ><a href="nnotebooklist_U"> ${sessionScope.applyBean.a_name}의알림장</a></td>
		</tr>
		<c:forEach var="n" items="${nnotebook }">
		<tr>
		<td width="50%" class="r_td1" onclick="location.href='nnoteDetailC_U?mp_no=${n.mp_no}'">${n.mp_title }</td>
		<td width="30%" class="r_td2" ><fmt:formatDate value="${n.mp_date }" type="both" dateStyle="short"></fmt:formatDate></td>
		<td width="20%" class="r_td2">${n.mp_tid }</td>
		</tr>
		</c:forEach>

</table>
<br><br>

	<table id ="tableMenu"  >
			<tr>
				<td class="td1" align="center" ><a href="galleryPage_U">갤러리</a></td>
			</tr>
	
	</table>
	<table id="tableMenu">
		<tr>
			<c:forEach var="g" items="${gallery }">
					<td align="center"> ${g.g_title }</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="g" items="${gallery }">
					<td align="center"> <br><a href="galleryDetailC_U?g_no=${g.g_no }"><img src = "file/${g.g_img }"></a></td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="g" items="${gallery }">
					<td align="center">${g.g_date }</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="g" items="${gallery }">
					<td align="center"> ${g.g_tid }</td>
			</c:forEach>
		</tr>
	</table>
	


</body>
</html>