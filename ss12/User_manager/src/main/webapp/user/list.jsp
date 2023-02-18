<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/5/2022
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,500;0,700;0,900;1,300;1,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/benhNhan/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/benhNhan/style/sidebar.css">
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
    <title>Document</title>
</head>
<body>
<header class="heading">
    <div class="heading-logo"><img src="/benhNhan/image/logo.png" alt="" srcset=""/></div>
    <div class="heading-name"><h3>NGÔ HOÀNG NHẬN</h3></div>
</header>
<nav class="navbar navbar-expand-lg " style="background-color: #e3f2fd; display: flex; justify-content: space-between;"  >
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">Navbar</a>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03" style="width: 60%;">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" >Bla Bla</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ProductServlet?action=createCate">Demo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">Disabled</a>
                </li>
            </ul>
            <form class="d-flex" method="post" role="search" action="/ProductServlet">
                <input type="hidden" name="action" value="search">
                <input name ="productName"class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container-full">
    <div class="left-container" style="background-color: #0a1d31">
        <div class="layout has-sidebar fixed-sidebar fixed-header" style="width:100%">
            <aside id="sidebar" class="sidebar break-point-lg has-bg-image">
                <div class="image-wrapper">
                    <img src="https://user-images.githubusercontent.com/25878302/144499035-2911184c-76d3-4611-86e7-bc4e8ff84ff5.jpg" alt="sidebar background" />
                </div>
                <div class="sidebar-layout">
                    <div class="sidebar-header">
          <span style="
                  text-transform: uppercase;
                  font-size: 15px;
                  letter-spacing: 3px;
                  font-weight: bold;
                ">Pro Sidebar</span>
                    </div>
                    <div class="sidebar-content">
                        <nav class="menu open-current-submenu">
                            <ul>
                                <li class="menu-item sub-menu">
                                    <a href="#">
                  <span class="menu-icon">
                    <i class="ri-vip-diamond-fill"></i>
                  </span>
                                        <span class="menu-title">Components</span>
                                        <span class="menu-suffix">&#x1F525;</span>
                                    </a>
                                    <div class="sub-menu-list">
                                        <ul>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Grid</span>
                                                </a>
                                            </li>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Layout</span>
                                                </a>
                                            </li>
                                            <li class="menu-item sub-menu">
                                                <a href="#">
                                                    <span class="menu-title">Forms</span>
                                                </a>
                                                <div class="sub-menu-list">
                                                    <ul>
                                                        <li class="menu-item">
                                                            <a href="#">
                                                                <span class="menu-title">Input</span>
                                                            </a>
                                                        </li>
                                                        <li class="menu-item">
                                                            <a href="#">
                                                                <span class="menu-title">Select</span>
                                                            </a>
                                                        </li>
                                                        <li class="menu-item sub-menu">
                                                            <a href="#">
                                                                <span class="menu-title">More</span>
                                                            </a>
                                                            <div class="sub-menu-list">
                                                                <ul>
                                                                    <li class="menu-item">
                                                                        <a href="#">
                                                                            <span class="menu-title">CheckBox</span>
                                                                        </a>
                                                                    </li>
                                                                    <li class="menu-item">
                                                                        <a href="#">
                                                                            <span class="menu-title">Radio</span>
                                                                        </a>
                                                                    </li>
                                                                    <li class="menu-item sub-menu">
                                                                        <a href="#">
                                                                            <span class="menu-title">Want more ?</span>
                                                                            <span class="menu-suffix">&#x1F914;</span>
                                                                        </a>
                                                                        <div class="sub-menu-list">
                                                                            <ul>
                                                                                <li class="menu-item">
                                                                                    <a href="#">
                                                                                        <span class="menu-prefix">&#127881;</span>
                                                                                        <span class="menu-title">You made it </span>
                                                                                    </a>
                                                                                </li>
                                                                            </ul>
                                                                        </div>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu-item sub-menu">
                                    <a href="#">
                  <span class="menu-icon">
                    <i class="ri-bar-chart-2-fill"></i>
                  </span>
                                        <span class="menu-title">Charts</span>
                                    </a>
                                    <div class="sub-menu-list">
                                        <ul>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Pie chart</span>
                                                </a>
                                            </li>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Line chart</span>
                                                </a>
                                            </li>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Bar chart</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu-item sub-menu">
                                    <a href="#">
                  <span class="menu-icon">
                    <i class="ri-shopping-cart-fill"></i>
                  </span>
                                        <span class="menu-title">E-commerce</span>
                                    </a>
                                    <div class="sub-menu-list">
                                        <ul>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Products</span>
                                                </a>
                                            </li>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Orders</span>
                                                </a>
                                            </li>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">credit card</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu-item sub-menu">
                                    <a href="#">
                  <span class="menu-icon">
                    <i class="ri-global-fill"></i>
                  </span>
                                        <span class="menu-title">Maps</span>
                                    </a>
                                    <div class="sub-menu-list">
                                        <ul>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Google maps</span>
                                                </a>
                                            </li>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Open street map</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu-item sub-menu">
                                    <a href="#">
                  <span class="menu-icon">
                    <i class="ri-brush-3-fill"></i>
                  </span>
                                        <span class="menu-title">Theme</span>
                                    </a>
                                    <div class="sub-menu-list">
                                        <ul>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Dark</span>
                                                </a>
                                            </li>
                                            <li class="menu-item">
                                                <a href="#">
                                                    <span class="menu-title">Light</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu-item">
                                    <a href="#">
                  <span class="menu-icon">
                    <i class="ri-book-2-fill"></i>
                  </span>
                                        <span class="menu-title">Documentation</span>
                                    </a>
                                </li>
                                <li class="menu-item">
                                    <a href="#">
                  <span class="menu-icon">
                    <i class="ri-calendar-fill"></i>
                  </span>
                                        <span class="menu-title">Calendar</span>
                                    </a>
                                </li>
                                <li class="menu-item">
                                    <a href="#">
                  <span class="menu-icon">
                    <i class="ri-service-fill"></i>
                  </span>
                                        <span class="menu-title">Examples</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <div class="sidebar-footer"><span>Sidebar footer</span></div>
                </div>
            </aside>


        </div>
    </div>
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

<%--<a type="button" class="btn btn-danger" href="/ProductServlet?action=delete&productName=${product.nameProduct}">Delete</a>--%>
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Confirm delete
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <a href="#" id="deleteButton">
                    <button type="button" class="btn btn-primary">Delete</button>
                </a>

            </div>
        </div>
    </div>
</div>
<footer class="text-center text-lg-start bg-dark text-muted">
    <!-- Section: Social media -->
    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <!-- Left -->
        <div class="me-5 d-none d-lg-block" style="margin-left:40%">
            <span>Get connected with us on social networks:</span>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-twitter"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-google"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-instagram"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-linkedin"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-github"></i>
            </a>
        </div>
        <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3"></i>Company name
                    </h6>
                    <p>
                        Here you can use rows and columns to organize your footer content. Lorem ipsum
                        dolor sit amet, consectetur adipisicing elit.
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Products
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Angular</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">React</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Vue</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Laravel</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Useful links
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Pricing</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Settings</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Orders</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Help</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                    <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                    <p>
                        <i class="fas fa-envelope me-3"></i>
                        info@example.com
                    </p>
                    <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                    <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->


    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        © 2021 Copyright:
        <a class="text-reset fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
</footer>
<script src="benhNhan/bootstrap/bootstrap.bundle.min.js"></script>
<script>
    const exampleModal = document.getElementById("exampleModal");
    exampleModal.addEventListener('show.bs.modal', event => {
        const button = event.relatedTarget;
        const studentId = button.getAttribute('data-bs-product');
        const maBenhNhan = button.getAttribute('data-bs-maBenhNhan');
        document.getElementById('deleteButton').href = "/BenhNhanServlet?action=delete&maBenhAn=" +studentId+"&maBenhNhan="+maBenhNhan ;
    })
</script>
</body>
</html>