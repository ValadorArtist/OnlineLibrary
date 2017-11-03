<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

	<title>Main Page</title>
	<link rel="stylesheet" href="css/styleMainPage.css" type="text/css" />
</head>
	
	
<body>
 <div class="container">
  	<h1 class="title">Welcome ${login} to your library</h1>
  	
	<div class="content">
	
		<nav>
		  	<p class="smallTitle">Choose the library</p>
			<div class="chooseLibrary">
				<ul>
				<c:forEach var="tempName" items="${libraryNameList}">
					<li><a href="MainPage?library=${tempName.libraryUser}">${tempName.libraryUser}</a></li>
				</c:forEach>
					<li><a href="MainPage?library=all">List books from all libraries</a></li>
				</ul>
			</div>
			
			<p class="smallTitle">Invite your friend to the library</p>
			<div class="InviteFrined">				
				<form:form action="Invite" method="POST" modelAttribute="invite">
				Write user nickname:
				<form:input path="password" />
				<form:errors path="password" cssClass="error"/>
				<br/>
				Write user email:
				<form:input path="email"/>
				<form:errors path="email" cssClass="error"/>
				<form:input type="hidden" path="login" value="${login}"/>
				<br/>
				<input type="submit" value="Invite" />
			</form:form>
			</div>
			
			<p class="smallTitle">Add new book</p>
			<div class="AddBook">
				<ul>
				<li><a href="addBookManual">Manual</a></li>
				<li><a href="addBookByParsing">From other service</a></li>
				</ul>
			</div>
			
			<p class="smallTitle">If you need log out, just click below. </p>
			<form:form action="main" method="POST">
					<input type="submit" value="Log out" />
			</form:form>
			
		</nav>
			
			<div class="ListBooks">
				<p class="title">List of the books</p>
				 <table>
				  <tr>
				    <th>Title</th>
				    <th>Books information</th>
				  </tr>
		
				<c:forEach var="tempList" items="${booksList}">
					 <c:url var="link" value="bookInfo">
					 <c:param name="bookId" value="${tempList.id}"/>
				 </c:url>
			 
				  <tr>
				    <td>${tempList.title}</td>
				    <td><a href="${link}">Watch the description</a></td>
				  </tr>
				  
				</c:forEach> 
				</table> 
			</div>
				
		</div>
	</div>
	
<div class="footer">
       <p>Copyright &copy; 2017 Wojciech Zebrowski</p>
</div>	

</body>

</html>