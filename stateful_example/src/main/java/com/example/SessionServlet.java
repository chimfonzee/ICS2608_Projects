package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/manage_session")
public class SessionServlet extends HttpServlet {
    private boolean checkEmpty(String param) {
        return param == null || param.equals("");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("name");
        String value = req.getParameter("value");

        if (checkEmpty(name) || checkEmpty(value)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/session_login.jsp");
            return;
        }
        session.setAttribute(name, value);
        res.sendRedirect(req.getContextPath() + "/session.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("chosenAttribute");

        if (checkEmpty(name)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/session_login.jsp");
            return;
        }
        session.removeAttribute(name);
        res.sendRedirect(req.getContextPath() + "/session.jsp");
    }
}
