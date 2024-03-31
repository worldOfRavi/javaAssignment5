package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring.controller","com.spring.dao","com.spring.beans"})
public class MvcConfig implements WebMvcConfigurer{
	
	   @Bean
	    public InternalResourceViewResolver viewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	   
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/css/**")
	                .addResourceLocations("/css/");
	        registry.addResourceHandler("/js/**")
	                .addResourceLocations("/js/");
	        registry.addResourceHandler("/images/**")
	                .addResourceLocations("/images/");
	    }
}
