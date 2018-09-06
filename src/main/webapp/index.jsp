<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Rate</title>
</head>
<body>

	<h1 align="center">Rate</h1>

	<form action="begin" method="get">
			<b>Select currency</b>
		<p>
			<select name="currency" size="1">
				<option value=1>Dollar rate to Bitcoin</option>
				<option value=2>Ethereum rate to Bitcoin</option>
			</select> <br>
		<p>
			<input type="submit" value="Send">
		</p>
	</form>

</body>
</html>
