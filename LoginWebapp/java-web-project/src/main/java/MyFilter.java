import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("username");
        String password = req.getParameter("userpass");

       // System.out.println("Received username: " + name); // Add this line for debugging
       // System.out.println("Received password: " + password); // Add this line for debugging

        //if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
           // out.print("Please enter a valid username and password");
        if (LoginDao.validate(name, password)) {
            HttpSession session = ((HttpServletRequest) req).getSession(); // Cast to HttpServletRequest to access the
                                                                           // session
            session.setAttribute("username", name);
            RequestDispatcher rd = req.getRequestDispatcher("/servlet2");
            rd.forward(req, resp);
        } else {
            out.print("Sorry, username or password error");
        }
    }

    public void destroy() {
    }
}