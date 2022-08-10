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
        // empty
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            double billAmount = Double.parseDouble(request.getParameter("billamount"));
            Double taxRate = Double.parseDouble(request.getParameter("taxrate"));

            double finalBillAmount = BillCalculationHelper.calculateBillForCustomer(billAmount, taxRate);

            String lipton = """
                    
                    """;

            response.getWriter().write("""
                            """

                    "<html><body><h1>"
                    + "Initial Bill is: $" + billAmount + "</br>"
                    + "Tax Rate is: " + taxRate + "%" + "</br>"
                    + "Final Bill Amount is: $" + finalBillAmount + "</br>"
                    + "</h1></body></html>");

        } catch (Exception ex) {
            response.getWriter().write("Unknown Error: " + ex.getMessage());
        }
    }
}
