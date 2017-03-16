import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import java.util.concurrent.*;

@WebServlet(urlPatterns = { "/bgwait" }, asyncSupported = true)
public class BackgroundWaitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3485585120019198692L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext asyncContext = request.startAsync();
		String browserName = (String) request.getParameter("browser");
		System.out.println("Request is about to send to the executor for : " + browserName + " time : " + new Date(System.currentTimeMillis()).toString());
		ScheduledExecutorService executor = (ScheduledExecutorService) request.getServletContext()
				.getAttribute("BackgroundWaitExecutor");
		executor.schedule(new RespondLaterJob(asyncContext), 5, TimeUnit.SECONDS);
	}
}

class RespondLaterJob implements Runnable {
	private AsyncContext asyncContext;

	RespondLaterJob(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void run() {
		try {
			ServletResponse response = asyncContext.getResponse();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String browserName = (String) asyncContext.getRequest().getParameter("browser");
			System.out.println("Executing request for "+ browserName + " time : " + new Date(System.currentTimeMillis()).toString());
			out.println("<html><body><h1>WaitServlet Response for " + browserName + " </h1></body></html>");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		asyncContext.complete();
	}
}