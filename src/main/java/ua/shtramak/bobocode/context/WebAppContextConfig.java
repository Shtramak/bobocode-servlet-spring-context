package ua.shtramak.bobocode.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppContextConfig implements WebApplicationInitializer {
    public static final String SRPING_APP_CONTEXT = "SRPING_APP_CONTEXT";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        var springContext = new AnnotationConfigApplicationContext(NameProvider.class);
        servletContext.setAttribute(SRPING_APP_CONTEXT, springContext);
    }
}
