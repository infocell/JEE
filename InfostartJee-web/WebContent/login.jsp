<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/test.css">
<title>Infostart first JEE application</title>
</head>
<body>

<h1>
<%

out.println("Login Form");

%>

<h:outputText style="color: red;" id="outputText12" value="blabla" />

</h1>

<div>

<form method="POST" action="<%=request.getContextPath()%>/loginServlet">

Username: <input type="text" name="username" value="dada" />
<br/><br/>
Password: <input type="password" name="password" />
<br/><br/>
<input type="submit" value="Login"/>

</form>

</div>

</body>
</html>