<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/8/2023
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach khach hang</title>
    <style>
        tr, td,th{
            border-bottom: darkgrey solid 1px;
        }
        tr,th, td{
            text-align: left;
            padding: 30px;
            border-bottom-style: dashed;
        }
        table{
            width: 100%;
        }
    </style>
</head>
<body>
<div>
    <form>
        <div style="width: 50%">
            <h3 style="text-align: center; width: 100%">Danh sách khách hàng</h3>
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
        </div>
    </form>
</div>
</body>
</html>
