<%@page import="com.website.web.model.Client"%>
<%@ page %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
		<%
		Client c1 = (Client)request.getAttribute("client");
		out.println(c1);
		%>
</body>
</html>