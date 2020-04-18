package br.com.alura.gerenciador2.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador2.modelo.DataBase;
import br.com.alura.gerenciador2.modelo.User;

public class Login implements Action{

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		DataBase db = new DataBase();
		User user = db.userExists(login, password);
		if(user != null) {
			return "redirect:entry?action=ListEnterprises";
		} else {
			return "redirect:entry?action=LoginForm";	
		}
		
	}

}
