var url_rotina = '/ControleAluno/controller?command=';

function sair() {
	$.ajax({
		url : url_rotina + 'Logout',
		data : $('FORM').serialize(),
		type : "POST",
		dataType : "json",
		success : function(jsonStatus) {
			if (jsonStatus != null && jsonStatus != 'undefined') {
				if (jsonStatus.msgERRO != null
						&& jsonStatus.msgERRO != 'undefined') {
					alert(jsonStatus.msgERRO);
				} else {
					window.location.href = '/ControleAluno/login.jsp';
				}
			}
		}
	});
}