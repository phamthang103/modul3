package com.example.thmvc.controller;

import com.example.thmvc.model.Product;
import com.example.thmvc.service.ProductService;
import com.example.thmvc.service.ProductServiceImpI;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService=new ProductServiceImpI();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("action");
if (action==null){
    action="";
}
switch (action){
    case "create":
        showCreateProduct(request,response);
        break;
    case "edit":
        break;
    case "delete":
        deleteProduct(request,response);
        break;
    case "view":
        break;
    case "search":
        break;
    default:
        listProduct(request,response);
        break;
}
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                creatProduct(request,response);
                break;
            case "edit":
                showEditProduct(request,response);
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                listProduct(request,response);
                break;
        }
    }
    private void listProduct(HttpServletRequest request,HttpServletResponse response){
        List<Product>productList=productService.findAll();
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteProduct(HttpServletRequest request,HttpServletResponse response){
        int idProduct= Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(idProduct);
//        RequestDispatcher dispatcher=request.getRequestDispatcher("product/list.jsp");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            response.sendRedirect("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showCreateProduct(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher dispatcher= request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void creatProduct(HttpServletRequest request,HttpServletResponse response){
        int id=Integer.parseInt(request.getParameter("id"));
       Product checkProduct=productService.findProductById(id);
       if (checkProduct==null){
           String name=request.getParameter("name");
           Double price=Double.parseDouble(request.getParameter("price"));
           String description=request.getParameter("description") ;
           String manufacture=request.getParameter("manufacture");
           Product product=new Product(id,name,price,description,manufacture);
           productService.addNewProduct(product);
           try {
               response.sendRedirect("/");
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }else {
           String measage="This ID already exit";
           String name=request.getParameter("name");
           Double price=Double.parseDouble(request.getParameter("price"));
           String description=request.getParameter("description") ;
           String manufacture=request.getParameter("manufacture");
           Product products=new Product(id,name,price,description,manufacture);
           request.setAttribute("measage",measage);
           request.setAttribute("product",products);
           RequestDispatcher dispatcher=request.getRequestDispatcher("product/create.jsp");
           try {
               dispatcher.forward(request,response);
           } catch (ServletException e) {
               throw new RuntimeException(e);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

       }

    }
    private void showEditProduct(HttpServletRequest request,HttpServletResponse response){
        int id=Integer.parseInt(request.getParameter("id"));
        Product products=productService.findProductById(id);
        request.setAttribute("products",products);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
