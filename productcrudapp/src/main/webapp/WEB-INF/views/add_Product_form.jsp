<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-3">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">Fill The Product Details</h1>
<form action="handle-product" method="post">
<div class="form-group">
<label for="name">Product Name</label><input type="text"
class="form-control" id="name" name="name" 
placeholder="Enter the Product Name here">
</div>
<div class="form-group">
<label for="description">Product Description</label><textarea
class="form-control" id="description" name="description" 
placeholder="Enter the Product Description here"></textarea>
</div>
<div class="form-group">
<label for="price">Product price</label><input type="text"
class="form-control" id="price" name="price" 
placeholder="Enter the Product price here">
</div>
<div class="container text-center">
<a href="${pageContext.request.contextPath }/"
class="btn btn-outline-danger">Back</a>
<button type="submit" class="btn btn-primary">Add</button>
</div>
</form>
</div>


</div>
</div>
</body>
</html>