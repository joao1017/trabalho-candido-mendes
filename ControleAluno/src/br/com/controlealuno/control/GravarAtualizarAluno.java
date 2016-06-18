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

public class GravarAtualizarAluno implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonReturn = new JSONObject();
		try{
			AlunoEntity aluno = AlunoEntity.getAluno(request);
			AlunoDaoImpl dao = new AlunoDaoImpl();
			if(aluno != null && (aluno.getId() != null && aluno.getId() != 0)){
				dao.atualizar(aluno);
			}else{	
				aluno = dao.gravar(aluno);
			}
			if(aluno != null){
				if(aluno.getId() != null && aluno.getId() != 0){
					jsonReturn.put("idAluno", aluno.getId());
				}
			}
			jsonReturn.put("msgOK", AppResource.getValue("msg.sucesso.gravacao"));
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