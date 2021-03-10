package com.thanhtai.cms.fiter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class NewFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("the new filter is called ..");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
