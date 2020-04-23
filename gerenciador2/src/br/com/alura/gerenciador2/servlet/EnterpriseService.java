package br.com.alura.gerenciador2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador2.modelo.Company;
import br.com.alura.gerenciador2.modelo.DataBase;

@WebServlet("/ws")
public class EnterpriseService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataBase db = new DataBase();
		List<Company> company = db.getCompany();
		
		String headers = request.getHeader("accept");
		
		if(headers.contains("xml")) {
			XStream xStream = new XStream();
			xStream.alias("empresa", Company.class);
			String xml = xStream.toXML(company);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} else if(headers.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(company);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
		
		
	}
	

}
