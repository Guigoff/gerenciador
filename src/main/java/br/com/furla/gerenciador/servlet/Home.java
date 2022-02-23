package br.com.furla.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.furla.gerenciador.acao.Altera;
import br.com.furla.gerenciador.acao.Lista;
import br.com.furla.gerenciador.acao.Mostra;
import br.com.furla.gerenciador.acao.Nova;
import br.com.furla.gerenciador.acao.Remove;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rp = request.getParameter("acao");

		if (rp.equals("listaEmpresa")) {

			Lista acao = new Lista();
			acao.run(request, response);

		} else if (rp.equals("mostraEmpresa")) {
			Mostra acao = new Mostra();
			acao.run(request, response);
		} else if (rp.equals("deletaEmpresa")) {
			Remove acao = new Remove();
			acao.run(request, response);

		} else if (rp.equals("alteraEmpresa")) {
			Altera acao = new Altera();
			acao.run(request, response);

		} else if (rp.equals("novaEmpresa")) {
			Nova acao = new Nova();
			acao.run(request, response);

		}

	}

}
