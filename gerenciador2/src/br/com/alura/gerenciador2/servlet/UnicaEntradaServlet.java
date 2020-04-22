package br.com.alura.gerenciador2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador2.acao.Action;

public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Captures URL parameter
		String paramAction = request.getParameter("action");
		


		//Instantiates a Class based in the param argument 
		String nameClass = "br.com.alura.gerenciador2.acao." + paramAction;
		System.out.println(nameClass);
		String name;
		try {
			Class classe = Class.forName(nameClass);
			Action action = (Action) classe.newInstance();
			name = action.run(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		//Defines which kind of server call will be made and executes
		String[] tipoEEndereco = name.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else if(tipoEEndereco[0].equals("redirect")) {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
//		if(paramAction.equals("listEnterprises")) {
//			ListaEmpresa action = new ListaEmpresa();
//			action.executar(request,response);
//		}
//		if(paramAction.equals("removeEnterprise")) {
//			RemoveEmpresa action = new RemoveEmpresa();
//			action.executar(request,response);
//		}
//		if(paramAction.equals("showEnterprise")) {
//			MostraEmpresa action = new MostraEmpresa();
//			action.executar(request,response);
//		}
//		if(paramAction.equals("editEnterprise")) {
//			AlteraEmpresa action = new AlteraEmpresa();
//			action.executar(request,response);
//		}
//		if(paramAction.equals("newEnterprise")) {
//			NovaEmpresa action = new NovaEmpresa();
//			action.executar(request,response);
//		}
	}

}
