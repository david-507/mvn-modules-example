package org.dmace.demo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding( "UTF-8" );
        PrintWriter out = null;

        try {
            out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\" />");
            out.println("<title>Test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Ceci est une page générée depuis une servlet.</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            if(out!=null) {
                out.flush();
                out.close();
            }
        }
    }

}
