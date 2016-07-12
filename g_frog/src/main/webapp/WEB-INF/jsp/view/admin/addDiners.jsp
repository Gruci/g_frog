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
		<input type="text" class="form-control" name="diner_name" maxlength="10" required="required" placeholder="Write dinners name" autocomplete="off">
		<input type="text" class="form-control" name="diner_call" maxlength="10" required="required" placeholder="Write call " autocomplete="off">

		<input type="text" class="form-control" name="intro" maxlength="15" required="required" placeholder="Write intro" autocomplete="off">
		<input type="hidden"    name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		
		<button type="submit" class="btn btn-primary" value="submit">Submit</button>
	</form>
</body>
</html>