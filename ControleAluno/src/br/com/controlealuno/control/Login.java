package br.com.controlealuno.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.controlealuno.constant.ControleAlunoConstant;
import br.com.controlealuno.model.LoginEntity;
import br.com.controlealuno.properties.AppResource;
import br.com.controlealuno.servlet.command.ICommand;
import br.com.controlealuno.util.JSONUtil;

public class Login implements ICommand {
	
	private static final String USUARIO_MASTER = "admin";
	private static final String SENHA_MASTER = "admin";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonReturn = new JSONObject();
		try {
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			LoginEntity login = new LoginEntity(usuario, senha);

			if (USUARIO_MASTER.equals(usuario) && SENHA_MASTER.equals(senha)) {
				request.getSession().setAttribute(ControleAlunoConstant.USER_SESSION, login);
			} else {
				jsonReturn.put("msgERRO", AppResource.getValue("msg.erro.login"));	
			}
		} catch (Exception e) {
			try {
				jsonReturn.put("msgERRO", AppResource.getValue("msg.erro.gerenico"));
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		JSONUtil.writeJsonResponse(jsonReturn, response);
	}
}
