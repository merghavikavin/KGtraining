import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(
    name = "WelcomeServlet",
    urlPatterns = {"/welcome1"}
)
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String driver = getServletContext().getInitParameter("dname");

        request.setAttribute("uname", uname);
        request.setAttribute("driver", driver);

        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }
}