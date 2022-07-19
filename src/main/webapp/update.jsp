<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.dao.dto.TodoDTO" %>
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
TodoDTO todoDTO = (TodoDTO)request.getAttribute("content");
%>
<body>
<form action="update-servlet" method="post" >
	<label>Todo: </label><input type="text" name="<%=Parameters.sTODO_Content %>" value="<%=todoDTO.getTodoContent()%>">
	<input type="hidden" name="<%=Parameters.sTODO_ID %>" value="<%=todoDTO.getTodoId() %>">
	<input type="submit" value="Todoを更新">
</form>

</body>
</html>