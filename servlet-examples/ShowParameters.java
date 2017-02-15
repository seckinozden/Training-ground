import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet(urlPatterns = { "/showParameters" })
public class ShowParameters extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4551018314107907266L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		showRequestParameters(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showRequestParameters(request, response);
	}

	void showRequestParameters(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Show Parameters</title></head><body>");

		out.println("</ul><p><form method=\"POST\" action=\"" + request.getRequestURI() + "\">"
				+ "Field 1 <input name=\"Field 1\" size=20><br>" + "Field 2 <input name=\"Field 2\" size=20><br>"
				+ "<br><input type=\"submit\" value=\"Submit\"></form>");

		if (request.getParameterMap().size() > 0) {
			out.println("<h1>Parameters</h1><ul>");
			Map<String, String[]> params = request.getParameterMap();
			for (String name : params.keySet()) {
				String[] values = params.get(name);
				out.println("<li>" + name + " = " + Arrays.asList(values));
			}
		}

		out.close();
	}
}