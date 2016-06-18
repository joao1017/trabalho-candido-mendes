package br.com.controlealuno.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlealuno.dao.impl.AlunoDaoImpl;
import br.com.controlealuno.model.AlunoEntity;
import br.com.controlealuno.servlet.command.ICommand;

public class ListarAluno implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			AlunoDaoImpl dao = new AlunoDaoImpl();
			request.setAttribute("listaAlunos", dao.listar(AlunoEntity.getAluno(request)));
			request.getRequestDispatcher("tabelaResultadoAluno.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}