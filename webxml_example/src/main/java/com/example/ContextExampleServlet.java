package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContextExampleServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ServletContext context = getServletContext();
        String example = context.getInitParameter("context_example");
        String date = context.getAttribute("date").toString();

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<h1>This is an example of ContextExampleServlet</h1>");
        out.println("<h2>context_example: " + example + "</h2>");
        out.println("<h2>date: " + date + "</h2>");
        out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // add your POST method code here
    }
}
