<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/16/2023
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="" />
<link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<html>
<head>
    <title>Doccument</title>
    <style>
        *{
            margin: 0;
            box-sizing: border-box;
            padding: 0;
            font-family: 'Roboto', sans-serif;
        }
        body{
            margin: 0;
            padding: 0;
        }
        .heading{
            display: flex;
            justify-content: space-between;
        }
        .heading .heading-logo{
            margin-left: 10%;
        }
        .heading .heading-logo img{
            width: 70px;
            height: 100%;
            object-fit: cover;
        }
        .heading-name{
            margin-right: 10%;
            margin-top: 20px;
        }
        .navbar-brand{
            margin-left: 5%;
        }
        .navbar-nav{
            display: flex;
            justify-content: space-around;
            width: 60%;
        }
        .container-full{
            min-width:100vw;
            margin: 0;
            display: flex;
            flex-direction: row;
            padding: 0;
        }
        .left-container{
            width: 20%;
            background-color: aquamarine;
            min-height: 100vh;
        }
        .main-container{
            width: 80%;
            min-height: 100vh;
        }

    </style>
</head>
<body>
<header class="heading">
    <div class="heading-logo"><img src="logo.png" alt="" srcset=""/></div>
    <div class="heading-name"><h3>Phạm Thắng</h3></div>
</header>
<div class="main-container">
    <div class="list-link" style="margin-bottom:20px ; margin-left: 10px;">
        <a class="btn  btn-success" href="/BenhNhanServlet?action=create" role="button">Add new benh nhan</a>
        <a class="btn btn-info" href="#" role="button">Do some thing</a>

    </div>
    <table class="table table-striped" style="margin-top:20px;" >
        <thead>
        <tr>
            <th scope="col">Ma bệnh án</th>
            <th scope="col">Mã bệnh nhân</th>
            <th scope="col">Tên bệnh nhân</th>
            <th scope="col">Ngày nhập viện</th>
            <th scope="col">Ngày ra viện</th>
            <th>Lí do</th>
            <th > Action</th>
            <th > Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${benhNhanList}" var="benhNhan">
            <tr>
                <td>${benhNhan.maBenhAn}</td>
                <td>${benhNhan.maBenhNhan}</td>
                <td>${benhNhan.tenBenhNhan}</td>
                <td> ${benhNhan.ngayNhapVien}</td>
                <td>${benhNhan.ngayRaVien}</td>
                <td>${benhNhan.liDo}</td>
                <td><a type="button" class="btn btn-info" href="/BenhNhanServlet?action=edit&maBenhAn=${benhNhan.maBenhAn}&maBenhNhan=${benhNhan.maBenhNhan}">Edit</a></td>
                <td><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-product = "${benhNhan.maBenhAn}" data-bs-maBenhNhan = "${benhNhan.maBenhNhan}">
                    Delete
                </button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</div>
</body>
</html>
