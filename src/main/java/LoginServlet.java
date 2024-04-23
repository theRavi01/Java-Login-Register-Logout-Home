import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demolog", "root", "root");

            // Validate user
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // User authenticated
            	Cookie loginCookie = new Cookie("username",email);
            	loginCookie.setMaxAge(30*30);
            	response.addCookie(loginCookie);
                response.sendRedirect("home.jsp");
                
            } else {
            	PrintWriter out = response.getWriter();
                response.sendRedirect("login.html");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
