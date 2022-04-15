<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/apply.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
<style>
	/*datepicker에서 사용한 이미지 버튼 style적용*/
	img.ui-datepicker-trigger {
    margin-left:5px; vertical-align:middle; cursor:pointer;
	}
</style>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<script>    
    $(function() {
    //datepicker 한국어로 사용하기 위한 언어설정
    $.datepicker.setDefaults($.datepicker.regional['ko']); 
                
    //시작일
    $('#fromDate').datepicker({
             
    dateFormat: "yy-mm-dd",             // 날짜의 형식
    changeMonth: true,                  // 월을 이동하기 위한 선택상자 표시여부
    minDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이전 날짜 선택 불가)
    onClose: function( selectedDate ) {    
    // 시작일(fromDate) datepicker가 닫힐때
    // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
    $("#toDate").datepicker( "option", "minDate", selectedDate );
	    }                
  	});

    //종료일
    $('#toDate').datepicker({
                    
    dateFormat: "yy-mm-dd",
    changeMonth: true,
    minDate: 0, // 오늘 이전 날짜 선택 불가
    onClose: function( selectedDate ) {
    // 종료일(toDate) datepicker가 닫힐때
    // 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
    $("#fromDate").datepicker( "option", "maxDate", selectedDate );
    	}                
    });
});
</script>
</head>
<body>
	
<form action="TeacherUpC" method="post" enctype="multipart/form-data" onsubmit="return check()">
		<table id ="Menu2table">
			<tr>
				<td colspan="3" class="Menu2sidebar">신청서 수정페이지</td>
			</tr>
			<tr>
				<td class="td4">사용자 아이디</td>
				<td class="td4"><input name="id" value="${applybean.a_id}" readonly="true"></td>
			</tr>
			<tr>
				<td class="td4">강아지 이름</td>
				<td class="td4"><input name="name" value="${applybean.a_name}" ></td>
			</tr>
			<tr>
				<td class="td4">나이</td>
				<td class="td4"><input name="age" value="${applybean.a_age}"></td>
			</tr>
			<tr>
				<td class="td4">성별</td>
				<td class="td4"><input name="gender" value="${applybean.a_gender}" readonly="true"></td>
			</tr>
			<tr>
				<td class="td4">시작 기간</td>
				<td class="td4">
				<input type="text" name="start" value="${applybean.a_start}" id="fromDate" class="inputtype1"></td>
			</tr>
			<tr>
				<td class="td4">종료 기간</td>
				<td class="td4"><input type="text" name="end" value="${applybean.a_end}" id="toDate" class="inputtype1"></td>
			</tr>
			<tr>
				<td class="td4">사진</td>
				<td class="td4"><input name="img" value="${applybean.a_img}"  type="hidden" width="150" height="100" >
				<img src="file/${applybean.a_img}"  width="300" height="150"><br>
				<input type="file" name="img2"></td>
			</tr>
			<tr>
				<td class="td4" colspan="2"><button id="button3 "name="no" value="${applybean.a_no}" onclick="call()">수정하기</button></td>
			</tr>
		</table>
	</form>
</body>
</html>