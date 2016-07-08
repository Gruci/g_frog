<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	<h1>User : ${username} </h1>
	<h1>pass : ${password} </h1>

	<h1>ROLE : ${ROLE} </h1>
	<sec:authorize access="hasRole('ROLE_USER')">

	</sec:authorize>
</body>
</html>