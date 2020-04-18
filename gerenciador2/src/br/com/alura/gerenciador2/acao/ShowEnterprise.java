package br.com.alura.gerenciador2.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Company;
import br.com.alura.gerenciador2.modelo.DataBase;

public class ShowEnterprise implements Action {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Processa ShowEnterprise");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		DataBase db = new DataBase();
		Company cp = db.getCompanyById(id);
		request.setAttribute("company", cp);
		return "forward:formAlterCompany.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher("/formAlterCompany.jsp");
//		rd.forward(request, response);
	}

}
