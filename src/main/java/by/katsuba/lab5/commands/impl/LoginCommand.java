package by.katsuba.lab5.commands.impl;

import by.katsuba.lab5.commands.Command;
import by.katsuba.lab5.dao.UserDao;
import by.katsuba.lab5.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {
    @Override
    public String getCommandName() {
        return "login";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        User user = findUser(request, context);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/view/menu.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Неверный логин или пароль!");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
    }

    private User findUser(HttpServletRequest request,  ServletContext context) {
        User user = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null) {
            UserDao dao = (UserDao) context.getAttribute("userDao");
            try {
                user = dao.readUser(login, password);
            } catch (Exception e) {
                user = null;
            }
        }
        return user;
    }
}