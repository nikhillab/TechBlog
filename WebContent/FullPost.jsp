<%@page import="com.tech.helper.GetPost"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tech.entity.*"%>
<%@page errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("login.jsp");
	}
%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
%>
<c:set var="post" value="<%=GetPost.getFullPost(id)%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${post.getTitle()}</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>



	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4 text-center">${post.getTitle()}</h1>
			<img alt="${post.getTitle()}" src="img/blog/${post.getPhoto() }"
				class="rounded mx-auto d-block">
			<hr>
			Time of Publish <span>${post.getTime() }</span>
			<hr>
			<p class="lead">${post.getContent() }</p>
			<br>
			<button class="btn btn-outline-dark">
				<span class="fa fa-thumbs-up fa-2x">100</span>
			</button>
			<button class="btn btn-outline-dark">
				<span class="fa fa-thumbs-down fa-2x">10</span>
			</button>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>