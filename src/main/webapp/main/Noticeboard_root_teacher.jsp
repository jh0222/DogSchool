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
			<td colspan="4" class="Menu2sidebar">공지사항</td>
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
				<a href="NoticeboardinsertC">글쓰기</a>
			</td>
		</tr>
		<c:forEach var="n" items="${list }">
		<tr>
			<td class="td3">
				<a href="NoticeDetail_root_teacherC?no=${n.n_no}&id=${n.n_id }">${n.n_title }</a>
			</td>
			<td class="td3" >
				${n.n_id }
			</td>
			<td class="td3" colspan="2">
				${n.n_date }
			</td>
		</tr>
		</c:forEach>		
	</table>
	<table id="tableMenu2">
	<tr>
	<td>
	<c:choose>

        <c:when test = "${pg > block}">
            [<a href="Noticeboard_root_teacherC?pg=1">◀◀</a>]
            [<a href="Noticeboard_root_teacherC?pg=${fromPage -1}">◀</a>] 
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
        		[<a href="Noticeboard_root_teacherC?pg=${i }">${i }</a>]
        	</c:otherwise>
        	</c:choose>
        	
        </c:forEach>
       
        <c:choose>
        	<c:when test = "${toPage < allPage }">
        		[<a href="Noticeboard_root_teacherC?pg=${toPage + 1}">▶</a>]
                [<a href="Noticeboard_root_teacherC?pg=${allPage}">▶▶</a>]
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