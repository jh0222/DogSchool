<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mypet.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table id ="tableMenu"  >
			<tr>
				<td class="td1" align="center" >갤러리</td>
			</tr>
	
	</table>
<table id ="tableMenu">
<tr>
<td>
	<div id="img_wrap">
		<div id="img_list">
			<c:forEach var="g" items="${gallery }">
					<div >${g.g_title }<br><a href="galleryDetailC_U?g_no=${g.g_no }"><img src ="file/${g.g_img }"></a><br>${g.g_date }<br>${g.g_tid }</div>
			</c:forEach>
		</div>
	</div>
</td>
</tr>
</table>

<table id ="tableMenu">
<tr>
<td>

		<c:choose>

        <c:when test = "${pg > block}">
            [<a class="b" href="galleryPage_U?pg=1">◀◀</a>]
            [<a class="b" href="galleryPage_U?pg=${fromPage -1}">◀</a>] 
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
        		[<a class="b" href="galleryPage_U?pg=${i }">${i }</a>]
        	</c:otherwise>
        	</c:choose>
        	
        </c:forEach>
       
        <c:choose>
        	<c:when test = "${toPage < allPage }">
        		[<a class="b" href="galleryPage_U?pg=${toPage + 1}">▶</a>]
                [<a class="b" href="galleryPage_U?pg=${allPage}">▶▶</a>]
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