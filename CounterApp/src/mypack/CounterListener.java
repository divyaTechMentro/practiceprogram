package mypack;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CounterListener implements ServletContextListener, HttpSessionListener {

	ServletContext ctx;

	@Override
	public void contextInitialized(ServletContextEvent e) {
		
		ctx=e.getServletContext();
		ctx.setAttribute("total",0);
		ctx.setAttribute("current",0);
		System.out.println("Counters are set.");
		
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		
		Integer t=(Integer)ctx.getAttribute("total");
		t++;
		ctx.setAttribute("total",t);
		Integer c=(Integer)ctx.getAttribute("current");
		c++;
		ctx.setAttribute("current",c);
		System.out.println("Both the counters are incremented.");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		
		Integer c=(Integer)ctx.getAttribute("current");
		c--;
		ctx.setAttribute("current",c);
		System.out.println("Current counters is decremented.");
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {}
	
	

}
