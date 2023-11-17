package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hidden_register")
public class HiddenRegisterServlet extends HttpServlet {
    private boolean checkEmpty(String param) {
        return param == null || param.equals("");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String uname = req.getParameter("uname");
        String pword = req.getParameter("pword");

        if (checkEmpty(uname) || checkEmpty(pword)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        req.setAttribute("uname1", uname);
        req.setAttribute("pword1", pword);
        req.getRequestDispatcher("/hidden_login.jsp").forward(req, res);
    }
}
