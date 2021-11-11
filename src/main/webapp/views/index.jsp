<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>${successMsg}</h3>
	<h3>${failMsg}</h3>

	<h2>Product Details</h2>

	<form:form action="saveProduct?productId=${product.productId}" method="POST" modelAttribute="product">

		<table>

			<%-- <tr>
				<td>Id:</td>
				<td><form:input path="productId" /></td>
			</tr> --%>

			<tr>
				<td>Name:</td>
				<td><form:input path="productName" /></td>
			</tr>

			<tr>
				<td>Description:</td>
				<td><form:input path="productDesc" /></td>
			</tr>

			<tr>
				<td>Price:</td>
				<td><form:input path="productPrice" /></td>
			</tr>

			<tr>

				<td><input type="Submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>

	<a href="viewAllProducts">Display All Products</a>
</body>
</html>