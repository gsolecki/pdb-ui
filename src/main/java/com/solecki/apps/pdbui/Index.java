package com.solecki.apps.pdbui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/Index")
public class Index extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("""
                <html>
                <head>
                <meta charset="ISO-8859-1">
                <title>Eat More Cucumbers Restaurant</title>
                </head>
                <body>
                <h2>Eat More Cucumbers Restaurant Freshville</h2>
                 <form action = "Index" method = "POST" target = "">
                 <table>
                 <tr>
                 <td>Bill Amount: </td>\s
                 <td><input type = "text" id="billamount" name = "billamount"/></td>
                </tr>

                 <tr>
                 <td>Tax Rate: </td>\s
                 <td><input type = "text" id="taxrate" name = "taxrate"/> \s
                 </td>
                 </tr>
                 <tr>
                 <td></td>
                 <td>
                 <br> <input type = "submit" id="mybutton" value = "Calculate Final Bill" />
                  </td>
                  </tr>
                  </table>
                      </form>
                </body>
                </html>                        
                """);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            double billAmount = Double.parseDouble(request.getParameter("billamount"));
            Double taxRate = Double.parseDouble(request.getParameter("taxrate"));

            double finalBillAmount = BillCalculationHelper.calculateBillForCustomer(billAmount, taxRate);

            response.getWriter().write("<html><body><h1>" + "Initial Bill is: $" + billAmount + "</br>" + "Tax Rate is: " + taxRate + "%" + "</br>" + "Final Bill Amount is: $" + finalBillAmount + "</br>" + "</h1></body></html>");

        } catch (Exception ex) {
            response.getWriter().write("Unknown Error: " + ex.getMessage());
        }
    }
}
