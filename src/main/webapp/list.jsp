<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, java.util.ArrayList, model.dao.dto.TodoDTO"%>
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
	<p>006_list.jsp</p>
	<%
	List<TodoDTO> todoList = (List) request.getAttribute("todoList");
	%>

	<%
	for (TodoDTO todo : todoList) {
	%>
	<p><%=todo.getTodoContent()%></p>
	<a href="update-servlet?<%=Parameters.sTODO_ID %>=<%= todo.getTodoId() %>">更新</a>
	<a href="delete-servlet?<%=Parameters.sTODO_ID %>=<%= todo.getTodoId() %>">削除</a>
	<br>
	<%
	}
	%>


	<form action="insert-servlet" method="post">
		<label>Todo: </label><input type="text" name="<%=Parameters.sTODO_Content %>"><br>
		 <br>
		<input type="submit" value="Todo追加">
	</form>
	<a href="/007_StandardCaluculator/logout.jsp">ログアウト</a>
	
</body>
</html>