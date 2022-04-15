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
			<td colspan="4" class="Menu2sidebar">선생님 후기</td>
		</tr>
		<tr>
			<td class="td2" width="35%">
				제목
			</td>
			<td class="td2" width="35%">
				작성자
			</td>
			<td class="td2" width="20%">
				작성날짜
			</td>
			<td class="td2" width="10%">
				<a href="TeacherpostscriptinsertC">글쓰기</a>
			</td>
		</tr>
		<c:forEach var="p" items="${list }">
		<tr>
			<td class="td3">
				<a href="PostscriptDetail_root_userC?no=${p.p_no}&id=${p.p_id}">${p.p_title }</a>
			</td>
			<td class="td3">
				${p.p_id }
			</td>
			<td class="td3" colspan="2">
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
            [<a href="Teacherpostscript_root_userC?pg=1">◀◀</a>]
            [<a href="Teacherpostscript_root_userC?pg=${fromPage -1}">◀</a>] 
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
        		[<a href="Teacherpostscript_root_userC?pg=${i }">${i }</a>]
        	</c:otherwise>
        	</c:choose>
        	
        </c:forEach>
       
        <c:choose>
        	<c:when test = "${toPage < allPage }">
        		[<a href="Teacherpostscript_root_userC?pg=${toPage + 1}">▶</a>]
                [<a href="Teacherpostscript_root_userC?pg=${allPage}">▶▶</a>]
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