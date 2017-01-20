<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<spring:url value="resources/css/app.css" />"
	rel="stylesheet" type="text/css">
<title>home</title>
</head>
<body class="security-app">
	<div class="details">
		<h2>Shopping Store: Spring Project</h2>

	</div>
	<div class="lc-block">
		<h1>Welcome!</h1>
		<div class="alert-normal">
			Click <a href="<spring:url value='/login' />">here</a> to see a
			greeting.
		</div>
	</div>
</body>
</html>
