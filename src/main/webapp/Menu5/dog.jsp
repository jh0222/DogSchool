<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/teacher.css" type="text/css" >
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/teacher.js"></script>
</head>
<body>
<table id ="tableMenu" border="1">
		<tr class="Menu2sidebar">
			<td colspan="9">${sessionScope.taccountInfo.t_name } 선생님 페이지</td>
		</tr>
		<tr>
			<td class="td2">사용자 아이디</td> 
			<td class="td2">강아지 이름</td> 
			<td class="td2">성별</td>
			<td class="td2">시작 기간</td>
			<td class="td2">종료 기간</td>
			<td class="td2">나이</td>
			<td class="td2">사진</td>
			<td class="td2">수정</td>
			<td class="td2">삭제</td>
		</tr>
		
		<c:forEach var="a" items="${applyBeans }">
			<tr>
				<td>${a.a_id}</td>
				<td><a href="Menu1_t?id=${a.a_id }&name=${a.a_name}">${a.a_name}</a></td>
				<td>${a.a_gender}</td>
				<td>${a.a_start}</td>
				<td>${a.a_end}</td>
				<td>${a.a_age}</td>
				<td><img src="file/${a.a_img }" width="150" height="100" ></td>
				<td><button onclick="location.href='TeacherUpC?a_no=${a.a_no}'">수정하기</button></td>
				<td><button type="button" onclick="deletett('${a.a_id}','${a.a_name }','${a.a_tname}');">삭제하기</button></td>
			</tr>
		</c:forEach>
	</table>
	<table id="tableMenu2">
	<tr>
	<td>
	<c:choose>

        <c:when test = "${pg > block}">
            [<a href="TeacherC?pg=1">◀◀</a>]
            [<a href="TeacherC?pg=${fromPage -1}">◀</a>] 
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
        		[<a href="TeacherC?pg=${i }">${i }</a>]
        	</c:otherwise>
        	</c:choose>
        	
        </c:forEach>
       
        <c:choose>
        	<c:when test = "${toPage < allPage }">
        		[<a href="TeacherC?pg=${toPage + 1}">▶</a>]
                [<a href="TeacherC?pg=${allPage}">▶▶</a>]
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