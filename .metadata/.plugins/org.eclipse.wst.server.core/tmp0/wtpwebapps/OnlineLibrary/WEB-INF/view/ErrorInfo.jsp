<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

	<title>Book Info</title>
	<style type="text/css">
.error {
	color: red;
}
</style>
</head>
	
	
<body>
	<div class="container">
		<div class="content">

			<c:choose>
			<c:when test="${mode eq 'ErrorOne'}">
			
				<p class="error"> You have made an error! Come back to last page and correct your fault. </p>
				<form:form action="bookInfo">
					<input type="submit" value="Back"/>
				</form:form>
				
			</c:when> 
			</c:choose>
			 
		</div>
	
	</div>

</body>

</html>