package controller;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getServletPath();
switch (action){
    case "/new":
        break;
    case "/delete":
        break;
    case "/edit":
        break;
    default:
        listCustomer(request,response);
        break;

}
    }
    private void listCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Customer>customerList= CustomerDao.getAllCus();
        request.setAttribute("listCustomer",customerList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("customer/index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
