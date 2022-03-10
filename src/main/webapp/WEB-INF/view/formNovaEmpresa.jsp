<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/home" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome" />
		Data Abertura: <input type="text" name="dataAbertura" />
		<input type="hidden" name="acao" value="NovaEmpresa"/>
		<input type="submit"/>
	</form>

<c:import url="logout-parcial.jsp"/>

</body>
</html>