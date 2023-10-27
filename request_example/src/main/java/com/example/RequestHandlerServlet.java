package com.example;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/handle")
public class RequestHandlerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String exampleString = req.getParameter("exampleString");
        RequestDispatcher dispatcher;
        if (exampleString.equals(null))
            dispatcher = req.getRequestDispatcher("/error.jsp");
        else
            dispatcher = req.getRequestDispatcher("/success.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // add your POST method code here
    }
}
