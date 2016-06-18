var url_rotina = '/ControleAluno/controller?command=';

$(document).ready(function() {
	$('#btn-login').click(function() {
		login();
	});
});

function login() {
	if (validate()) {
		$.ajax({
			url : url_rotina + 'Login',
			data : $('FORM').serialize(),
			type : "POST",
			dataType : "json",
			success : function(jsonStatus) {
				if (jsonStatus != null && jsonStatus != 'undefined') {
					if (jsonStatus.msgERRO != null && jsonStatus.msgERRO != 'undefined') {
						alert(jsonStatus.msgERRO);
					} else {
						window.location.href = '/ControleAluno/index.jsp';
					}
				}
			}
		});
	}
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