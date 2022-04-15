<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<title>Insert title here</title>
</head>
<body>
<table id ="Menu2table">
	<tr>
		<td colspan="4" class="Menu2sidebar">선생님 소개</td>
	</tr>
	<tr>
		<td class="td2" >선생님 이름</td>
		<td class="td2" >성별 </td>
		<td class="td2"  colspan="2">자기소개</td>
	</tr>
	<c:forEach var="ta" items="${ta }">
	<tr>
		<td class="td3" width="20%">${ta.t_name }</td>
		<td class="td3" width="10%">${ta.t_gender }</td>
		<td class="td3" width="60%">${ta.t_text }</td>
		<td class="td3" width="10%"><button id="button1" type="button" onclick="root_deleteT('${ta.t_name}');">삭제</button></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>