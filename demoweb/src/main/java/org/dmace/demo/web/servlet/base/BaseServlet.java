package org.dmace.demo.web.servlet.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    public abstract void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException;

}
