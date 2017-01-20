<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>


	<div class="container">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Products</h3>
			</div>
			<div class="panel-body">
				<table class="table" width="100%">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Price</th>
						<th>Category</th>
						<th>Image</th>

					</tr>
					<c:forEach var="product" items="${products}">
						<tr>
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.price}</td>
							<td>${product.category}</td>
							<td>${product.imageUrl}</td>

						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</div>

</body>
</html>