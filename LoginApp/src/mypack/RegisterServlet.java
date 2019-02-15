package mypack;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
	
	public void doPost(
	HttpServletRequest request,HttpServletResponse response)
	{
		
		try
		{
			String n=request.getParameter("name");
			String m= request.getParameter("mailid");
			String p=request.getParameter("password");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			ServletContext ctx=getServletConfig().getServletContext();
			Class.forName(ctx.getInitParameter("driver class"));
			Connection con=DriverManager.getConnection(
			ctx.getInitParameter("url"), 
			ctx.getInitParameter("user"), 
		    ctx.getInitParameter("password"));
			PreparedStatement stmt=con.prepareStatement("insert into register(name,mailid,password) values(?,?,?)");
			stmt.setString(1,n);
			stmt.setString(2,m);
			stmt.setString(3,p);
			stmt.executeUpdate();
			con.close();
			out.println("Successfully saved");
			RequestDispatcher rd=request.getRequestDispatcher("register.html");
			rd.include(request, response);
			out.close();
		  }
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
