package br.com.alura.gerenciador2.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.DataBase;

public class RemoveEmpresa {

	public void executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Iniciando método de remoção");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
				
		DataBase db = new DataBase();
		db.remover(id);
		
		System.out.println("redirecionando para action listEnterprises");
		response.sendRedirect("entry?action=listEnterprises");
		
	}

}
