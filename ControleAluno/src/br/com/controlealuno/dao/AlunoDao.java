package br.com.controlealuno.dao;

import java.util.List;

import br.com.controlealuno.model.AlunoEntity;

public interface AlunoDao {

	/**
	 * <b>Método responsável por gravar o aluno.</b>
	 * @param aluno
	 * @return Aluno
	 */
	AlunoEntity gravar(AlunoEntity aluno);
	
	/**
	 * <b>Método responsável por recuperar o aluno por ID.</b>
	 * @param aluno
	 * @return Aluno
	 */
	AlunoEntity findById(Long id);

	/**
	 * <b>Método responsável por listar os alunos na rotina de pesquisa.</b>
	 * @param aluno
	 * @return Alunos
	 */
	List<AlunoEntity> listar(AlunoEntity aluno);

	/**
	 * <b>Método responsável por remover o aluno.</b>
	 * @param aluno
	 */
	void excluir(AlunoEntity aluno);

	/**
	 * <b>Método responsável por atualizar os dados do Aluno.</b>
	 * @param aluno
	 */
	void atualizar(AlunoEntity aluno);
}
