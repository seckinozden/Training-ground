import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
@WebServlet(urlPatterns={"/hello"})
public class HelloClient extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Hello Client";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}

	public void destroy() {
		// do nothing.
	}
}