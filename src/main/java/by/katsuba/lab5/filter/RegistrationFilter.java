package by.katsuba.lab5.filter;

import by.katsuba.lab5.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RegistrationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String command = request.getParameter("command");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (command == null || !command.equals("registration") || !httpRequest.getMethod().equalsIgnoreCase("post")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (!checkParameters(request)) {
            request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean checkParameters(ServletRequest request) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || login.isEmpty()) {
            request.setAttribute("error", "Введите логин!");
            return false;
        }
        UserDao dao = (UserDao) request.getServletContext().getAttribute("userDao");
        if (dao.readUserByLogin(login)) {
            request.setAttribute("error", "Логин уже существует!");
            return false;
        }
        if (password == null || password.isEmpty()) {
            request.setAttribute("error", "Введите пароль!");
            return false;
        }
        return true;
    }

    @Override
    public void destroy() {

    }
}
