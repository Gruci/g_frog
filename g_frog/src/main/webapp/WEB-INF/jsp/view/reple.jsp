<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>
</head>
<body>
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
			<th scope="row">${list.comment_no }</th>
			<td>${list.comment_context }</td>
			<td>${list.user_id }</td>
			<td>${list.register_date }</td>
			
		</tr>
	</c:forEach>
		</tbody>
	</table>

</body>
</html>