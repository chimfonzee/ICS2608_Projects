package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigExampleServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ServletConfig config = getServletConfig();
        String example = config.getInitParameter("config_example");
        String anotherExample = config.getInitParameter("another_config_example");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<h1>This is an example of ConfigExampleServlet</h1>");
        out.println("<h2>config_example: " + example + "</h2>");
        out.println("<h2>another_config_example: " + anotherExample + "</h2>");
        out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // add your POST method code here
    }
}
