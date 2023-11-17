package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hidden_login")
public class HiddenLoginServlet extends HttpServlet {
    private boolean checkEmpty(String param) {
        return param == null || param.equals("");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // it is highly recommened to find an encryption method for this (middleware)
        String uname1 = req.getParameter("uname1");
        String pword1 = req.getParameter("pword1");
        String uname = req.getParameter("uname");
        String pword = req.getParameter("pword");

        // this is where you put your authentication
        if (checkEmpty(uname) || checkEmpty(pword) || checkEmpty(uname1) || checkEmpty(pword1))
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
        else if (uname1.equals(uname) && pword1.equals(pword)) 
            req.getRequestDispatcher("/hidden_success.jsp").forward(req, res);
        else
            req.getRequestDispatcher("/hidden_fail.jsp").forward(req, res);
    }
}
