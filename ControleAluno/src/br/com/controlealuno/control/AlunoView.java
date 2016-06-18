package br.com.controlealuno.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlealuno.dao.impl.AlunoDaoImpl;
import br.com.controlealuno.servlet.command.ICommand;

public class AlunoView  implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long id = Long.valueOf(request.getParameter("idControle"));
			AlunoDaoImpl dao = new AlunoDaoImpl();
			request.setAttribute("aluno", dao.findById(id));
			request.getRequestDispatcher("cadastroAluno.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

}