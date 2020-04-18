package br.com.alura.gerenciador2.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Company;
import br.com.alura.gerenciador2.modelo.DataBase;

public class NewCompany implements Action{

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramName = request.getParameter("company");
		String paramDate = request.getParameter("date");
		
		Date dt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dt = sdf.parse(paramDate);
		} catch(ParseException e) {
			throw new ServletException(e);
		}
		
		DataBase db = new DataBase();
		Company cp = new Company();
		cp.setNome(paramName);
		cp.setDateOpen(dt);
		db.adicionar(cp);
		
		return "redirect:/gerenciador2/entry?action=ListEnterprises";
	}

}
