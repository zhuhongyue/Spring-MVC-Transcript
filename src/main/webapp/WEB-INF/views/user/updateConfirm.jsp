<div class="col-sm-12">
	<form:form action="${pageContext.request.contextPath}/user/update"
		modelAttribute="userForm" class="form-horizontal">
		<fieldset>
			<legend>Update User</legend>
			<div class="form-group">
				<form:label path="name" class="col col-sm-2 control-label">ID</form:label>
				<div class="col col-sm-10">
					${f:h(userForm.id)}
					<form:input path="id" type="hidden" />
					<form:errors path="id" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="name" class="col col-sm-2 control-label">姓名</form:label>
				<div class="col col-sm-10">
					${f:h(userForm.name)}
					<form:hidden path="name" />
					<form:errors path="name" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="email" class="col col-sm-2 control-label">学号</form:label>
				<div class="col col-sm-10">
					${userForm.email}
					<form:hidden path="email" />
					<form:errors path="email" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="birth" class="col col-sm-2 control-label">成绩</form:label>
				<div class="col col-sm-10">
					${userForm.birth} 
					<form:hidden path="birth" />
					<form:errors path="birth" cssClass="text-danger" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col col-sm-10 col-sm-offset-2">
        <form:hidden path="id" />
        <form:hidden path="version" />
        <input type="submit" class="btn btn-primary" name="update"
          value="更新" /> <input type="submit" class="btn btn-default"
          name="redo" value="返回" />
				</div>
			</div>
		</fieldset>
	</form:form>
</div>