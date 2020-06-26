<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tech.entity.*"%>
<%@page import="com.tech.helper.*,java.util.List"%>
<%@page errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${user.getName()}</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp"><i class="fa fa-code"></i>Nikhil
			Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item "><a class="nav-link" href="index.jsp">Home
						<span class="sr-only"></span>
				</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fa fa-check-square-o"></i>Catgories
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Languages</a> <a
							class="dropdown-item" href="#">Project Idea</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Web Tutorial</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">
						<span class="fa fa-user-circle "></span>Login
				</a></li>

				<li class="nav-item"><a class="nav-link" href="register.jsp">
						<span class="fa fa fa-user-plus"></span>Register
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Contact
						US</a></li>

				<li class="nav-item"><a class="nav-link" href="#"
					data-toggle="modal" data-target="#postmodel">New Post</a></li>
			</ul>

			<form class="form-inline my-2 my-lg-0 ">

				<a type="button" class="btn btn-light my-2 my-sm-0"
					data-toggle="modal" data-target="#profile"> <span
					class=" fa fa-user-circle "></span>&nbsp;&nbsp;${user.getName()}
				</a> &nbsp;&nbsp;&nbsp; <a type="button"
					class="btn btn-light my-2 my-sm-0" href="Logout">Logout</a>
			</form>
		</div>
	</nav>

	<%
		Message message = (Message) session.getAttribute("msg");
		if (message != null) {
	%>
	<div class="<%=message.getCssClass()%>" role="alert"><%=message.getMessage()%></div>
	<%
		session.removeAttribute("msg");
		}
	%>
	<main>

		<div class="container mt-5">

			<div class="row">
				<!-- Show Category -->

				<div class="col col-md-12 col-lg-4 ">
					<div class="row mb-2">

						<div class="list-group">

							<a href="#" onclick="getPosts(0)"
								class=" c-link list-group-item list-group-item-action "> All
								Posts </a>

							<%
								List<Category> listCategory = GetCategoryList.categoryList();
							%>

							<c:forEach items="<%=listCategory%>" var="item">

								<a href="#" onclick="getPosts(${item.getId()})"
									class=" c-link list-group-item list-group-item-action">${item.getType()}</a>

							</c:forEach>




						</div>



					</div>

				</div>


				<!-- End Of Show Category -->

				<!-- Show Post -->
				<div class="col col-lg-8 col-12 col-md-12" id="postContainer">

					<div class="container text-center" id="postLoad">
						<span class="fa fa-refresh fa-spin fa-3x"></span>
						<h5>Please Wait While Loading Post</h5>

					</div>
				</div>
			</div>
		</div>
	</main>

	<!-- End Of Show Post -->

	<!-- Profile  Modal -->

	<div class="modal fade" id="profile" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						<i class="fa fa-code"></i>Nikhil Blog
					</h5>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="container">
					<img alt="profile" src="img/profile/${user.getProfile()}"
						width="170px" style="margin: 40px">
					<h3 class="text-center">${user.getName()}</h3>
				</div>
				<div id="profile-data" class="container">
					<div class="modal-body">
						<div class="container ">


							<table class="table">

								<tbody>
									<tr>
										<td>User ID:</td>
										<td>${user.getId()}</td>
									</tr>
									<tr>
										<td>Name:</td>
										<td>${user.getName()}</td>
									</tr>
									<tr>
										<td>Email:</td>
										<td>${user.getEmail()}</td>
									</tr>
									<tr>
										<td>Gender:</td>
										<td>${user.getGender()}</td>
									</tr>
									<tr>
										<td>Registation Date :</td>
										<td>${user.getRdate().toString()}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>


				<div id="profile-edit" class="container" style="display: none">
					<form method="post" action="UpdateUser"
						enctype="multipart/form-data">
						<table class="table">
							<tbody>
								<tr>
									<td>User ID:</td>
									<td>${user.getId()}</td>
								</tr>
								<tr>
									<td>Name:</td>
									<td><input type="text" value="${user.getName()}"
										name="name"></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td>${user.getEmail()}</td>

								</tr>
								<tr>
									<td>Password:</td>
									<td><input type="password" value="${user.getPassword()}"
										name="password"></td>

								</tr>
								<tr>
									<td>Profile:</td>
									<td><input type="file" name="profile"></td>

								</tr>
								<tr>
									<td>Gender:</td>
									<td>${user.getGender()}</td>
								</tr>
								<tr>
									<td>Registation Date :</td>
									<td>${user.getRdate().toString()}</td>
								</tr>
							</tbody>
						</table>
						<input type="submit" value="Save" class="btn btn-primary">
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary"
						id="profileEditButton">Edit</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Profile  Modal  End -->

	<!-- POST  Modal   -->

	<div class="modal fade" id="postmodel" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						<i class="fa fa-code"></i>Nikhil Blog
					</h5>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="container">
					<h3 class="text-center">Welcome ${user.getName()}</h3>
					<h4 class="text-center" style="color: red">Write your post
						hear.</h4>
				</div>
				<div id="profile-data" class="container">
					<div class="modal-body">
						<div class="container ">

							<form action="NewPost" method="post"
								enctype="multipart/form-data">
								<div class="form-group">
									<label for="exampleFormControlSelect1" class="font-weight-bold">Select
										Post Category</label> <select class="form-control" name="category">
										<%
											for (Category category : listCategory) {
												out.print("<option value=" + category.getId() + ">" + category.getType() + "</option>");
											}
										%>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleFormControlInput1" class="font-weight-bold">Post
										Title</label> <input type="text" class="form-control"
										placeholder="Enter Post Title" required="required"
										name="title">
								</div>


								<div class="form-group">
									<label for="exampleFormControlTextarea1"
										class="font-weight-bold" required="required">Enter
										Post Content in the textarea</label>

									<textarea class="form-control" rows="3" name="content"></textarea>
								</div>

								<div class="form-group">
									<label for="exampleFormControlFile1" class="font-weight-bold">Enter
										image of post</label> <input type="file" class="form-control-file btn"
										name="photo">
								</div>
								<input type="submit" class="btn btn-primary">
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>

	</div>

	<!-- POST  Modal END  -->


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

	<script>
		$('document').ready(function() {
			var isChanged = false;
			$("#profileEditButton").click(function() {

				if (isChanged) {
					$('#profile-data').show();
					$('#profile-edit').hide();
					isChanged = false;
					$(this).text('Edit');

				} else {
					$('#profile-data').hide();
					$('#profile-edit').show();
					isChanged = true;
					$(this).text('Back');

				}

			})
		})
	</script>
	<script>
	
	function getPosts(id){
		
		//console.log(id);

		$.ajax({
				url:'post.jsp',
				type:'GET',
				data: {cid:id},
				success:(data,textStatus,jqXHR)=>{
					$('#postLoad').hide();
					$('#postContainer').html(data);
					
				},
				error:(jqXHR,textStatus,errorThrown)=>{

				}

			})
		
	}
			$('document').ready(function(e){
				getPosts(0);

			})
	
	
	
	
	
	</script>
</body>
</html>