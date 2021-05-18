package by.katsuba.lab5.commands.impl;

import by.katsuba.lab5.commands.Command;
import by.katsuba.lab5.dao.SubscriberDao;
import by.katsuba.lab5.entity.Subscriber;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountCommand implements Command {
    @Override
    public String getCommandName() {
        return "account";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext context)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/account.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        String idSubscriber = request.getParameter("idSubscriber");
        if (idSubscriber != null) {
            SubscriberDao dao = (SubscriberDao) context.getAttribute("subscriberDao");
            Subscriber subscriber = dao.readSubscriberById(Long.parseLong(idSubscriber));
            request.setAttribute("account", dao.readSubscribersSum(subscriber));
        }
        doGet(request, response, context);
    }
}
