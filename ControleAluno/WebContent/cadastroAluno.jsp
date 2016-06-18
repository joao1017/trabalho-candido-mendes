<jsp:include page="header.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/aluno/aluno.js"></script>
<body>
 <form class="form" id="formCadastroAluno">
 <input type="hidden" id="idAluno" name="id" value="${aluno.id}" />
	<div class="container espaco-topo">
		<div class="row clearfix">
			<div class="titulo-tabela">Consulta de Alunos</div>
			<div class="col-md-12 column espacamento-topo">
				<label class="control-label col-sm-2">Aluno</label>
				<div class="col-sm-10">
					<input class="form-control required" id="nmAluno" name="nomeAluno" value="${aluno.nomeAluno}" type="text" maxlength="200"/>
				</div>	
			</div>
			<div class="col-md-12 column espacamento-topo">
				<label class="control-label col-sm-2">RG</label>
				<div class="col-sm-10">
					<input class="form-control input-rg required" id="nrRg" name="numeroIdentidade" value="${aluno.numeroIdentidadeFormatado}" type="text" maxlength="50"/>
				</div>	
			</div>
			<div class="col-md-12 column espacamento-topo">
				<label class="control-label col-sm-2">Data de Nascimento</label>
				<div class="col-sm-10">
					<input class="form-control input-date required" id="dtNascimento" name="dataNascimento" value="${aluno.dataNascimentoFormatado}" type="text" maxlength="50"/>
				</div>	
			</div>
			<div class="col-md-12 column espacamento-topo">
				<button type="button"   id="btn-voltar-aluno" class="btn btn-filtro">Voltar</button>
				<button type="button"   id="btn-gravar-aluno" class="btn btn btn-primary">Gravar</button>
				<button type="button"   id="btn-excluir-aluno" class="btn btn btn-danger hidden-element">Excluir</button>
			</div>	
		</div>
	</div>
  </form>	
</body>
<jsp:include page="footer.jsp" />