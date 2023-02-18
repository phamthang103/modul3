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
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center"><a href="/list">List All Product</a></h1>
<div align="center">
    <form action="" method="post">
        <table border="1"cellpadding="5">
            <caption>All New Product</caption>
            <tr>
                <th>Product Id</th>
                <td>
                    <c:if test="${message!=null}">
                        <p style="color: red"><c:out value="${meassage}"></c:out></p>
                    </c:if>
                    <input type="text" name="id"size="45">
                </td>
            </tr>
            <tr>
                <th>Product Name</th>
                <td>
                    <input type="text" name="name"size="45" value="${customer.getProductName()}">
                </td>
            </tr>
            <tr>
                <th>Product Price</th>
                <td>
                    <input type="text" name="price"size="45"value="${customer.getProductPrice()}">
                </td>
            </tr>
            <tr>
                <th>Product Description</th>
                <td>
                    <input type="text" name="description"size="45"value="${customer.getProductDescription()}">
                </td>
            </tr>
            <tr>
                <th>Product Manufacture</th>
                <td>
                    <input type="text" name="manufacture"size="45"value="${customer.getProductManufacture()}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="Save">
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
