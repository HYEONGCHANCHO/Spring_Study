<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 삭제 화면</h1>
	 <form action="/delMember" method="POST">
 	<input type="text" name="memId" placeholder="아이디" /><br />
 	<button>회원삭제</button>
	
</body>
</html>