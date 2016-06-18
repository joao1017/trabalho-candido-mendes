package br.com.controlealuno.dao;

import java.util.List;

import br.com.controlealuno.model.AlunoEntity;

public interface AlunoDao {

	/**
	 * <b>M�todo respons�vel por gravar o aluno.</b>
	 * @param aluno
	 * @return Aluno
	 */
	AlunoEntity gravar(AlunoEntity aluno);
	
	/**
	 * <b>M�todo respons�vel por recuperar o aluno por ID.</b>
	 * @param aluno
	 * @return Aluno
	 */
	AlunoEntity findById(Long id);

	/**
	 * <b>M�todo respons�vel por listar os alunos na rotina de pesquisa.</b>
	 * @param aluno
	 * @return Alunos
	 */
	List<AlunoEntity> listar(AlunoEntity aluno);

	/**
	 * <b>M�todo respons�vel por remover o aluno.</b>
	 * @param aluno
	 */
	void excluir(AlunoEntity aluno);

	/**
	 * <b>M�todo respons�vel por atualizar os dados do Aluno.</b>
	 * @param aluno
	 */
	void atualizar(AlunoEntity aluno);
}
