package ua.shtramak.bobocode.context;


import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/name")
public class NameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var servletContext = req.getServletContext();
        var springContext = (ApplicationContext) servletContext.getAttribute(WebAppContextConfig.SRPING_APP_CONTEXT);
        var nameProvider = springContext.getBean(NameProvider.class);
        var writer = resp.getWriter();
        writer.println(nameProvider.getName());
    }
}
