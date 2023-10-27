package com.example;

import java.io.IOException;
import java.lang.ArithmeticException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/app/handle_parameters")
public class MultipleRequestHandlerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String[] checkboxes = new String[3];
        String result = "";
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = req.getParameter("checkbox" + (i + 1));
            if (checkboxes[i] != null) {
                result = result + checkboxes[i];
            }
        }
        RequestDispatcher dispatcher;
        if (result == "")
            dispatcher = req.getRequestDispatcher("error.jsp");
        else {
            
            req.setAttribute("result", result);
            dispatcher = req.getRequestDispatcher("multiple.jsp");
        }
        dispatcher.forward(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // add your POST method code here
        try {
            // calculator code
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
