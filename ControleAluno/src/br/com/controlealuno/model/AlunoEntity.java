package br.com.controlealuno.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.com.controlealuno.util.DateUtil;
import br.com.controlealuno.util.StringUtil;

public class AlunoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeAluno;
	private Date dataNascimento;
	private Integer numeroIdentidade;

	public AlunoEntity() {
		super();
	}

	public AlunoEntity(Long id, String nomeAluno, Date dataNascimento, Integer numeroIdentidade) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.dataNascimento = dataNascimento;
		this.numeroIdentidade = numeroIdentidade;
	}

	public AlunoEntity(String id, String nomeAluno, String dataNascimento, String numeroIdentidade) throws ParseException {
		super();
		this.id = id != null && !"".equals(id) ? Long.valueOf(id) : null;
		this.nomeAluno = nomeAluno != null ? nomeAluno : null;
		setDataNascimentoFormatado(dataNascimento != null ? dataNascimento : null);
		setNumeroIdentidadeFormatado(numeroIdentidade != null ? numeroIdentidade : null);
	}

	public Long getId() {
		if(this.id == null)
			return 0L;
		else			
			return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAluno() {
		if(nomeAluno != null && !"".equals(nomeAluno))
			return nomeAluno;
		else
			return "";
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getNumeroIdentidade() {
		return numeroIdentidade;
	}

	public void setNumeroIdentidade(Integer numeroIdentidade) {
		this.numeroIdentidade = numeroIdentidade;
	}

	public static AlunoEntity getAluno(HttpServletRequest request) throws ParseException {
		return new AlunoEntity(request.getParameter("id"), request.getParameter("nomeAluno"), request.getParameter("dataNascimento"), request.getParameter("numeroIdentidade"));
	}
	
	public String getNumeroIdentidadeFormatado(){
		String rgFormatado = "";
		if(this.numeroIdentidade != null)
			rgFormatado = StringUtil.formatRG(Integer.toString(this.numeroIdentidade));
		else
			rgFormatado = "";			
		return rgFormatado;
	}
	
	public void setNumeroIdentidadeFormatado(String rg){
		if(rg != null && !"".equals(rg)){
			rg = rg.replace(".", "").replace("-", "");
			
			this.numeroIdentidade = Integer.valueOf(rg); 
		}
	}
	
	public String getDataNascimentoFormatado() {
		String dataNascimentoF = "";
		if(this.dataNascimento != null)
			dataNascimentoF = DateUtil.formataDataParaString(this.dataNascimento);
		else
			dataNascimentoF = "";
		return dataNascimentoF;
	}

	public void setDataNascimentoFormatado(String dataNascimentoF) {
		if(dataNascimentoF != null && !"".equals(dataNascimentoF)){
			this.dataNascimento = DateUtil.formataStringParaUtilDate(dataNascimentoF);
		}
	}
}