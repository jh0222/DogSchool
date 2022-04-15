<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>인사말</h2>
<hr>
강아지 유치원 홈페이지 방문을 환영합니다.<br>
강아지 유치원은 반려견을 위한 유치원으로서 반려견 공간입니다. <br>
강아지 유치원의 Motto 아래와 같습니다. <br>
1) Safe and Social with People (사람과함께 안전하고 사회성있는) <br>
2) Comfortable and Clean with People (사람과함께 안락하고 깨끗하게) <br>
3) Have Fun and Happy with People (사람과함께 재미있고 행복하게) <br>
강아지의 사회화 시기는 일반적으로 생후 3주~12주까지 입니다.<br> 
이시기에 사회화가 되어질수 있도록 최선을 다하겠습니다. <br>
또한 사회화가 안되어 문제가 되고 있는 반려견에 대에서도 행동교정전문가가 직접 행동교정 교육을 통해 <br>
반려인과 반려견이 행복한 삶을 영위할 수 있도록 최선의 행동교정 및 교육을 해드립니다.


<h2>찾아 오시는 길</h2>
<hr>
<div id="map" style="width:50%;;height:250px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=23ca6d2d06f57b35b933fc23f4f1251d&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 종로구 종로12길 15', function(result, status) {

// 정상적으로 검색이 완료됐으면 
 if (status === kakao.maps.services.Status.OK) {

    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    // 결과값으로 받은 위치를 마커로 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: coords
    });

    // 인포윈도우로 장소에 대한 설명을 표시합니다
    var infowindow = new kakao.maps.InfoWindow({
        content: '<div style="width:150px;text-align:center;padding:6px 0;">강아지 유치원</div>'
    });
    infowindow.open(map, marker);

    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    map.setCenter(coords);
} 
});    
</script>

<h3>주소</h3>
서울특별시 종로구 종로12길 15 5층 (관철동 13-13)
<h3>대표전화</h3>
010-0000-0000
<h3>오시는길</h3>
종각역 4번 출구에서 240m
</body>
</html>