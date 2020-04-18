package br.com.alura.gerenciador2.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Company;
import br.com.alura.gerenciador2.modelo.DataBase;

public class EditCompany implements Action {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramNome = request.getParameter("nome");
		String paramDate = request.getParameter("date");		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date dt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dt = sdf.parse(paramDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		DataBase db = new DataBase();
		Company cp = db.getCompanyById(id);
		cp.setNome(paramNome);
		cp.setDateOpen(dt);
		
		return "redirect:entry?action=ListEnterprises";		
	}

}
