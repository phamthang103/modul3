package com.example.ung_dung_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/<%@ page contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\" %>\n" +
        "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "    <title>Calculator</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h2>Simple Calculator</h2>\n" +
        "<br/>\n" +
        "<form method=\"post\" action=\"/calculate\">\n" +
        "    <fieldset>\n" +
        "        <table>\n" +
        "            <tr>\n" +
        "                <td>Calculator</td>\n" +
        "                <td></td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td><label>First operand: </label></td>\n" +
        "                <td><input type=\"number\" name=\"firstOpera\" /></td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td>Operator:</td>\n" +
        "                <td>\n" +
        "                    <select name=\"operator\">\n" +
        "                        <option value=\"+\">Addition</option>\n" +
        "                        <option value=\"-\">Subtraction</option>\n" +
        "                        <option value=\"*\">Multiplication</option>\n" +
        "                        <option value=\"/\">Division</option>\n" +
        "                    </select>\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td><label>Second operand: </label></td>\n" +
        "                <td><input type=\"number\" name=\"secondOpera\" /></td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td></td>\n" +
        "                <td colspan=\"2\">\n" +
        "                    <input type = \"submit\" id = \"submit\" value=\"Calculate\"/>\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "        </table>\n" +
        "    </fieldset>\n" +
        "</form>\n" +
        "</body>\n" +
        "</html>")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("firstOpera"));
        float secondOperand = Float.parseFloat(request.getParameter("secondOpera"));
        char operator = request.getParameter("operator").charAt(0);
        double result = 0;
        if (!(secondOperand==0 && operator=='/')) {
            switch (operator) {
                case '+':
                    result = firstOperand + secondOperand;
                    break;
                case '-':
                    result = firstOperand - secondOperand;
                    break;
                case '*':
                    result = firstOperand * secondOperand;
                    break;
                case '/':
                    result = firstOperand / secondOperand;
                    break;
            }
        }

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");

        if (secondOperand == 0 && operator == '/') {
            writer.println("/by zero");
        } else {
            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        }

        writer.println("</html>");
    }
    }

