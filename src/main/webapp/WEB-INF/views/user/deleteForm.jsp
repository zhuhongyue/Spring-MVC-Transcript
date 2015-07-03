
<div class="col-sm-12">
	<form:form action="${pageContext.request.contextPath}/user/delete"
		modelAttribute="userForm" class="form-horizontal">
		<fieldset>
			<legend>删除成绩</legend>
			<div class="form-group">
				<form:label path="name" class="col col-sm-2 control-label">姓名</form:label>
				<div class="col col-sm-10">${f:h(userForm.name)}</div>
			</div>
			<div class="form-group">
				<form:label path="email" class="col col-sm-2 control-label">学号</form:label>
				<div class="col col-sm-10">${userForm.email}</div>
			</div>
			<div class="form-group">
				<form:label path="birth" class="col col-sm-2 control-label">成绩</form:label>
				<div class="col col-sm-10">
					 ${userForm.birth} 
				</div>
			</div>
			
			<div class="form-group">
				<div class="col col-sm-10 col-sm-offset-2">
					<form:hidden path="id" value="${f:h(user.id)}" />
					<form:hidden path="version" value="${f:h(user.version)}" />
					<input type="submit" class="btn btn-danger" name="delete"
						value="删除" /> <input type="submit" class="btn btn-default"
						name="redirectToList" value="返回" />
				</div>
			</div>
		</fieldset>
	</form:form>
</div>