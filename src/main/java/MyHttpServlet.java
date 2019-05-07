import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = { "/passGenerator" }, loadOnStartup = 1)
public class MyHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html>\n" +
                "<body>\n" +
                "<h2>Password Generator</h2>\n" +
                "<form method=\"POST\">\n" +
                "  <input type=\"text\" name=\"amountOfLetters\" placeholder=\"Type number of letters\" value=\"\">\n" +
                " <br><br>\n" +
                "  <button type=\"submit\">Generate Password</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        int amountOfLetters = Integer.parseInt(req.getParameter("amountOfLetters"));
        String password = passwordGenerator.generatePassword(amountOfLetters);

        resp.getWriter().write("<html>\n" +
                "<body>\n" +
                "<h3>Generated password:</h3>\n" +
                " <p>" + password +
                "</p>" +
                "</body>\n" +
                "</html>");
    }
}
