package com.library.security;

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


public class SecurityLibrary implements Filter {

   //this security only for the page bookShop
    public SecurityLibrary() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("hello");
		 HttpServletResponse resp=(HttpServletResponse) response;
		HttpServletRequest re=((HttpServletRequest) request);
		 String path = ((HttpServletRequest) request).getRequestURI();
		if(re.getSession().getAttribute("username")!=null){
		     chain.doFilter(request, response); // Just continue chain.
		}else{
			resp.sendRedirect("/Library/login.jsp");
			
		}
	

	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
