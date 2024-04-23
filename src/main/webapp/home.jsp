<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="jakarta.servlet.http.Cookie"%>
   <%@ page import="jakarta.servlet.http.HttpServletRequest"%>
   <%@ page import="java.io.IOException"%>

<%
// Get the request object
HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();

// Get the cookies
Cookie[] cookies = request.getCookies();

// Check if cookies exist and if a cookie named "username" exists
boolean usernameCookieExists = false;
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
            usernameCookieExists = true;
            break;
        }
    }
}

// If "username" cookie doesn't exist, redirect to login page
if (!usernameCookieExists) {
    response.sendRedirect("login.html");
}
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Pages / Register</title>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <link href="https://fonts.gstatic.com" rel="preconnect" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
  </head>
<body>
    <main>
      <div class="container">
        <section
          class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4"
        >
          <div class="container">
            <div class="row justify-content-center">
              <div
                class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center"
              >
                <div class="card mb-3">
                  <div class="card-body">
                    <div class="pt-4 pb-2">
                      <h5 class="card-title text-center pb-0 fs-4">
                       !! Welcome to Home !!
                      </h5>
                      <h3 >
                          *Core Java
                        </h3>
                      <h3 >
                          *Servlet
                        </h3>
                      <h3 >
                          *MySQL Databse
                        </h3>
                      <h3 >
                          *JSP
                        </h3>
                        <h3 >
                          *JDBC
                        </h3>
                        <h3 >
                          *Cookies
                        </h3>
                        <h3 >
                          *Bootstrap {Front-Ent}
                        </h3>
                      <h3 class="small mb-0">
                          <a href="LogoutServlet">Logout Now</a>
                        </h3>
                    </div>

                   
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </main>
    <!-- End #main -->
  </body>
</html>