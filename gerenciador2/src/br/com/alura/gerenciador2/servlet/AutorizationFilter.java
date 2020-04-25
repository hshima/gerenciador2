package br.com.alura.gerenciador2.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/entry")
public class AutorizationFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("AutorizationFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String paramAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean notLogedUser = (session.getAttribute("logedUser") == null);
		boolean isProtectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
		if(isProtectedAction && notLogedUser) {
			response.sendRedirect("entry?action=LoginForm");
			return;	
		}
		
		
		chain.doFilter(request, response);
	}

}
