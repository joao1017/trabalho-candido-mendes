package br.com.controlealuno.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.controlealuno.constant.ControleAlunoConstant;
import br.com.controlealuno.properties.AppResource;
import br.com.controlealuno.servlet.command.ICommand;
import br.com.controlealuno.util.JSONUtil;

public class Logout implements ICommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonReturn = new JSONObject();
		try {
			request.getSession().removeAttribute(ControleAlunoConstant.USER_SESSION);
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