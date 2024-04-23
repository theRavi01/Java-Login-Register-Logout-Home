import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Perform validation
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("register.html");
            return;
        }

        // Database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demolog","root","root");

            // Check if email already exists
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h3>Email already exists!</h3>");
                out.close();
                return;
            }

            // Insert user into database
            ps = con.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();

            con.close();
            response.sendRedirect("login.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
