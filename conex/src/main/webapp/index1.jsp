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
<h1></h1>
<h1>세션정보에 담겨진 정보 ${sesVO }</h1>
=======================
	<table>
	</table>
	<button>정보가져오기</button>
	<script>
		var objItem = [ 'id', '아이디', 'password', '비밀번호', 'name', '이름',
				'address', '주소', 'age', '나이' ];
		var innerHTML = '';
		for (let i = 0; i < objItem.length; i = i + 2) {
			innerHTML = innerHTML + '<tr><th>' + objItem[i + 1]
					+ '</th><td id="'+ objItem[i] +'"></td></tr>'
		}
		$('table').html(innerHTML)
		$('button').click(function() {
			$.ajax({
				url : "http://localhost/conex/databind",
				method : "GET"
			}).done(function(json) {
				for (let i = 0; i < objItem.length; i = i + 2) {

					$('#' + objItem[i]).text(json[objItem[i]]);
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