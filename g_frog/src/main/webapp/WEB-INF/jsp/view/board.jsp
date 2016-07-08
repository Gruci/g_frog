<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<c:forEach var="post" items="${posts}">
		<h3> <a href="postShow.do?index=${post.getIndex()}"> ${post.getTitle()} </a> </h3>
	</c:forEach>
</body>
</html>