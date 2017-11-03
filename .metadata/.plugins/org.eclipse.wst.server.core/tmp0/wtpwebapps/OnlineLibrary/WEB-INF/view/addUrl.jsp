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
			
			Write the WebPage url to get data of book
			<br/>
			<form:form action="addBookValid" method="POST" modelAttribute="url">
			
				Url address: <form:input path="url"/>
				<form:errors path="url" cssClass="error" />
				<br/>
				<input type="submit" value="Parse">
			</form:form>
		
		</div>
	
	</div>

</body>

</html>