package com.example;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie_example")
public class CookieServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Enumeration<String> names = req.getParameterNames();

        for(String param = names.nextElement(); names.hasMoreElements(); param = names.nextElement()) {
            res.addCookie(new Cookie(param, req.getParameter(param)));
        }
        req.getRequestDispatcher("cookie.jsp").forward(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Cookie[] cookies = req.getCookies();
        // Cookie cookie = cookies[0];
        // cookie.
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            cookies[i].setMaxAge(0);
        }

    }
    
}
