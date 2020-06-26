<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="com.tech.helper.*,java.util.List,com.tech.entity.*"%>
<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("login.jsp");
	}
%>
<div class="container">

	<div class="row mb-2 ">

		<%
			List<Post> posts = null;
			int cid = Integer.parseInt(request.getParameter("cid"));
			//out.print(cid);
			if (cid == 0) {
				posts = GetPost.getPosts();

			} else {
				posts = GetPost.getPostById(cid);
			}

			if (posts.size() == 0) {
				out.println("<h3 class='display-3 text-center'>No Posts in this category..</h3>");
				return;
			}
		%>

		<c:forEach items="<%=posts%>" var="post">
			<div class="col-md-4 mt-3">
				<div class="card">

					<img class="card-img-top" src="img/blog/${post.getPhoto() }"
						alt="${post.getTitle()}">
					<div class="card-body">
						<h5 class="card-title">${post.getTitle()}</h5>
						<c:set var="content" value="${post.getContent()}"></c:set>
						
						<p class="card-text">	${fn:substring(content,0,100)}
</p>
						<p>${post.getTime()}</p>
						<a href="FullPost.jsp?id=${ post.getPid()}"
							class="btn btn-primary">Read More</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>