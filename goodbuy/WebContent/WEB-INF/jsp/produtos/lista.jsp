<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Editar</th>
				<th>Excluir</th>
				<th>Comprar</th>
			<tr>
		</thead>
		<tbody>
			<c:forEach items="${produtoList}" var="produto">
				<tr>
					<td>${produto.nome}</td>
					<td>${produto.descricao}</td>
					<td>${produto.preco}</td>
					<td><a href="<c:url value="/produtos/${produto.id}"/>">Editar</a></td>
					<td>
						<form action="<c:url value="/produtos/${produto.id}"/>"
							method="post">
							<button class="link" name="_method" value="DELETE">
								Remover</button>
						</form>
					</td>
					<td>
						<form action="<c:url value="/carrinho" />" method="POST">
							<input type="hidden" name="item.produto.id" value="${produto.id}" />
							<input class="qtde" name="item.quantidade" value="1" />
							<button type="submit">Comprar</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>