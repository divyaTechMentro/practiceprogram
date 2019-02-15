package mypack;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String m=request.getParameter("mailid");
			String p=request.getParameter("password");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			ServletContext ctx=getServletConfig().getServletContext();
			Class.forName(ctx.getInitParameter("driver class"));
			Connection con=DriverManager.getConnection(
		    ctx.getInitParameter("url"),
		    ctx.getInitParameter("user"),
		    ctx.getInitParameter("password"));
			PreparedStatement stmt=con.prepareStatement("select name from register where mailid=? and password=? ");
			stmt.setString(1,m);
			stmt.setString(2,p);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				out.println("<h3>welcome, "+rset.getString(1)+"</h3>");
			}
			else
			{
				out.println("Either ailid or password is wrong.");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			con.close();
			out.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
