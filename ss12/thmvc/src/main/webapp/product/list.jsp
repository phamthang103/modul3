<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/12/2023
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Manufacture</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${products}" var="product">
<tr>
    <td>${product.getId()}</td>
    <td>${product.productName}</td>
    <td>${product.productPrice}</td>
    <td>${product.productDescription}</td>
    <td>${product.productNanufacture}</td>
    <td><a href="/products?action=edit&id=${product.getId}">Edit</a></td>
    <td><a href="/products?action=delete&id=${product.getId}">Delete</a></td>
</tr>
    </c:forEach>
    <tr>
        <a href="products?action=search">Search </a>
    </tr>
</table>
</body>
</html>
