<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.tech.entity.Message" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
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
				<span class="fa fa-user-plus fa-3x"></span> <br>
				<h3>Register</h3>

				<form action="Register" method="post" id="Registerform">

					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" name="name" placeholder="Enter Username" required="required">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" name="email"
							placeholder="Enter email"  required="required"> <small 
							class="form-text text-muted">We'll never share your email
							with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" name="password"
							placeholder="Password"  required="required">
					</div>
					<div class="form-group">
						<label for="Gender">Gender</label><br> <input type="radio"
							id="male" name="gender" value="male" checked="checked"> <label for="male">Male</label><br>
						<input type="radio" id="female" name="gender" value="female">
						<label for="female">Female</label><br> <input type="radio"
							id="other" name="gender" value="other"> <label
							for="other">Other</label>
					</div>
					<div class="form-check" >
						<input type="checkbox" class="form-check-input" name="checked" required="required">
						<label class="form-check-label" for="exampleCheck1">agree
							terms and condition</label>
					</div>
					<div class="container text-center" id="process"style='display:none' >
						<span class="fa fa-refresh fa-spin fa-3x" ></span>
						<h4 > Please Wait</h4>
					</div>
					<br>
					<button type="submit" class="btn btn-primary" id="submit-btn">Submit</button>
				</form>
			</div>
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
		        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
		

	<script>
		$(document).ready(function() {
			console.log("hello");
			
			$('#Registerform').on('submit',function(event){
				event.preventDefault();
				const form=new FormData(this);
				console.log(form);
				$('#process').show();
				$('#submit-btn').hide();
				
				$.ajax({
					url:'Register',
					type:'POST',
					data:form,
					success:(data,textStatus,jqXHR)=>{
						//console.log(textStatus);
						//console.log(jqXHR.responseText);
						$('#process').hide();
						$('#submit-btn').show();
						  if (data.trim() === 'done')
                          {
                              swal("Registered successfully..We are going to redirect to login page")
                                      .then((value) => {
                                          window.location = "login.jsp"
                                      });
                          } else
                          {
                              swal(data);

                          }
					},
					error:(jqXHR,textStatus,errorThrown)=>{
						//console.log(errorThrown);
                        swal("something went wrong..try again");

					},
					processData:false,
					contentType:false
				});
			})
		})
		
		

	</script>
</body>
</html>