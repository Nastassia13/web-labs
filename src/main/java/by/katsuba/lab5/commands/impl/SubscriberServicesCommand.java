package by.katsuba.lab5.commands.impl;

import by.katsuba.lab5.commands.Command;
import by.katsuba.lab5.dao.ServiceDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubscriberServicesCommand implements Command {
    @Override
    public String getCommandName() {
        return "subscriberServices";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext context)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/subscriberServices.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        String idSubscriber = request.getParameter("idSubscriber");
        if (idSubscriber != null) {
            ServiceDao dao = (ServiceDao) context.getAttribute("serviceDao");
            request.setAttribute("subscriberServices", dao.readServiceBySubscriber(Long.parseLong(idSubscriber)));
        }
        doGet(request, response, context);
    }
}
