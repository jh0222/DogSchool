<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/deletelist.js"></script>
</head>
<body>

	<table id ="tableMenu" border="1">
			<tr class="Menu2sidebar">
				<td colspan="10">원장님 페이지</td>
			</tr>
			<tr>
				<td class="td2">선생님 이름</td>
				<td class="td2">회원 아이디</td>
				<td class="td2">강아지 이름</td>
				<td class="td2">성별</td> 
				<td class="td2">시작 기간</td>
				<td class="td2">종료 기간</td>
				<td class="td2">나이</td>
				<td class="td2">사진</td>
				<td class="td2">수락</td>	
				<td class="td2">거절</td>		
			</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.a_tname }</td>
				<td>${list.a_id }</td>
				<td>${list.a_name }</td>
				<td>${list.a_gender }</td>
				<td>${list.a_start }</td>
				<td>${list.a_end }</td>
				<td>${list.a_age }</td>
				<td><img width="150px" height="100px" src="file/${list.a_img }"></td>
				<td><button type="button" onclick="agree('${list.a_id}','${list.a_name}','${list.a_no}');">수락하기</button></td>
				<td><button type="button" onclick="deletelist('${list.a_id}','${list.a_name}','${list.a_no}');">삭제하기</button></td>
			</tr>
		</c:forEach>
	</table>
	<table id="tableMenu2">
	<tr>
	<td>
	<c:choose>

        <c:when test = "${pg > block}">
            [<a href="leaderC?pg=1">◀◀</a>]
            [<a href="leaderC?pg=${fromPage -1}">◀</a>] 
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
        		[<a href="leaderC?pg=${i }">${i }</a>]
        	</c:otherwise>
        	</c:choose>
        	
        </c:forEach>
       
        <c:choose>
        	<c:when test = "${toPage < allPage }">
        		[<a href="leaderC?pg=${toPage + 1}">▶</a>]
                [<a href="leaderC?pg=${allPage}">▶▶</a>]
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
