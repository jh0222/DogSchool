<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${result }
<div class = "Login">
	${sessionScope.taccountInfo.t_name }, �ȳ��ϼ���.(������)
	<button onClick='location.href="T_mypage"'>����������</button>
	<button onClick='location.href="logoutC"'>�α׾ƿ�</button>

</div>
</body>
</html>