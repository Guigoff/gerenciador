package br.com.furla.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.furla.gerenciador.modelo.Banco;
import br.com.furla.gerenciador.modelo.Empresa;

public class Altera {
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("dataAbertura");
		String parameId = request.getParameter("id");
		Integer id = Integer.valueOf(parameId);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresa(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		
		response.sendRedirect("home?acao=listaEmpresa");
		
	}
}
