import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = { "/showCookies" })
public class CookieCutter extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletContext context = getServletContext();
		context.setAttribute("seckin", new Integer(5));
		int seckin = (int) context.getAttribute("seckin");

		if (request.getParameter("setcookie") != null) {
			Cookie cookie = new Cookie("seckin", Integer.toString(seckin));
			cookie.setMaxAge(30);
			response.addCookie(cookie);
			out.println("<html><body><h1>Cookie Set...</h1>");
		} else {
			out.println("<html><body>");
			Cookie[] cookies = request.getCookies();
			if (cookies==null || cookies.length == 0 ) {
				out.println("<h1>No cookies found...</h1>");
			} else {
				for (int i = 0; i < cookies.length; i++)
					out.print(
							"<h1>Name: " + cookies[i].getName() + "<br>" + "Value: " + cookies[i].getValue() + "</h1>");
			}
			out.println("<p><a href=\"" + request.getRequestURI() + "?setcookie=true\">"
					+ "Reset the Learning Java cookie.</a>");
		}
		out.println("</body></html>");
	}
}