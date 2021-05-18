package by.katsuba.lab5.commands.impl;

import by.katsuba.lab5.commands.Command;
import by.katsuba.lab5.dao.UserDao;
import by.katsuba.lab5.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
    @Override
    public String getCommandName() {
        return "registration";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        saveUser(request, context);
        request.getRequestDispatcher("/WEB-INF/view/menu.jsp").forward(request, response);
    }

    private void saveUser(HttpServletRequest request, ServletContext context) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User(login, password, "client");
        UserDao dao = (UserDao) context.getAttribute("userDao");
        dao.insertUser(user);
        request.getSession().setAttribute("user", user);
    }
}