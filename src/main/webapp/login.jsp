<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="constant.Parameters"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

	<form action="LoginServlet" method="post">
		<input type="text" name="<%=Parameters.sLOGIN_ID%>"> <input
			type="password" name="<%=Parameters.sLOGIN_PASSWORD%>"> <input
			type="submit" value="ログイン">
	</form>
</body>
</html>