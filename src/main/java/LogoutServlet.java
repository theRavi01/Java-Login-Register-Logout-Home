

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
        	for (Cookie cookie : cookies) {
        		if(cookie.getName().equals("username")) {
        			cookie.setMaxAge(0);
        			response.addCookie(cookie);
        			response.addCookie(cookie);
        			request.getSession().invalidate();
        		}
        	}
        }
        response.sendRedirect("login.html");
    }
}
