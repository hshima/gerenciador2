package br.com.alura.gerenciador2.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Company;
import br.com.alura.gerenciador2.modelo.DataBase;

public class ListEnterprises extends HttpServlet implements Action{
	private static final long serialVersionUID = 1L;

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataBase db = new DataBase();
		List<Company> list = db.getCompany();
		
		request.setAttribute("companies", list);
		return "forward:listEnterprises.jsp";
		
	}
	
}
