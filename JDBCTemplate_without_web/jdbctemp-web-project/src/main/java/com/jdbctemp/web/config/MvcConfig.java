package com.jdbctemp.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
import com.jdbctemp.web.model.EmployeeDao;
 
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
    @Autowired
   private JdbcTemplate jdbcTemplate;
   
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
   }
   
   @Bean
   public EmployeeDao employeeDAO() {
      return new EmployeeDao(jdbcTemplate);
   }
}
