
<h2>成绩登记表</h2>
${request}
<div class="col-sm-12">
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-error">${f:h(errorMessage)}</div>
	</c:if>

	<div class="well">
		<a href="${pageContext.request.contextPath}/user/create?form"
			class="btn btn-primary">创建新成绩</a><br> <br>
		<form:form action="${pageContext.request.contextPath}/user/getVar"
			method="get" modelAttribute="userSearchForm"
			class="form-inline my-inline">
			<form:input path="name" class="form-control" />
			<input type="submit" value="计算统计结果" class="btn btn-default" />
		</form:form>
	</div>
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>方差</th>
				<th>平均值</th>
			</tr>
		</thead>
		<tbody>
		 <c:forEach var="user" items="${page.content}" begin="0" end="0" >
                <tr>
					<td>${f:h(user.password)}</td>
					<td>${f:h(user.birth)}</td>
				</tr>
         </c:forEach>
		</tbody>
	</table>
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>学号</th>
				<th>成绩</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${page.content}" begin="1">
				<tr>
					<td>${f:h(user.id)-1}</td>
					<td>${f:h(user.name)}</td>
					<td>${f:h(user.email)}</td>
					<td>${f:h(user.birth)}</td>
					<td><form:form
							action="${pageContext.request.contextPath}/user"
							class="form-inline">
							<input type="hidden" name="id" value="${f:h(user.id)}" />
							<input type="submit" class="btn btn-default"
								name="redirectToUpdate" value="更新" />
							<input type="submit" class="btn btn-danger"
								name="redirectToDelete" value="删除" />
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	

	<util:pagination page="${page}" query="name=${f:h(param.name)}" />
</div>
