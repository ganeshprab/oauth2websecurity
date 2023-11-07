package com.prabhu.ganesh.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class Myfilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //if (SecurityContextHolder.getContext().getAuthentication() != null) {
        // Object oldbypassAuthentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(!(SecurityContextHolder.getContext().getAuthentication() instanceof BypassAuthentication)) {
                BypassPrincipal bypassPrincipal = new BypassPrincipal("123456", "12345");
                BypassAuthentication bypassAuthentication = new BypassAuthentication(bypassPrincipal);
                SecurityContextHolder.getContext().setAuthentication(bypassAuthentication);
                // Create a new session and add the security context.
                /*HttpServletRequest request = (HttpServletRequest) servletRequest;
                HttpSession session = request.getSession(true);
                if (session.getAttribute("SPRING_SECURITY_CONTEXT") == null) {
                    session.setAttribute("SPRING_SECURITY_CONTEXT", bypassAuthentication);
                }*/
            }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
