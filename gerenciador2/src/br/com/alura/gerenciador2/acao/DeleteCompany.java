package br.com.alura.gerenciador2.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.DataBase;

@WebServlet("/DeleteCompany")
public class DeleteCompany extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nome");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
				
		DataBase db = new DataBase();
		db.remover(id);
		
		return "redirect:entry?action=ListEnterprises";
		
	}

}
