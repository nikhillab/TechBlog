<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.tech.helper.*,java.util.List,com.tech.entity.*"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nikhil Blog</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-0 m-0">

		<div class="jumbotron banner-background">
			<div class="container">
				<h3 class="display-3">Welcome to Nikhil Blog</h3>

				<p>Welcome to technical blog, world of technology A programming
					language is a formal language, which comprises a set of
					instructions that produce various kinds of output. Programming
					languages are used in computer programming to implement algorithms.
				</p>
				<p>Most programming languages consist of instructions for
					computers. There are programmable machines that use a set of
					specific instructions, rather than general programming languages.</p>

				<a href="register.jsp" class="btn btn-dark btn-lg"> <span
					class="fa fa fa-user-plus"></span> Start ! its Free
				</a> <a href="login.jsp" class="btn btn-dark btn-lg"> <span
					class="fa fa-user-circle "></span> Login
				</a>

			</div>
		</div>
	</div>
	<div class="post">
		<div class="container text-center" id="postLoad">
			<span class="fa fa-refresh fa-spin fa-3x"></span>
			<h5>Please Wait While Loading Post</h5>

		</div>
		<div id="showpost"></div>
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
	<script src="js/index.js" type="text/javascript"></script>
	<script>
	
	$('document').ready(function(e){
		$.ajax({
			url:'post.jsp',
			type:'GET',
			data: {cid:0},
			success:(data,textStatus,jqXHR)=>{
				//console.log(data)
				$('#postLoad').hide();
				$('#showpost').html(data);
				
			},
			error:(jqXHR,textStatus,errorThrown)=>{

			}

		})
	})

	
	
	
	</script>
</body>
</html>