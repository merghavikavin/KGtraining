import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("password"));

        Enumeration<String> l = request.getParameterNames();
       // System.out.println(l);
        Map<String, String[]> map = request.getParameterMap();
        map.entrySet().stream()
                .flatMap(entry -> Arrays.stream(entry.getValue())
                        .map(value -> entry.getKey() + " = " + value))
                .forEach(System.out::println);
                
                ServletContext context = request.getServletContext(); //getservletcontext returns string
                String ctx = context.getInitParameter("contextConfigLocation");
                System.out.println(ctx);

    }

}