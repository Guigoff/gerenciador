package br.com.furla.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.furla.gerenciador.modelo.Banco;
import br.com.furla.gerenciador.modelo.Empresa;

public class Mostra {
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroId = request.getParameter("id");
		Integer id = Integer.valueOf(parametroId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresa(id);
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
	}
}
