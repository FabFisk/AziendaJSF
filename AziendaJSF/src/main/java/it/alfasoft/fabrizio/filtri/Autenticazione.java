package it.alfasoft.fabrizio.filtri;

import it.alfasoft.fabrizio.controller.LoginController;

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

/**
 * Servlet Filter implementation class Autenticazione
 */
@WebFilter("/portals/*")
public class Autenticazione implements Filter {

	private FilterConfig filterConfig = null;
    /**
     * Default constructor. 
     */
    public Autenticazione() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpRes = (HttpServletResponse)response;
		HttpSession session = httpReq.getSession();
		
		LoginController logCon = (LoginController)session.getAttribute("lc");
		
		if(logCon.isLoggato()==false){
			httpRes.sendRedirect("Login.xhtml");	
			System.out.println("ciao da filtro");
		}
		System.out.println("ciao da filtro2");	

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}

}
