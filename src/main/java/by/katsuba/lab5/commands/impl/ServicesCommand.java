package by.katsuba.lab5.commands.impl;

import by.katsuba.lab5.commands.Command;
import by.katsuba.lab5.dao.ServiceDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServicesCommand implements Command {
    @Override
    public String getCommandName() {
        return "services";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext context)
            throws ServletException, IOException {
        ServiceDao dao = (ServiceDao) context.getAttribute("serviceDao");
        request.setAttribute("services", dao.readServices());
        request.getRequestDispatcher("/WEB-INF/view/services.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        doGet(request, response, context);
    }
}
