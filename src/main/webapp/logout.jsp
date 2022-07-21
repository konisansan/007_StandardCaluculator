<%@ page language="java" contentType="text/html;charset=Windows-31J" %>

<html>
<head>
<title></title>
</head>
<body>
<br>

<%
//セッション終了
session.invalidate();
%>

<br><br>
ログアウトしました<br><br>

<a href="/008_StandardCaluculator/login.jsp">再ログイン</a>
<br><br><br><br>

</body>
</html>