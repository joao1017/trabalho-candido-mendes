<jsp:include page="header.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/login/login.js"></script>
<body style="background-color: #7F3442;">
	<form id="login-form">
	<div class="container espaco-topo fundo-login">
		<div class="row clearfix">
			<div class="col-md-12 column espacamento-topo">
				<label class="control-label col-sm-2">Usuário</label>
				<div class="col-sm-10">
					<input class="form-control input-date required" id="usuario" name="usuario" type="text" maxlength="50"/>
				</div>	
			</div>
			<div class="col-md-12 column espacamento-topo">
				<label class="control-label col-sm-2">Senha</label>
				<div class="col-sm-10">
					<input class="form-control input-date required" id="senha" name="senha" type="password" maxlength="50"/>
				</div>	
			</div>
			<div class="col-md-12 column espacamento-topo">
				<button type="button" id="btn-login" class="btn btn-filtro">Entrar</button>
			</div>	
		</div>
	</div>
	</form>
</body>