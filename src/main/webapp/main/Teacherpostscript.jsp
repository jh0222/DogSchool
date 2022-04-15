<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="tableMenu">
		<tr>
			<td colspan="3" class="Menu2sidebar">선생님 후기 </td>
		</tr>
		<tr>
			<td class="td2" width="40%">
				제목
			</td>
			<td class="td2" width="40%">
				작성자
			</td>
			<td class="td2" width="20%">
				작성날짜
			</td>
		</tr>
		<c:forEach var="p" items="${list }">
		<tr>
			<td class="td3">
				<a href="PostscriptDetailC?no=${p.p_no}">${p.p_title }</a>
			</td>
			<td class="td3">
				${p.p_id }
			</td>
			<td class="td3">
				${p.p_date }
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<table id="tableMenu2">
		<tr>
		<td>
			<c:choose>
		
		        <c:when test = "${pg > block}">
		            [<a href="TeacherpostscriptC?pg=1">◀◀</a>]
		            [<a href="TeacherpostscriptC?pg=${fromPage -1}">◀</a>] 
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
		        		[<a href="TeacherpostscriptC?pg=${i }">${i }</a>]
		        	</c:otherwise>
		        	</c:choose>
		        	
		        </c:forEach>
		       
		        <c:choose>
		        	<c:when test = "${toPage < allPage }">
		        		[<a href="TeacherpostscriptC?pg=${toPage + 1}">▶</a>]
		                [<a href="TeacherpostscriptC?pg=${allPage}">▶▶</a>]
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