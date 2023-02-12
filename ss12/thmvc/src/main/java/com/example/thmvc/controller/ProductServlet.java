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
    private final ProductService productService = new ProductServiceImpI();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            case "search":
                showSearchForm(request,response);
                break;
            case "edit":
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        try {
            response.sendRedirect("/products");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> productList = productService.searchProductByName(name);
        RequestDispatcher dispatcher;
        if (productList.size() == 0) {
            request.setAttribute("message", "Khong tim thay");
        } else {
            request.setAttribute("products", productList);
        }
        dispatcher = request.getRequestDispatcher("/products/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productsName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDescription = request.getParameter("productDescription");
        String productManufacture = request.getParameter("productManufacture");
        Product product = new Product(id, productName, productPrice, productDescription, productManufacture);
        productService.updateProduct(id, product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 10000);
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDescription = request.getParameter("productDescription");
        String productManufacture = request.getParameter("productManufacture");

        Product product = new Product(id, productName, productPrice, productDescription, productManufacture);
        productService.addNewProduct(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        RequestDispatcher dispatcher;
        request.setAttribute("products", products);
        dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showSearchForm(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher dispatcher= request.getRequestDispatcher("/product/search.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showCreateForm(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher dispatcher=request.getRequestDispatcher("/product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/view.jsp");
        dispatcher.forward(request, response);
    }
}


