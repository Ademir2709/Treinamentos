package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.database.Empresa;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		String dataAberturaTMP = request.getParameter("dataAbertura");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataAberturaTMP);
		}catch (ParseException e) {
			throw new ServletException(e);
		}
					
		Empresa empresa = new Empresa();
		
		empresa.setNomeEmpresa(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		
		banco.adiciona(empresa);
		
		System.out.println("Cadastrando nova empresa " + nomeEmpresa + " - " + dataAbertura);

		request.setAttribute("empresa", empresa.getNomeEmpresa());
		
		response.sendRedirect("listaEmpresas");
			
	}


}
