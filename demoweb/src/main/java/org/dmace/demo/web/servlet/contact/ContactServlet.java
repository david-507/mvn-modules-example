package org.dmace.demo.web.servlet.contact;

import org.dmace.demo.model.Contact;
import org.dmace.demo.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet
public class ContactServlet extends BaseServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        // 1. Create the Bean
        Contact c = new Contact();
        c.setFirstname("John");
        c.setLastName("Doe");
        c.setComments("Created by servlet");
        c.setDob(LocalDate.now());
        c.setEmail("jdoe@gmail.com");
        c.setPhone("612321456");

        // 2. add bean into request attributes
        request.setAttribute("contact", c);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/contact/contact.jsp").forward(request, response);


    }

}
