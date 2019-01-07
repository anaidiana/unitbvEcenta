<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container">
		${loginError}
		<div class="form-group form">
			<form action='login' method="post">
				<div>
					<label>User name:</label> <input type="text" id="userId"
						name="userId" placeholder="User name" class="form-control" />
				</div>
				<div>
					<label>Password:&nbsp&nbsp</label> <input type="password" id="password"
						name="password" placeholder="Password" class="form-control" />
				</div>
				<button id="loginButton" class="form-control">Login</button>
			</form>
		</div>
	</div>

</body>
</html>