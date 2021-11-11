<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
	function confirmDelete() {
		return confirm("Are you Sure,You want to delete?");
	}
</script>

</head>
<body>

	<a href="loadProduct">+ Add New Product</a>

	<h2>Display All Products</h2>

	<table border="1">

		<tr>

			<!-- <td>Id</td> -->
			<td>Name</td>
			<td>Description</td>
			<td>Price</td>
			<td>Actions</td>
		</tr>

		<c:forEach items="${product}" var="p">

			<tr>
				<%-- <td>${p.productId}</td> --%>
				<td>${p.productName}</td>
				<td>${p.productDesc}</td>
				<td>${p.productPrice}</td>
				<td><a href="updateProduct?pid=${p.productId}">Edit</a>
					&nbsp;&nbsp; <a href="deleteProduct?pid=${p.productId}"
					onclick="return confirmDelete()">Delete</a></td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>