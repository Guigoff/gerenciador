package br.com.furla.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


//@WebFilter("/home")
public class MonitoramentoFilter implements Filter {
       

   
	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) throws IOException, ServletException {
		long antes = System.currentTimeMillis();
		chain.doFilter(ServletRequest, ServletResponse);
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execução da ação: " + ServletRequest.getParameter("acao") + "->" + (depois - antes));
	}



}
