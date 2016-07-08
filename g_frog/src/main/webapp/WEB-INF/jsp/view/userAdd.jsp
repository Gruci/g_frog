<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
</head>
<body>
	<form action="" method="post" >
		<input type="text" class="form-control" name="userName" maxlength="10" required="required" placeholder="Write your name" autocomplete="off">
		<input type="text" class="form-control" name="userEmail" maxlength="10" required="required" placeholder="Write Email " autocomplete="off">
		<input type="text" class="form-control" name="password" maxlength="15" required="required" placeholder="Write Password" autocomplete="off">
		<input type="hidden"    name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		
		<button type="submit" class="btn btn-primary" value="submit">Submit</button>
	</form>
</body>
</html>