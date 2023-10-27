package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ArithmeticException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sample_hidden")
public class HiddenRequestServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        Object hidden = req.getParameter("uname");
        if (hidden == null) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        out.write("<html>");
        out.write(hidden.toString());
        out.write("</html>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
    }
}
