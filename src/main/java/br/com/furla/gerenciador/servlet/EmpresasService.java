package br.com.furla.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.furla.gerenciador.modelo.Banco;
import br.com.furla.gerenciador.modelo.Empresa;


@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Empresa> empresas = new Banco().getEmpresas();
		
		String type = request.getHeader("Accept");
		
		
		if(type.contains("application/xml")) {
			
			XStream xstream = new XStream();
			xstream.aliasType("empresa", Empresa.class);
			String xml = xstream.toXML(empresas); 
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
			
		} else if (type.contains("application/json")) {
			
			Gson gson = new Gson();
			String json = gson.toJson(empresas);  
			
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		} 

	}
	

}
