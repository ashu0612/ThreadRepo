package com.hostel.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
//this will determine the custom filters that we want to add 
//for our common url's.
@Component
@Order(1)
public class HostelFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println("the transaction starts:"+httpRequest.getRequestURI());
		chain.doFilter(request, response);
		System.out.println("the transaction ends"+httpRequest.getRequestURI());
	}

	
	
}
