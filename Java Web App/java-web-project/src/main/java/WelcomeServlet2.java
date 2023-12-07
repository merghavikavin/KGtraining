import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1><strong>You are successfully logged out!</strong></h1>");

        // Set an attribute for the request
        req.setAttribute("name", "Welcome_Garcia!");

        // Get a request dispatcher for the target JSP (index.jsp)
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");

        // Forward the request and response to the target JSP
        dispatcher.forward(req, resp);

    }

}