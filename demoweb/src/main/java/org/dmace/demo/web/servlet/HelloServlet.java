package org.dmace.demo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/hello/hello.jsp").forward(request, response);

    }
}
