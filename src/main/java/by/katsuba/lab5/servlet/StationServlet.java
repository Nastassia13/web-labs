package by.katsuba.lab5.servlet;

import by.katsuba.lab5.commands.Command;
import by.katsuba.lab5.commands.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebServlet(name = "stationServlet", value = "/station")
public class StationServlet extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init() {
        Command[] tempCommands = {
                new MenuCommand(),
                new SubscriberServicesCommand(),
                new AccountCommand(),
                new ServicesCommand(),
                new PayBillCommand(),
                new LoginCommand(),
                new LogoutCommand(),
                new RegistrationCommand()};
        this.commands = Arrays.stream(tempCommands).collect(Collectors.toMap(Command::getCommandName, Function.identity()));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            saveCookies(request, response);
            commands.get("menu").doGet(request, response, this.getServletContext());
        } else if (commands.containsKey(command)) {
            commands.get(command).doGet(request, response, this.getServletContext());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            commands.get("menu").doPost(request, response, this.getServletContext());
        } else if (commands.containsKey(command)) {
            commands.get(command).doPost(request, response, this.getServletContext());
        }
    }

    private void saveCookies(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Cookie lastTime = new Cookie("lastTime", new Date(session.getLastAccessedTime()).toString());
        Cookie countVisits = new Cookie("countVisits", "1");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies).filter(c -> c.getName().equals("countVisits"))
                    .findAny()
                    .ifPresent(c -> {
                        int countVisitsPrev = Integer.parseInt(c.getValue());
                        countVisits.setValue(Integer.toString(++countVisitsPrev));
                    });
        }
        response.addCookie(lastTime);
        response.addCookie(countVisits);
    }
}
