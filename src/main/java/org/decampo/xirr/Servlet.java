package org.decampo.xirr;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "")
public class Servlet extends HttpServlet {
    private final ObjectMapper objectMapperUtils = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try (BufferedReader reader = req.getReader(); PrintWriter writer = resp.getWriter()) {
            Transaction[] transactions;
            transactions = objectMapperUtils
                    .readValue(reader, Transaction[].class);
            double rate = new Xirr(transactions).xirr();
            writer.write(new BigDecimal(rate).toPlainString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}