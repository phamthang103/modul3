<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/4/2023
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach khach hang - JSTL</title>
</head>
<body>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getBirthDay()}</td>
            <td>${customer.getAddress()}</td>
            <td><img style="width: 50px; height: 60px" src="${customer.getUrlImg()}"></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
