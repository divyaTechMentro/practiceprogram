package mypack;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ExitServlet extends HttpServlet {

	public void doGet(
	HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("username");
		session.invalidate();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h3>"+name+", you have successfully exited.</h3>");
		out.println("<a href=index.html>try again</a>");
		out.close();
	}
}
