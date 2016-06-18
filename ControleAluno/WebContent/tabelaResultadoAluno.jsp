<table class="table table-striped">
	<thead>
		<tr class="resultado">
			<th>Aluno</th>
			<th>RG</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${not empty listaAlunos}">
				<c:forEach var="aluno" items="${listaAlunos}">
					<tr class="resultado-consulta resultado"
						onclick="redireciona('<c:out value="${aluno.id}"/>');">
						<td><c:out value="${aluno.nomeAluno}" /></td>
						<td><c:out value="${aluno.numeroIdentidadeFormatado}" /></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="resultado-consulta resultado">
					<td colspan="2">Pesquisa sem resultado</td>
				</tr>
			</c:otherwise>
		</c:choose>
</table>