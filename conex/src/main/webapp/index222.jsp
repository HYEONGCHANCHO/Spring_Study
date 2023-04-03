<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<td id="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td id="password"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td id="name"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td id="address"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td id="age"></td>
		</tr>

	</table>
	<button>정보가져오기</button>
	<script>
	var objItem = ['id','password','name','address','age'];
		$('button').click(function() {
			$.ajax({
				url : "http://localhost/conex/databind",
				method : "GET"
			}).done(function(json) {
				for(let i = 0; i<objItem.length; i= i+1){
					$('#'+objItem[i]).text(json[objItem[i]]);
				}
				/*
				$('#id').text(json.id);
				$('#password').text(json.password);
				$('#name').text(json.name);
				$('#address').text(json.address);
				$('#age').text(json.age);*/
			});
		});
	</script>


</body>
</html>