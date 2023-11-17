package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/manage_cookies")
public class CookieServlet extends HttpServlet {
    private boolean checkEmpty(String param) {
        return param == null || param.equals("");
    }

    private Cookie getCookie(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(name))
                    return cookies[i];
            }
        }
        return null;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("name");
        String value = req.getParameter("value");

        if (checkEmpty(name) || checkEmpty(value)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(-1);
        res.addCookie(cookie);
        res.sendRedirect(req.getContextPath() + "/cookies.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String chosenCookie = req.getParameter("chosenCookie");

        if (checkEmpty(chosenCookie)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Cookie cookie = getCookie(req, chosenCookie);
        cookie.setValue(null);
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        res.sendRedirect(req.getContextPath() + "/cookies.jsp");
    }
}
