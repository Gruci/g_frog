<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <script type="text/javascript">
 boardIndex = "${board_no}"
 </script>
<body>
	<h1>${board_no }</h1>
	<td>${title }</td>
	<h1> ${content } </h1>

	<a href="<%=request.getContextPath()%>/delete.do?board_no=${board_no}">delete</a>
	<a href="<%=request.getContextPath()%>/edit.do?board_no=${board_no}">edit</a>
</body>
</html>