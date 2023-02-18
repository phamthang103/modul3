package com.example.user_manager.controller;

import com.example.user_manager.dao.UserDao;
import com.example.user_manager.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDAO;

    public void init() {
        userDAO = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteUser(request, response);
//                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    addForm(request, response);

                    break;
//                case "edit":
//                    updateUser(request, response);
//                    break;
                default:
                    listUser(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        List<User> userList = userDAO.findAll();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
private void addForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, SQLException, IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("user/create.jsp");
    try {
        dispatcher.forward(request,response);
    } catch (ServletException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
private void insertUser(HttpServletRequest request,HttpServletResponse response) throws IOException,SQLException,ServletException{
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String country = request.getParameter("country");
    User newUser = new User(name, email, country);
    userDAO.addUser(newUser);
    RequestDispatcher dispatcher=request.getRequestDispatcher("user/create.jsp");
    dispatcher.forward(request,response);
}
}
