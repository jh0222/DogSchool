<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<table id ="Menu2table">
	<tr>
		<td colspan="4" class="Menu2sidebar">선생님 소개</td>
	</tr>
	<tr>
		<td class="td2" width="20%">선생님 이름</td>
		<td class="td2" width="10%">성별 </td>
		<td class="td2" width="60%">자기소개</td>
		<td class="td2" width="10%"><a href="T_Menu2Update"> 수정하기 </a></td>
	</tr>
	<c:forEach var="ta" items="${ta }">
	<tr>
		<td class="td3">${ta.t_name }</td>
		<td class="td3">${ta.t_gender }</td>
		<td class="td3" colspan="2">${ta.t_text }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>