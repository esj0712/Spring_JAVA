<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>URL Mapping</title>
</head>
<body>
	<!--#1 요청 1.data1, 2.data2 / 3.data3에 배열 -->
	<a href="test1?data1=100&data2=200&data3=300&data3=400">test1 get</a>

	<!-- #2 post -->
	<hr />
	<!-- post 방식은 form에서만 -->
	<form action="test2" method="post">
		data1 : <input type="text" name="data1"><br> data1 : <input
			type="text" name="data2"><br>
		<!-- 여러개를 요청 -->
		data3 : <input type="checkbox" name="data3" value="100" />data3 100 <br />
		<input type="checkbox" name="data3" value="200" />data3 200 <br />
		<button type="submit">test2 post</button>
	</form>
	<p></p>
	<hr />
	<!--#3 요청 1.data1, 2.data2 / 3.data3에 배열 -->
	<a href="test3?data1=100&data2=200&data3=300&data3=400">test3 get</a>
	<hr />
	<!--#4 요청 데이터를 순서로 요청함 -->
	<a href="test4/100/200/300">test4 get</a>
	<hr />
	<!--#5 요청 1.data1, 2.data2 / 3.data3에 배열 -->
	<a href="test5?data1=100&data2=200&data3=300&data3=400">test5</a>
	<hr />
	<!--#6 요청 1.data1, 2.data2 / 3.data3에 배열 -->
	<a href="test6?data1=100&data2=200&data3=300&data3=400">test6</a>
	<hr />
	<!--#7 요청 1.data1, 2.data2 / 3.data3에 배열 -->
	<a href="test7?data1=100&data2=200&data3=300&data3=400">test7</a>
	<hr />
	<!--#8 요청값이 없을 때 오류 방지 -->
	<a href='test8?data1=100'>test8</a>
	<br />
	<hr />

</body>
</html>