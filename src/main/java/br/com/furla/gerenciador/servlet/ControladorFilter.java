package br.com.furla.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.furla.gerenciador.acao.Acao;


//@WebFilter("/home")
public class ControladorFilter implements Filter {
       

   
	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		
		String className = "br.com.furla.gerenciador.acao." + request.getParameter("acao");
		
		String r;
		try {
			Class classe = Class.forName(className);
			Acao acao = (Acao) classe.newInstance();
			r = acao.run(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

	
		String[] config =  r.split(":");
		
		if(config[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + config[1]);
			rd.forward(request, response);			
		} else {
			response.sendRedirect(config[1]);
		}

	}



}
