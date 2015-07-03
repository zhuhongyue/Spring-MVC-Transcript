<div class="col-sm-12">
	<form:form action="${pageContext.request.contextPath}/user/update"
		modelAttribute="userForm" class="form-horizontal">
		<fieldset>
			<legend>修改成绩</legend>
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
					<form:input path="name" class="form-control" />
					<form:errors path="name" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="email" class="col col-sm-2 control-label">学号</form:label>
				<div class="col col-sm-10">
					<form:input path="email" class="form-control" />
					<form:errors path="email" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="birth" class="col col-sm-2 control-label">成绩</form:label>
				<div class="col col-sm-10">
					<form:input path="birth" class="form-control" />
					<form:errors path="birth" cssClass="text-danger" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col col-sm-10 col-sm-offset-2">
					<form:hidden path="version" />
					<form:errors path="version" cssClass="text-danger" />
					<input type="submit" class="btn btn-primary" name="confirm"
						value="确认" /> <input type="submit" class="btn btn-default"
						name="redirectToList" value="返回" />
				</div>
			</div>
		</fieldset>
	</form:form>
</div>