<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	a{
		text-decoration: none;
		display: inline-block;
		width: 150px;
		height: 80px;
		background: #ccc;
		color: :white;
		border: solid blue 2px;
	}
</style>
</head>
<body>
<h1> ${memId} 회원이 존재하지 않습니다. </h1>
<a href="/">확인</a>
</body>
</html>