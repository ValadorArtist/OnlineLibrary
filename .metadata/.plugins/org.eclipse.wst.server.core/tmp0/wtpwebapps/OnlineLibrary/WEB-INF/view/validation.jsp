<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

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
			Congratulations. Your account was activated. Now, you can log in and enjoy our service!
			<form:form action="login" method="POST" modelAttribute="user">
			
				Login: <form:input path="login"/>
				<form:errors path="login" cssClass="error" />
				<br/>
				Password: <form:password path="password"/>
				<form:errors path="password" cssClass="error" />
				
				<form:input type="hidden" path="email" value="email@email.pl"/>
				<br/>
				<input type="submit" value="Submit">
				
			</form:form>
			
		</div>
	
	</div>

</body>

</html>