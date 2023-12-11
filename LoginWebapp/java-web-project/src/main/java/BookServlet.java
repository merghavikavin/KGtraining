import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 10.99f, 100));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee", 9.99f, 50));
        books.add(new Book(3, "1984", "George Orwell", 8.99f, 75));
        books.add(new Book(4, "Pride and Prejudice", "Jane Austen", 7.99f, 25));
        books.add(new Book(5, "The Catcher in the Rye", "J.D. Salinger", 6.99f, 150));

        // System.out.println(books);
        String json = new Gson().toJson(books);
        // System.out.println(json);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("post method");
       // doGet(req,resp);
       String requestData = req.getReader().lines().collect(Collectors.joining());
       System.out.println("Request data " + requestData); 
// Request data id=1&title=abc&author=xyz&price=1&qty=1
       Book nBook = new Gson().fromJson("{'id': 1,'title': 'The Great Gatsby','author': 'F. Scott Fitzgerald','price': 10.99,'qty': 100}", Book.class);
       System.out.println(nBook);
      // System.out.println(nBook.getId()+ " "+nBook.getTitle()+" "+nBook.getAuthor()+" "+nBook.getPrice()+" "+nBook.getQty());
    
    }
}
