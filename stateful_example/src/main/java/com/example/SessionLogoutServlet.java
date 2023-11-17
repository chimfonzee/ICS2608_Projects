package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session_logout")
public class SessionLogoutServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        
        // double checking if logout is being called for no apparent reason
        if (session == null) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        session.invalidate();
        req.getRequestDispatcher("/session_login.jsp").forward(req, res);
    }
}
