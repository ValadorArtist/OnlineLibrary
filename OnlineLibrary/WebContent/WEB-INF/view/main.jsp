<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

	<title>Login Page</title>
	<link rel="stylesheet" href="css/styleMain.css" type="text/css" />
</head>

<body>
	<div class="container">
		<div class="content">

			<h1 class="MainTitle">WELCOME TO ONLINE LIBRARY</h1>
			<form:form action="login" method="POST" modelAttribute="user">
				
				<div class="containerLogPass">
					Login: <form:input path="login" cssClass="loginElement"/>
						   <form:errors path="login" cssClass="error" />
					<br />
					Password: <form:password path="password"/>
							  <form:errors path="password" cssClass="error" />
							  
					<form:input type="hidden" path="email" value="email@email.pl" />
					<br />
					<input type="submit" value="Submit" class="submitElement">
					
				</div>

			</form:form>

			<p class="text1">If you are not a user in our service, please - <a href="addUser">Log in!</a></p>

		</div>

	</div>
<div class="footer">
        <p>Copyright &copy; 2017 Wojciech Zebrowski</p>
</div>
</body>

</html>