<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container mt-3">
<div class="row">
<div class="col-md-12">
<h1 class="text-center mb-3">Welcome to Product App</h1>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
   <!--    <th label for="sort" scope="col">Sort By
      <div>
    <select id="sort">
        <option value="Id">Id</option>
        <option value="Price" selected="selected">Price</option>
        <option value="Name">Name</option>
    </select> -->
</div>
</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${products }" var="p">
    <tr>
      <th scope="row">${p.id }</th>
      <td>${p.name }</td>
      <td>${p.description }</td>
      <td class="font-weight-bold">&#x20B9; ${p.price }</td>
      <td>
      <a class="text-danger" href="deleteProduct/${p.id }">Delete</a><br>
      <a class="text-danger" href="editProduct/${p.id }">Edit</a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<div class="container text-center">
<a href="addProduct" class="btn btn-outline-success">Add Product</a>
</div>


</div>

</div>
</div>
<!-- <script>
$(document).ready(function () {
    $('#sort').change(function () {
        var val = document.getElementById("sort");
        /* alert("You selected " + val.options[val.selectedIndex].value); */
	console.log(val);
	const d={
			value:val
	}
	$.ajax({
		url:"sortBy",
		data:d,
		success:function (data,textStatus,jqXHR){
            console.log("success");
            window.location="home";
        },
        error:function (jqXHR,textStatus,errorThrown) {
            console.log("error");

        }
	})
	
});
});


</script> -->

</body>
</html>
