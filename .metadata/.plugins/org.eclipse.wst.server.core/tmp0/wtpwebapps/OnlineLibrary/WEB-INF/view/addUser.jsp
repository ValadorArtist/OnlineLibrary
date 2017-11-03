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
			
			Complete all information in below form
			<br/>
			<form:form action="addUser_confirm" method="POST" modelAttribute="add_user">
			
				Login: <form:input path="login"/>
				<form:errors path="login" cssClass="error" />
				<br/>
				Password: <form:password path="password"/>
				<form:errors path="password" cssClass="error" />
				<br/>
				Email: <form:input path="email"/>
				<form:errors path="email" cssClass="error" />
				<br/>
				<input type="submit" value="Zarejestruj sie">
				
			</form:form>
		
		</div>
	
	</div>

</body>

</html>