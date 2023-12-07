package com.jdbctemp.web.config;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
 
// public class AppInitializer  implements WebApplicationInitializer{
 
//     @Override
//     public void onStartup(ServletContext servletContext) throws ServletException {
//         AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//       context.register(WebConfig.class);
//       servletContext.addListener(new ContextLoaderListener(context));
//       ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
//       dispatcher.setLoadOnStartup(1);
//       dispatcher.addMapping("/");
//     }
   
// }
 
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { WebConfig.class };
  }
 
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return null;
 
  }
 
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
 
  }
 
}