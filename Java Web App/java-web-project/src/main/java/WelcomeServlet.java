import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // System.out.println("welcome servlet");
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.print("<h1><strong>You are successfully logged out!</strong></h1>");
    // req.setAttribute("name", "Welcome_Garcia!");
    // req.getRequestDispatcher("index.jsp").include(req, resp);

    ServletConfig config = getServletConfig();
    String driver = config.getInitParameter("packages");
    System.out.print("Driver is: " + driver);
    
    
    // ServletContext context = req.getServletContext(); // getservletcontext returns string
    // String ctx = context.getInitParameter("contextConfigLocation");
    // System.out.println(ctx);

  }

}
