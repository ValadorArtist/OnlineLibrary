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
			
			Informations about book are below. 
			<br/>
			
			Title: ${book.title}
			<br/>
			Author(s): ${book.author}
			<br/>
			Pages: ${book.pages}
			<br/>
			PublishingHouse: ${book.publishingHouse}
			<br/>
			<c:choose>
			<c:when test="${book.owner eq login}">
				
				Lend the book to your friend 
				<form:form action="bookInfo/lendBook" method="POST" modelAttribute="lendParam">
					<form:input path="loanToWho"/>
					<form:errors path="loanToWho" cssClass="error"/>
					<form:input type="hidden" path="bookName" value="${book.title}"/>
					<form:input type="hidden" path="owner" value="${book.owner}"/>
					<form:input type="hidden" path="id" value="${book.id}"/>
					<br/>
					<input type="submit" value="Lend a book"/>
				</form:form>
				
				
				Add to actual reading 
				<form:form action="" method="POST" modelAttribute="lendParam">
					<form:input type="hidden" path="bookName" value="${book.title}"/>
					<form:input type="hidden" path="owner" value="${book.owner}"/>
					<form:input type="hidden" path="loanToWho" value="${book.owner}"/>
					<input type="submit" value="Add book"/>
				</form:form>
				
			</c:when> 
			<c:when test="${mode eq 'modeOne'}">
				
				Add to actual reading 
				<form:form action="" method="POST" modelAttribute="book">
					<form:input type="hidden" path="id" value="${book.id}"/>
					<form:input type="hidden" path="isActualReading" value="${login}"/>
					<input type="submit" value="Start reading book"/>
				</form:form>
				Have you the same book? Add to your own library
				<form:form action="" method="POST" modelAttribute="book">
					<form:input type="hidden" path="id" value="${book.id}"/>
					<form:input type="hidden" path="isActualReading" value="${login}"/>
					<input type="submit" value="Add book"/>
				</form:form>
				
			</c:when> 
			<c:otherwise>
				
				Lend a book to your library
				<form:form action="" method="POST" modelAttribute="lendParam">
					<form:input type="hidden" path="loanToWho" value="${login}"/>
					<form:input type="hidden" path="bookName" value="${book.title}"/>
					<form:input type="hidden" path="owner" value="${book.owner}"/>
					<br/>
					<input type="submit" value="Lend a book"/>
				</form:form>
				
			</c:otherwise>
			</c:choose>
			 
		</div>
	
	</div>

</body>

</html>