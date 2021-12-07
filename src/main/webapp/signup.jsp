<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Sign Up Form</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="assets/css/opensans-font.css">
	<link rel="stylesheet" type="text/css" href="assets/fonts/line-awesome/css/line-awesome.min.css">
	<!-- Jquery -->
	<link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="assets/css/signstyle.css"/>
</head>
<body class="form-v7">
	<div class="page-content">
		<div class="form-v7-content">
			<div class="form-left">
				<img src="assets/images/expenselogo.jpg" alt="form">
				<p class="text-1">Sign Up</p>
				<p class="text-2">Privacy policy & Term of service</p>
			</div>
			<form class="form-detail" action="AddUserServlet" method="post">
				<div class="form-row">
					<label for="username">USERNAME</label>
					<input type="text" name="full-name" id="username" class="input-text">
				</div>
				<div class="form-row">
					<label for="your_email">E-MAIL</label>
					<input type="text" name="your-email" id="your_email" class="input-text" required pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}">
				</div>
				<div class="form-row">
					<label for="password">PASSWORD</label>
					<input type="password" name="password" id="password" class="input-text" required>
				</div>
				<div class="form-row">
					<label for="comfirm_password">CONFIRM PASSWORD</label>
					<input type="password" name="comfirm-password" id="comfirm_password" class="input-text" required>
				</div>
				<div class="form-row-last">
					<input type="submit" name="register" class="register" value="AddUser">
					<p>Or<a href="login.jsp">Sign in</a></p>
				</div>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
	<script>
		// just for the demos, avoids form submit
		jQuery.validator.setDefaults({
		  	debug: true,
		  	success:  function(label){
        		label.attr('id', 'valid');
   		 	},
		});
		$( "#myform" ).validate({
		  	rules: {
			    your_email: {
			      	required: true,
			      	email: true
			    },
			    password: "required",
		    	comfirm_password: {
		      		equalTo: "#password"
		    	}
		  	},
		  	messages: {
		  		username: {
		  			required: "Please enter an username"
		  		},
		  		your_email: {
		  			required: "Please provide an email"
		  		},
		  		password: {
	  				required: "Please provide a password"
		  		},
		  		comfirm_password: {
		  			required: "Please provide a password",
		      		equalTo: "Wrong Password"
		    	}
		  	}
		});
	</script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>