<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <script type="text/javascript">
 boardIndex = "${board_no}"
 </script>
<body>
	<h1>Board Number is ${board_no }</h1>
	<p>Title: ${title}</p><br>
	<p>ID: ${user_id } </p>
	<h1> ${content } </h1>

	<a href="<%=request.getContextPath()%>/delete.do?board_no=${board_no}">delete</a>
	<a href="<%=request.getContextPath()%>/edit.do?board_no=${board_no}">edit</a>
	
	
	
	<h1>reple</h1>
	<table id="box-table-a" class="table table-hover">
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">content</th>
				<th scope="col">ID</th>
				<th scope="col">Created_Date</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach var="list" items="${lists}">
		<tr>
			<th  >${list.comment_no }</th>
			<td>${list.comment_content}</td>
			<td>${list.user_id }</td>
			<td>${list.register_date }</td>
			<td>${list.visible }</td>
			<td><a href="<%=request.getContextPath()%>/reple_delete.do?index=${list.comment_no}">delete reple</a></td>
			<td><a href="<%=request.getContextPath()%>/reple_edit.do?index=${list.comment_no}">edit reple</a></td>
		</tr>
	</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
</body>
</html>