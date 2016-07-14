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
		<input type="text" class="form-control" name="s_diners_no" maxlength="10" required="required" placeholder="diner_no" autocomplete="off">
		<input type="textarea" class="form-control" name="content" maxlength="10" required="required" placeholder="Write content " autocomplete="off">
		<select name="s_grade" required="required">
            <OPTION VALUE='1'>1</OPTION>
            <OPTION VALUE='2'>2</OPTION>
            <OPTION VALUE='3'>3</OPTION>
            <OPTION VALUE='4'>4</OPTION>
            <OPTION VALUE='5'>5</OPTION>
        </select>  
		<input type="hidden"    name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		
		<button type="submit" class="btn btn-primary" value="submit">Submit</button>
	</form>
</body>
</html>