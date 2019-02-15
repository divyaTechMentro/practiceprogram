package mypack;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {
	
	public void doGet(
	HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h3>Welcome, admin</h3>");
		out.println("<h3>User statistics : </h3>");
		ServletContext ctx=getServletConfig().getServletContext();
		Integer t=(Integer)ctx.getAttribute("total");
		Integer c=(Integer)ctx.getAttribute("current");
		out.println("<p>Total User   : "+t+"</p>");
		out.println("<p>Current User  : "+c+"</p>");
		out.println("<a href=adminServlet>Refresh</a>");
		out.close();
	}
		
			

}
