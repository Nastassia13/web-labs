package by.katsuba.lab5.filter;

import by.katsuba.lab5.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        User user = (User) httpRequest.getSession().getAttribute("user");
        String command = request.getParameter("command");
        if (user == null && command != null
                && !command.equals("login") && !command.equals("registration") && !command.equals("services")) {
            request.getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(request, response);
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
