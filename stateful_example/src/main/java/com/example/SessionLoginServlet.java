package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session_login")
public class SessionLoginServlet extends HttpServlet {
    private boolean checkEmpty(String param) {
        return param == null || param.equals("");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String uname = req.getParameter("uname");
        String pword = req.getParameter("pword");

        // this is where you put your authentication
        if (checkEmpty(uname) || checkEmpty(pword)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("uname", uname);
        req.getRequestDispatcher("/session.jsp").forward(req, res);
    }
}
