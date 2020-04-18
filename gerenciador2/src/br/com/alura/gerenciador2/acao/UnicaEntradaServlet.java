package br.com.alura.gerenciador2.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/entry")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAction = request.getParameter("action");
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
