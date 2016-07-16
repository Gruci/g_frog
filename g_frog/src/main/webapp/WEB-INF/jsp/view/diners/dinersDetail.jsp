<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>diners detail</title>
 
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" language="javascript">

$(document).ready(function(){
	   $.ajax({
	       url:'/reply/replyList.do',
	       type : 'POST',
	       data : {'board_no':"${dinersVO_no}"},
	       dataType: 'html',
	       success : function(data){
	         $("#replyArea").html(data);
	      }
	   });
	});
	
 </script>
 </head>
<body>


		<tr>
			<th scope="row">diners</th><br>
			<td>${dinersVO_no}</td><br>
			<td>${dinersVO_name}</td><br>
			<td>${dinersVO_intro}</td><br>
		
			
		</tr>




	<c:forEach var="dinersPhotopathVO_lists" items="${dinersPhotopath}">
		<tr>
			<th scope="row">photo</th>
			<td>${dinersPhotopathVO_lists}</td><br>
			<td><img src="${dinersPhotopathVO_lists}"></td><br>
		</tr>
	</c:forEach>
	
	<div id="replyArea"></div>
</body>
</html>