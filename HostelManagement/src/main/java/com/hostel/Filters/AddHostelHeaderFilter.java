package com.hostel.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//this class will add one extra header 
//and after that it will call doFilter
//to get the next entity that is response and request calls.
@Component
@Order(2)
public class AddHostelHeaderFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("x-powered-by", "Ashu Mishra");
		chain.doFilter(request, response);

	}

}
