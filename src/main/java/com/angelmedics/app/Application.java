package com.angelmedics.app;

import java.util.ArrayList;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.angelmedics.mvc.KukaFilter;

@EnableAutoConfiguration  
@ComponentScan("com.angelmedics")  
@EntityScan("com.angelmedics.domain")  
@EnableJpaRepositories("com.angelmedics.repository")  
@EnableTransactionManagement
@EnableSpringDataWebSupport

//@EnableJpaAuditing 
public class Application extends SpringBootServletInitializer {

    @Override 
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
       
    	SpringApplication.run(Application.class, args);

    }
    
    // Replaces the need for web.xml
    @Bean
    public ServletRegistrationBean cxfServletRegistrationBean(ApplicationContext context) {
        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
    }
    
    @Bean
    public FilterRegistrationBean kukaFilterRegistrationBean(ApplicationContext context) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new KukaFilter());
        ArrayList<String> list=new ArrayList<String>();
        list.add("/report/*");
        list.add("/kukaws/*");
        filterRegistrationBean.setUrlPatterns(list);
        return filterRegistrationBean;
    }
}