package br.com.alura.gerenciador2.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.Company;
import br.com.alura.gerenciador2.modelo.DataBase;

/**
 * Servlet implementation class NewCompanyServlet
 */
@WebServlet("/cadastrarNovaEmpresa")
public class NewCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastrando nova empresa em NewCompanyServlet.java");
		DataBase db = new DataBase();
		
		
		String nome = request.getParameter("company");
		String dtIncluded = request.getParameter("date");
		
		Company company = new Company();
		company.setNome(nome);

		Date dataCadastro = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataCadastro = sdf.parse(dtIncluded);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		company.setDateOpen(dataCadastro);
		db.adicionar(company);

//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		request.setAttribute("company", company.getNome());
		request.setAttribute("date", company.getDateOpen());
//		rd.forward(request, response);
		System.out.println("redirecionando para ListCompanyServelt");
		response.sendRedirect("listaEmpresas");
		System.out.println("Empresa cadastrada com sucesso: "+nome+". \tData de cadastro: "+company.getDateOpen());
	}

}
