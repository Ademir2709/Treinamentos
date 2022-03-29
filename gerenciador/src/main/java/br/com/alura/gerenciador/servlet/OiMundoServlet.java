package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Oi")
public class OiMundoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Oi mundo, parabéns vc escreveu su primeiro Servlet</p>");
		out.println("</body>");
		out.println("</html>");

		System.out.println("O servlet OiMundoServlet foi iniciado com sucesso");
		
	}
}
