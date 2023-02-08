package controller;

import model.SanPham;
import service.ISanPhamService;
import service.SanPhamService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = "/SanPham")
public class SanPhamServlet extends HttpServlet {
    private ISanPhamService sanPhamService=new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                listOfProduct(request, response);
                break;
        }
    }
    //HttpServletRequest
    private void listOfProduct(HttpServletRequest request,HttpServletResponse response){


        List<SanPham>sanPhams=sanPhamService.findAll();
        request.setAttribute("sanPhams",sanPhams);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/SanPham/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void viewProduce(HttpServletRequest request,HttpServletResponse response){

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":

                break;
            case "edit":

                break;
            case "delete":

                break;
            case "search":

                break;
            default:
listOfProduct(request,response);
                break;
        }
    }
    }

