<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/13/2023
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Manager</title>
    <style>
        .table{
            background:#1b1e21;
        }
    </style>
</head>
<body class="table">
<h1 style="text-align: center">Product </h1>
<h2 style="text-align: center">
    <a href="create.jsp">Add New Product</a>
    <a href="list.jsp">List All Product</a>
</h2>
<div style="text-align: center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Manufacture</td>
            <td>Action</td>

        </tr>
        <c:forEach var="products" items="${productList}">
            <tr>
                <td><c:out value="${products.getId()}"></c:out></td>
                <td><c:out value="${products.getProductName()}"></c:out></td>
                <td><c:out value="${products.getProductPrice ()}"></c:out></td>
                <td><c:out value="${products.getProductDescription ()}"></c:out></td>
                <td><c:out value="${products.getProductManufacture()}"></c:out></td>
                <td>
                    <a href="edit?id=<c:out value='${products.getId()}'/>"> Edit</a>
                    <a href="delete?id=<c:out value='${products.getId()}'/>"> Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
