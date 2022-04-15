<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mypet.css">
<script type="text/javascript" src="js/notice_notebook.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${r }
${c }
	<table id="tableMenu" >
		<tr>
			<td class="tdtitle" colspan="2"> 알림장 </td>
		</tr>
		<tr>
			<td class="td2"> 제 목</td>
			<td class="td3"> ${nnotebook.mp_title } </td>
		</tr>
		<tr>
			<td class="td2"> 건 강</td>
			<td class="td3"> ${nnotebook.mp_condition }   </td>
		</tr>
		<tr>
			<td class="td2"> 식사 횟수</td>
			<td class="td3"> ${nnotebook.mp_meal }회    </td>
		</tr>
		<tr>
			<td class="td2"> 배변 횟수</td>
			<td class="td3"> ${nnotebook.mp_defecate }회    </td>
		</tr>
		<tr>
			<td class="td2"> 준비물</td>
			<td class="td3"> ${nnotebook.mp_supplies }    </td>
		</tr>
		<tr>
			<td class="td2"> 특이사항</td>
			<td class="td3"> ${nnotebook.mp_txt }    </td>
		</tr>
	</table>


<table id="tableMenu">
		<tr>
			<td> <button onclick="location.href='Menu1_u'"> 뒤로가기 </button> </td>
		</tr>
</table>

<hr>
<form action="commentC_U" name ="myForm" onsubmit="return call()"method="post">
	<table id="tableMenu" >
		<tr hidden="hiden">
			<td><input name="mp_no" value="${nnotebook.mp_no }"></td>
		</tr>
		<tr> 
			<td> <textarea name="c_txt" placeholder="댓글을 입력하세요"></textarea></td>
			<td> <button name="a_tname" value="${sessionScope.applyBean.a_tname}">댓글</button></td>
		</tr>

	</table>
</form>

<table id ="tableMenu" >
		<tr>
			<td class="siteMenu" align="center" hidden="hint">번호</td>
			<td class="td1" align="center" >댓글</td>
			<td class="siteMenu" align="center">작성자</td>
			<td class="siteMenu" align="center">작성일</td>
			<td class="siteMenu" align="center">수정</td>
			<td class="siteMenu" align="center">삭제</td>
		</tr>
		<c:forEach var="n" items="${comment }">
		<tr>
			<td class="r_td1" hidden="hint" > ${n.c_no } </td>
			<td class="r_td1"> ${n.c_txt } </td>
			<td class="r_td1"> ${n.c_writer } </td>
			<td class="r_td2" ><fmt:formatDate value="${n.c_date }" type="both" dateStyle="short"></fmt:formatDate></td>
			<c:choose>
					<c:when test="${n.c_writer eq sessionScope.uaccountInfo.u_id}">
						<td><button type="button" onclick="updatecm_u('${nnotebook.mp_no}','${n.c_no}','${n.c_txt}');">수정</button></td>
						<td><button type="button" onclick="deletecm_u(${nnotebook.mp_no},${n.c_no});">삭제</button></td>
					</c:when>
			</c:choose>	
		</tr>
		</c:forEach>

</table>
<table id ="tableMenu">
<tr>
<td>

		<c:choose>

        <c:when test = "${pg > block}">
            [<a class="b" href="nnoteDetailC_U?pg=1">◀◀</a>]
            [<a class="b" href="nnoteDetailC_U?pg=${fromPage -1}">◀</a>] 
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
        		[<a class="b" href="nnoteDetailC_U?pg=${i }&mp_no=${nnotebook.mp_no}">${i }</a>]
        	</c:otherwise>
        	</c:choose>
        	
        </c:forEach>
       
        <c:choose>
        	<c:when test = "${toPage < allPage }">
        		[<a class="b" href="nnoteDetailC_U?pg=${toPage + 1}">▶</a>]
                [<a class="b" href="nnoteDetailC_U?pg=${allPage}">▶▶</a>]
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