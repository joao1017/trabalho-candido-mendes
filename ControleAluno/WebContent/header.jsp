<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/include/images/candido.jpg"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/vendor/jquery-ui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/bootstrap-theme.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/bootstrap.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/menu-dropdown.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/menu.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/global.css">
	
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/vendor/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/vendor/jquery.placeholder.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/vendor/jquery.ui.datepicker-pt-BR.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/vendor/jquery-ui.custom.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/input-mask.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/jquery.blockui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/menu.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/global.js"></script>
	<script>
	$(document).ready(function(){
		$(document).ajaxStart(function(){
			  $.blockUI({ 
		            message: $('#domMessage').html()
		        });
		});
		$(document).ajaxComplete($.unblockUI);
	});
	</script>
<title>Sistema de Controle de Aluno</title>
</head>
<body>
	<div>
		<div id="elemento-logo" onclick="location.href='/ControleAluno/index.jsp';">
			<img src="<%=request.getContextPath()%>/include/images/candido.jpg" id="image-logo"></img>
		</div>
	</div>
	<c:if test="${not empty usuarioLogado}">
		<div id='cssmenu'>
			<ul>
			   <li><a href="/ControleAluno/consultaAluno.jsp" class="tabact">Aluno</a></li>
			    <li><a href="#" onclick="sair();" class="tabact">Sair</a></li>
			</ul>
		</div>
	</c:if>	
		<div id="domMessage" style="display:none">
		    <img id="loader" src="<%=request.getContextPath()%>/include/images/loading.gif" />
		</div>
</body>
</html>	