package br.com.controlealuno.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.controlealuno.dao.impl.AlunoDaoImpl;
import br.com.controlealuno.model.AlunoEntity;
import br.com.controlealuno.properties.AppResource;
import br.com.controlealuno.servlet.command.ICommand;
import br.com.controlealuno.util.JSONUtil;

public class ExcluirAluno implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonReturn = new JSONObject();
		try{
			AlunoDaoImpl dao = new AlunoDaoImpl();
			dao.excluir(AlunoEntity.getAluno(request));
			jsonReturn.put("msgOK", AppResource.getValue("msg.sucesso.exclusao"));
		}catch(Exception e){
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