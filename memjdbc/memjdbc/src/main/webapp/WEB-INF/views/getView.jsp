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
 <h1>회원 정보</h1>
 		<form action="member/updateMember" method="POST">
 			<input type="text" name="memId" value="${member.memId}" readonly="readonly"><br />
 			<input type="text" name="memName" value="${member.memName}"><br />
 			<input type="password" name="memPwd" "/><br />
 			<input type="text" name="email" value="${member.email}"><br />
 			<input type="text" name="phone" value="${member.phone}"><br />
 			<input type="text" name="address" value="${member.address}"><br />
 			<input type="text" name="gender" value="${member.gender}"><br />
 			<input type="text" name="stateCode" value="${member.stateCode}"><br />
 			<input type="text" name="regiDate" value="${member.regiDate}" readonly="readonly"><br />
 			<button>수정하기</button>
 		</form>
 		
</body>
</html>