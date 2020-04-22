package br.com.alura.gerenciador2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Company;
import br.com.alura.gerenciador2.modelo.DataBase;

@WebServlet("/listaEmpresas")
public class ListCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase db = new DataBase();
		List<Company> list = db.getCompany();
		
		request.setAttribute("companies", list);
		System.out.println("Redirecionando para listEnterprises.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/listEnterprises.jsp");
		rd.forward(request, response);

	}

}
