package br.com.controlealuno.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.controlealuno.connection.ConnectionJDBC;
import br.com.controlealuno.dao.AlunoDao;
import br.com.controlealuno.model.AlunoEntity;
import br.com.controlealuno.util.StringUtil;

public class AlunoDaoImpl implements AlunoDao {

	Connection conn;

	public AlunoDaoImpl() throws SQLException, ClassNotFoundException {
		if (conn == null) {
			conn = ConnectionJDBC.getInstance().getConnection();
			conn.setAutoCommit(false);
		}
	}

	@Override
	public AlunoEntity gravar(AlunoEntity aluno) {
		PreparedStatement pst = null;
		try {
			StringBuffer insert = new StringBuffer(" insert into test.aluno (nmaluno, nrrgaluno, dtnascimento) values (?,?,?) ");
			pst = conn.prepareStatement(insert.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, aluno.getNomeAluno());
			pst.setInt(2, aluno.getNumeroIdentidade());
			pst.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
			pst.executeUpdate();
			conn.commit();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()){
				aluno.setId(rs.getLong(1));
			}
		} catch (Throwable e) {
			try {
				if (conn != null)
					conn.rollback();

			} catch (Exception e3) {
				e3.printStackTrace();
			}
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return aluno;
	}

	@Override
	public List<AlunoEntity> listar(AlunoEntity aluno) {
		PreparedStatement pst = null;
		List<AlunoEntity> alunos = new ArrayList<AlunoEntity>();
		try {
			StringBuffer find = new StringBuffer("select idaluno, nmaluno, nrrgaluno, dtnascimento from test.aluno where 1 = 1 ");
			
			if (aluno.getNomeAluno() != null && !"".equals(aluno.getNomeAluno()))
				find.append(" and upper(nmaluno) like '").append(StringUtil.leftAndRightLike(aluno.getNomeAluno().toUpperCase())).append("' ");

			if (aluno.getNumeroIdentidade() != null)
				find.append(" and nridentidade = ").append(aluno.getNumeroIdentidade());

			pst = conn.prepareStatement(find.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				AlunoEntity alunoRetorno = new AlunoEntity();
				alunoRetorno.setId(rs.getLong("idaluno"));
				alunoRetorno.setNomeAluno(rs.getString("nmaluno"));
				alunoRetorno.setNumeroIdentidade(rs.getInt("nrrgaluno"));
				alunoRetorno.setDataNascimento(rs.getDate("dtnascimento"));
				alunos.add(alunoRetorno);

				alunoRetorno = new AlunoEntity();
			}
		} catch (Throwable e) {
			try {
				if (conn != null)
					conn.rollback();

			} catch (Exception e3) {
				e3.printStackTrace();
			}
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return alunos;
	}

	@Override
	public void excluir(AlunoEntity aluno) {
		PreparedStatement pst = null;
		try {
			StringBuffer delete = new StringBuffer(" delete from test.aluno where idaluno = ? ");
			pst = conn.prepareStatement(delete.toString());
			pst.setLong(1, aluno.getId());
			pst.executeUpdate();
			conn.commit();
		} catch (Throwable e) {
			try {

				if (conn != null)
					conn.rollback();

			} catch (Exception e3) {
				e3.printStackTrace();
			}
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(AlunoEntity aluno) {
		PreparedStatement pst = null;
		try {
			StringBuffer update = new StringBuffer(" update test.aluno set nmaluno = ?, nrrgaluno = ?, dtnascimento = ? where idaluno = ?");
			pst = conn.prepareStatement(update.toString());
			pst.setString(1, aluno.getNomeAluno());
			pst.setInt(2, aluno.getNumeroIdentidade());
			pst.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
			pst.setLong(4, aluno.getId());
			pst.executeUpdate();
			conn.commit();
		} catch (Throwable e) {
			try {
				if (conn != null)
					conn.rollback();

			} catch (Exception e3) {
				e3.printStackTrace();
			}
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public AlunoEntity findById(Long id) {
		PreparedStatement pst = null;
		AlunoEntity aluno = new AlunoEntity();
		try {
			StringBuffer find = new StringBuffer("select idaluno, nmaluno, nrrgaluno, dtnascimento from test.aluno where idaluno = ? ");
	
			pst = conn.prepareStatement(find.toString());
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				aluno.setId(rs.getLong("idaluno"));
				aluno.setNomeAluno(rs.getString("nmaluno"));
				aluno.setNumeroIdentidade(rs.getInt("nrrgaluno"));
				aluno.setDataNascimento(rs.getDate("dtnascimento"));
			}
		} catch (Throwable e) {
			try {
				if (conn != null)
					conn.rollback();

			} catch (Exception e3) {
				e3.printStackTrace();
			}
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return aluno;
	}
}