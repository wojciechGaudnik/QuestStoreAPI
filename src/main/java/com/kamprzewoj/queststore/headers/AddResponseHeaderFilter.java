package com.kamprzewoj.queststore.headers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AddResponseHeaderFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	                     FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		log.error("test <-----------------------------------------------");
		httpServletResponse.setHeader(
				"Baeldung-Example-Filter-Header", "Value-Filter");
		chain.doFilter(request, httpServletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ...
	}

	@Override
	public void destroy() {
		// ...
	}
}
