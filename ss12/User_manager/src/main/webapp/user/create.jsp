<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/14/2023
  Time: 2:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<h2>
    <a href="/users?action=users">List All User</a>
</h2>
<div align="center">
    <table border="1"cellpadding="5">
        <caption>Add New User</caption>
        <tr>
            <th>Name</th>
            <td><input type="text"name="name"id="name"size="45"></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><input type="text"name="email"id="email"size="45"></td>
        </tr>
        <tr>
            <th>Country</th>
            <td><input type="text"name="country"id="country"size="45"></td>
        </tr>
        <tr>

            <td colspan="2"><input type="submit"value="Save"></td>
        </tr>
    </table>
</div>
</body>
</html>
