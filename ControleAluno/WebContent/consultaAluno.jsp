<jsp:include page="header.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/aluno/aluno.js"></script>
<body>
 <form class="form">
	<div class="container espaco-topo">
		<div class="row clearfix">
			<div class="titulo-tabela">Consulta de Alunos</div>
			<div class="col-md-12 column espacamento-topo">
				<label class="control-label col-sm-2">Aluno</label>
				<div class="col-sm-10">
					<input class="form-control" name="nomeAluno" type="text" maxlength="200"/>
				</div>
			</div>
			<div class="col-md-12 column espacamento-topo">
				<label class="control-label col-sm-2">RG</label>
				<div class="col-sm-10">
					<input class="form-control input-rg" name="numeroIdentidade" type="text" maxlength="50"/>
				</div>	
				
			</div>
			<div class="col-md-12 column espacamento-topo">
				<div class="col-md-6 column">
					<button type="button"   id="btn-filtrar-aluno" class="btn btn-filtro">Pesquisar</button>
					<button type="button"   id="btn-criar-aluno" class="btn btn btn-warning">Cadastrar Aluno</button>
				</div>
			</div>
			<div class="col-md-12 column espacamento-tabela-consulta">
				<div id="consulta-resultado-aluno"></div>
			</div>
		</div>
	</div>
  </form>	
</body>
<jsp:include page="footer.jsp" />