package br.com.furla.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/home")
public class AutorizacaoFilter implements Filter {
       

   
	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		
		HttpSession sessao = request.getSession();
		boolean noLogin = sessao.getAttribute("usuarioLogado") == null ;
		boolean actionProtect = !(request.getParameter("acao").equals("Login") || request.getParameter("acao").equals("LoginForm"));
		
		if (actionProtect && noLogin) {
			response.sendRedirect("home?acao=LoginForm"); 
			return;
		}
		
		chain.doFilter(request, response);
	}



}
