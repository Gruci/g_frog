
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>replyList</title>
</head>
<body>

<a>평균점수: ${grade }</a>

	<table id="box-table-a" class="table table-hover">
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">user_show_name</th>
				<th scope="col">content</th>
				<th scope="col">posting_date</th>
				<th scope="col">grade</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach var="list" items="${lists}">
		<tr>
			<th scope="row">${list.no }</th>
			<td>${list.user_show_name }</td>
			<td>${list.content }</td>
			<td>${list.posting_date }</td>
			<td>${list.grade }</td>
			<td><a href="<%=request.getContextPath()%>/reply/replyDelete.do?no=${list.no }" class="btn btn-success">Delete</a></td>
			<td><a href="<%=request.getContextPath()%>/reply/replyEdit.do?no=${list.no }" class="btn btn-success">Edit</a></td>
		</tr>
	</c:forEach>
		</tbody>
		<tfoot>
		</tfoot>
	</table>
</body>
</html>