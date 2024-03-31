package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class TermProjectInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // No root configuration needed
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class}; // Specify the configuration class
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // Map DispatcherServlet to "/"
    }
}