var url_rotina = '/ControleAluno/controller?command=';

$(document).ready(function(){
	$('input').on('focus', function(){
		$(this).removeClass('campo-obrigatorio');
	});
	$('.input-date').mask('99/99/9999');
	$('.input-rg').mask('99.999.999-9');
	
	$('#btn-filtrar-aluno').click(function(){
		consultar();
	});
	$('#btn-criar-aluno').click(function(){
		window.location.href = '/ControleAluno/cadastroAluno.jsp';
	});
	
	$('#btn-voltar-aluno').click(function(){
		window.location.href = '/ControleAluno/consultaAluno.jsp';
	});	
	$('#btn-gravar-aluno').click(function(){
		gravar();
	});
	$('#btn-excluir-aluno').click(function(){
		if(confirm('Deseja realmente remover esse aluno?'))
			excluir();
	});
	
	var idAluno = $('#idAluno').val();
	if(idAluno != null && idAluno != '' && idAluno != '0' && idAluno != undefined && idAluno != 'undefined'){
		$('#btn-excluir-aluno').removeClass('hidden-element');
	}else{
		if(!$('#btn-excluir-aluno').hasClass('hidden-element')){
			$('#btn-excluir-aluno').addClass('hidden-element');
		}
	}
});

function consultar(){
	$.ajax({
		url : url_rotina + 'ListarAluno',
		data : $('FORM').serialize(),
		type : "POST",
		dataType : "html",
		success : function(consultaRetorno) {
			$('#consulta-resultado-aluno').html(consultaRetorno);
		}
	});
}

function redireciona(id){
	window.location.href = url_rotina + 'AlunoView&idControle=' + id;
}

function gravar(){
	if(validate()){
		$.ajax({
			url : url_rotina + 'GravarAtualizarAluno',
			data : $('FORM').serialize(),
			type : "POST",
			dataType : "json",
			success : function(jsonStatus) {
				if(jsonStatus != null && jsonStatus != 'undefined'){
					if(jsonStatus.msgERRO != null && jsonStatus.msgERRO != 'undefined'){
						alert(jsonStatus.msgERRO);
					}else{
						alert(jsonStatus.msgOK);
						if(jsonStatus.idAluno != null && jsonStatus.idAluno != '0' && jsonStatus.idAluno != undefined && jsonStatus.idAluno != 'undefined'){
							$('#idAluno').val(jsonStatus.idAluno);
							$('#btn-excluir-aluno').removeClass('hidden-element');
						}
					}
				}
			}
		});
	}
}

function excluir(){
	$.ajax({
		url : url_rotina + 'ExcluirAluno',
		data : $('FORM').serialize(),
		type : "POST",
		dataType : "json",
		success : function(jsonStatus) {
			if(jsonStatus != null && jsonStatus != 'undefined'){
				if(jsonStatus.msgERRO != null && jsonStatus.msgERRO != 'undefined'){
					alert(jsonStatus.msgERRO);
				}else{
					alert(jsonStatus.msgOK);
					$('#nmAluno').val('');
					$('#nrRg').val('');
					$('#dtNascimento').val('');
					$('#idAluno').val('0');
					$('#btn-excluir-aluno').addClass('hidden-element');
				}
			}
		}
	});
}

function validate() {
var retornoValidacao = true;
	$('.required').each(function(index, field) {
		$FIELD = $(this);
		$FIELD.removeClass('campo-obrigatorio');
		if ($FIELD.val() == null || $.trim(new String($FIELD.val())) == '') {
			$FIELD.addClass('campo-obrigatorio');
			retornoValidacao = false;
		}
	});
	
	return retornoValidacao;
}