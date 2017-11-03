<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

	<title>Add New Book</title>
	<style type="text/css">
		.error{
			color:red;
		}
	</style>
</head>
	
	
<body>
	<div class="container">
		<div class="content">
			
			Complete/Confirm all information in below form
			<br/>
			<form:form action="addBook_confirm" method="POST" modelAttribute="book">
			
				Title: <form:input path="Title" value="${book.title}"/>
				<form:errors path="Title" cssClass="error" />
				<br/>
				Author: <form:input path="Author" value="${book.author}"/>
				<form:errors path="Author" cssClass="error" />
				<br/>
				Pages: <form:input path="Pages" value="${book.pages}"/>
				<form:errors path="Pages" cssClass="error" />
				<br/>
				PublishingHouse: <form:input path="PublishingHouse" value="${book.publishingHouse}"/>
				<form:errors path="PublishingHouse" cssClass="error" />
				<br/>
				<form:input type="hidden" path="Wypozyczona" value="false"/>
				<form:input type="hidden" path="Owner" value="${libraryUser}"/>
					
				<input type="submit" value="Add book">
			
			</form:form>
		
		</div>
	
	</div>

</body>

</html>