package by.katsuba.lab5.listener;

import by.katsuba.lab5.dao.ServiceDao;
import by.katsuba.lab5.dao.SubscriberDao;
import by.katsuba.lab5.dao.UserDao;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StationServletContextListener implements ServletContextListener {
    @EJB
    private SubscriberDao subscriberDao;
    @EJB
    private ServiceDao serviceDao;
    @EJB
    private UserDao userDao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("subscriberDao", this.subscriberDao);
        context.setAttribute("serviceDao", this.serviceDao);
        context.setAttribute("userDao", this.userDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
