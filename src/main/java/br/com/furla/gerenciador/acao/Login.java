package br.com.furla.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.furla.gerenciador.modelo.Banco;
import br.com.furla.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();
		
		Usuario usuario = banco.existeUsuario(login,senha);
		
		if(usuario != null) {
			return "redirect:home?acao=ListaEmpresa";
		}else {
			return "redirect:home?acao=LoginForm";
		}
		
		
	}

}
