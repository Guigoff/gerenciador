package br.com.furla.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.furla.gerenciador.modelo.Banco;
import br.com.furla.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresa
 */
//@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("dataAbertura");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("listaEmpresas");
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
