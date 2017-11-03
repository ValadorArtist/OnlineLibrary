<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<head>
	<title>Login Page</title>
	<style type="text/css">
		.error{
			color:red;
		}
	</style>
</head>
	
	
<body>
	<div class="container">
		<div class="content">
			
			Congratulation. Your account has been made!
			<br/>
			Now, it is required to activate your account!
			<br/> 
			It was sent an email to your email account. Please, go there and click in activated link.
			<br>
			You have to activate your account until 24h. After that, your link and account will be inactive.
			
			<form:form action="main" method="POST">
				<input type="submit" value="Powrot" />
			</form:form>
		</div>
	
	</div>

</body>

</html>