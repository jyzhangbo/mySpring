<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>home</title>
</head>
<body>
<security:authorize access="hasRole('ADMIN')">
    <h1>admin</h1>
</security:authorize>
home
<c:url value="/logout" var="logoutUrl"/>
<a href="${logoutUrl }">退出系统</a>
</body>
</html>