package by.katsuba.lab5.commands;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    String getCommandName();

    void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext context)
            throws ServletException, IOException;

    void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext context)
            throws ServletException, IOException;
}
