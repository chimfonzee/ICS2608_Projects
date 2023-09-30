package com.example.helper;

import java.util.Date;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute("date", new Date());
    }

    public void contextDestroyed(ServletContextEvent event) {
        // rarely used required for overriding
    }
}
