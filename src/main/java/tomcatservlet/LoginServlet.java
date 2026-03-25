package tomcatservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<form method='post' action='login'>");
        out.println("Username: <input type='text' name='username'/><br>");
        out.println("Password: <input type='password' name='password'/><br>");
        out.println("<input type='submit' value='Login'/>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "admin123".equals(password)) {
            out.println("<h2>Login Successful</h2>");
        } else {
            out.println("<h2>Invalid Credentials</h2>");
        }
    }
}