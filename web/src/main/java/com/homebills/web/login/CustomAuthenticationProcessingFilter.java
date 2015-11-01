package com.homebills.web.login;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Maxim Marusich
 */
public class CustomAuthenticationProcessingFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger logger = Logger.getLogger(CustomAuthenticationProcessingFilter.class);

    private static final RedirectStrategy redirectStrategy = new RedirectStrategy() {

        @Override
        public void sendRedirect(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse, String s) throws IOException {
        }
    };
    private SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
    private SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
    private String defaultFailureUrl;
    private String defaultTargetUrl;

    public CustomAuthenticationProcessingFilter(String defaultFailureUrl, String defaultTargetUrl) {
        super();
        this.defaultTargetUrl = defaultTargetUrl;
        this.defaultFailureUrl = defaultFailureUrl;

        successHandler.setRedirectStrategy(redirectStrategy);
        failureHandler.setRedirectStrategy(redirectStrategy);

        successHandler.setDefaultTargetUrl(defaultTargetUrl);
        failureHandler.setDefaultFailureUrl(defaultFailureUrl);

        this.setAuthenticationSuccessHandler(successHandler);
        this.setAuthenticationFailureHandler(failureHandler);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        logger.debug("Success authorization.");
        super.successfulAuthentication(request, response, chain, authResult);
        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response);
        Writer out = responseWrapper.getWriter();
        out.write("{\"success\": true, \"targetUrl\" : \"" + defaultTargetUrl + "\"}");
        out.flush();
        out.close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        logger.debug("Unsuccess authorization.");
        super.unsuccessfulAuthentication(request, response, failed);
        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response);
        Writer out = responseWrapper.getWriter();
        out.write("{\"success\":false, \"error\": \"" + failed.getMessage() + "\", \"targetUrl\" : \"" + defaultFailureUrl + "\"}");
        out.flush();
        out.close();
    }
}