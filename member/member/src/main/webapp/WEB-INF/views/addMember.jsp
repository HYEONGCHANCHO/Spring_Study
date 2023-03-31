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
 <h1>회원 가입 화면</h1>
 
 <form action="/addMember" method="POST">
 	<input type="text" name="memId" placeholder="아이디" /><br />
 	<input type="text" name="memName" placeholder="이름" /><br />
 	<input type="password" name="memPwd" placeholder="비밀번호" /><br />
 	<input type="text" name="email" placeholder="메일주소" /><br />
 	<input type="text" name="phone" placeholder="전화번호" /><br />
 	<input type="text" name="address" placeholder="주소" /><br />
 	<input type="text" name="gender" placeholder="성별[남/여]" /><br />
 	<button>회원가입</button>
 		
 </form>
</body>
</html>