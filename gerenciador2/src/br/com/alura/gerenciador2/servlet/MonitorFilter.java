package br.com.alura.gerenciador2.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entry")
public class MonitorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MonitorFilter");
		long earlier = System.currentTimeMillis();
		//Captures URL parameter
		String paramAction = servletRequest.getParameter("action");
		
		chain.doFilter(servletRequest, servletResponse);
		
		long later = System.currentTimeMillis();
		long processedIn = (later-earlier);
		System.out.println("Tempo decorrido de processamento: " + processedIn);
		
	}

}
