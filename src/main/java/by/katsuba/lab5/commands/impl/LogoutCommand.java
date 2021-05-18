package by.katsuba.lab5.commands.impl;

import by.katsuba.lab5.commands.Command;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command {
    @Override
    public String getCommandName() {
        return "logout";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        request.getRequestDispatcher("/WEB-INF/view/menu.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        doGet(request, response, context);
    }
}