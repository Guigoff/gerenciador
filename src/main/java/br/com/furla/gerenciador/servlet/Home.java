package br.com.furla.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.furla.gerenciador.acao.Acao;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String className = "br.com.furla.gerenciador.acao." + request.getParameter("acao");
		
		
		HttpSession sessao = request.getSession();
		boolean noLogin = sessao.getAttribute("usuarioLogado") == null ;
		boolean actionProtect = !(request.getParameter("acao").equals("Login") || request.getParameter("acao").equals("LoginForm"));
		
		if (actionProtect && noLogin) {
			response.sendRedirect("home?acao=LoginForm"); 
			return;
		}
		
		
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
