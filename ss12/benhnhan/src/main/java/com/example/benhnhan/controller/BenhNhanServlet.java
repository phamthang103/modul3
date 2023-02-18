package com.example.benhnhan.controller;

import com.example.benhnhan.model.BenhNhan;
import com.example.benhnhan.service.BenhNhanService;
import com.example.benhnhan.service.IBenhNhanService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BenhNhanServlet", value = "/benhnhan")
public class BenhNhanServlet extends HttpServlet {
    IBenhNhanService benhNhanService=new BenhNhanService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            default:
                showList(request,response);
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
//                create(request, request);
                break;
            case "edit":
                doEdit(request,response);
                break;

        }
    }
    private void showCreate(HttpServletRequest request,HttpServletResponse response)throws IOException{
        response.sendRedirect("/benhnhan/create.jsp");
    }
    private void showList(HttpServletRequest request,HttpServletResponse response){
        List<BenhNhan>benhNhanList=benhNhanService.getAll();
        request.setAttribute("benhNhanList",benhNhanList);
        try {
            request.getRequestDispatcher("/benhnhan/list.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showEdit(HttpServletRequest request,HttpServletResponse response){
        String maBenhAn=request.getParameter("maBenhAn");
        String maBenhNhan=request.getParameter("maBenhNhan");
        BenhNhan benhNhan=benhNhanService.findByMaBenhNhan(maBenhNhan,maBenhAn);
        request.setAttribute("benhNhan",benhNhan);
        try {
            request.getRequestDispatcher("/benhnhan/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showDelete(HttpServletRequest request,HttpServletResponse response){
        String maBenhNhan = request.getParameter("maBenhNhan");
        String maBenhAn = request.getParameter("maBenhAn");
        benhNhanService.deleteByMaBenhNhan(maBenhNhan,maBenhAn);
        try {
            response.sendRedirect("/BenhNhanServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maBenhAn = request.getParameter("maBenhAn");
        String maBenhNhan = request.getParameter("maBenhNhan");
        String tenBenhNhan = request.getParameter("tenBenhNhan");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String liDo = request.getParameter("liDo");
        BenhNhan benhNhan = new BenhNhan(maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,liDo,maBenhAn);
        benhNhanService.updateBenhNhan(benhNhan);
        response.sendRedirect("/BenhNhanServlet");
}}

