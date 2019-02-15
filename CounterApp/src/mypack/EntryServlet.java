package mypack;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class EntryServlet extends HttpServlet {
	
	public void doGet(
	HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		String name=request.getParameter("name");
		HttpSession session=request.getSession();
		session.setAttribute("username",name);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h3>Welcome, "+name+"</h3>");
		out.println("<a href=exitServlet>exit</a>");
		out.close();
	}

}
