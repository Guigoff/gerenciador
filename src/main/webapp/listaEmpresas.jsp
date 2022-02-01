<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.furla.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/mostraEmpresa?id=" var="linkServletMostrarEmpresa"/>
<c:url value="/deletaEmpresa?id=" var="linkServletDeletaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista das empresas cadastradas</title>
</head>
<body>

<ul>

	<c:if test="${not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	
	<c:forEach items="${empresas}" var="empresa">

		
		<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<p>
			<a href="${linkServletMostrarEmpresa}${empresa.id}">Editar</a><br/>
			<a href="${linkServletDeletaEmpresa}${empresa.id}">Remover</a></p>
		</li>

	</c:forEach>
</ul>

</body>
</html>