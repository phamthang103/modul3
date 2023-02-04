import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountCalculatoServlet", value = "/calculator")
public class DiscountCalculatoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getParameter("info");
        double price = Double.parseDouble(request.getParameter("price"));
        int percent = Integer.parseInt(request.getParameter("discountPercent"));

        double amount = price * percent * 0.01;
        double disPrice = price - amount;
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>" + "Product Description: " + info + ", List Price" + price + ", Discount Percent: " + percent + "</h3>");
        out.println("<h3>" + "Discount Amount: " + amount + "</h3>");
        out.println("<h3>" + "Discount Price: " + disPrice + "</h3>");
        out.println("</body></html>");
    }
}
