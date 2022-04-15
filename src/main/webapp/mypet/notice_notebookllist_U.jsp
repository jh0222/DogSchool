<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/mypet.css">
<title>Insert title here</title>
</head>
<body>
<table id ="tableMenu" >
		<tr>
			<td colspan="4" class="td1" align="center">알림장 리스트</td>
		</tr>
		<c:forEach var="n" items="${nnotebook }">
		<tr>
		<td class="td3" onclick="location.href='nnoteDetailC_U?mp_no=${n.mp_no}'">${n.mp_title }</td>
		<td><fmt:formatDate value="${n.mp_date }" type="both" dateStyle="short"></fmt:formatDate></td>
		<td>${n.mp_tid }</td>
		</tr>
		</c:forEach>

</table>
<table id ="tableMenu">
<tr>
<td>

		<c:choose>

        <c:when test = "${pg > block}">
            [<a class="b" href="nnotebooklist_U?pg=1">◀◀</a>]
            [<a class="b" href="nnotebooklist_U?pg=${fromPage -1}">◀</a>] 
        </c:when>

        <c:otherwise>
            [<span style="color:gray">◀◀</span>]   
            [<span style="color:gray">◀</span>]
        </c:otherwise>
     	</c:choose>

        <c:forEach var="i" begin="${fromPage }" end="${toPage }">
        	<c:choose>
        	<c:when test = "${i == pg }">
        		[${i }]
        	</c:when>
        	
        	<c:otherwise>
        		[<a class="b" href="nnotebooklist_U?pg=${i }">${i }</a>]
        	</c:otherwise>
        	</c:choose>
        	
        </c:forEach>
       
        <c:choose>
        	<c:when test = "${toPage < allPage }">
        		[<a class="b" href="nnotebooklist_U?pg=${toPage + 1}">▶</a>]
                [<a class="b" href="nnotebooklist_U?pg=${allPage}">▶▶</a>]
        	</c:when>
        	<c:otherwise>
        		[<span style="color:gray">▶</span>]
                [<span style="color:gray">▶▶</span>]
        	</c:otherwise>       
        </c:choose>
 </td>
 </tr>
</table>
</body>
</html>