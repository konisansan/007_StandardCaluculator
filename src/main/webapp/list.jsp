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
	<h5><%=todo.getTodo()%></h5>
	<a href="update-servlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>">todoを更新する</a>
	<a href="delete-servlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>">todoを削除する</a>
	<br>
	<%
	}
	%>


	<form action="insert-servlet" method="post">
		<label>Todo: </label><input type="text" name="<%=Parameters.TODO %>"><br>
		 <br>
		<input type="submit" value="Todoを登録する">
	</form>
	
	
</body>
</html>