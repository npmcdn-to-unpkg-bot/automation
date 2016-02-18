<%@ include file="/WEB-INF/include.jsp"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">

		<noscript>
			<div class="alert alert-danger">Please enable javascript, it is required for this application to function properly.</div>
		</noscript>
		<form class="form-horizontal" role="form" action="<c:url value="/login" />" method="post">
			<fieldset>
				
				<legend>Login</legend>
				
			
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">Username</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="username" placeholder="Username" autocomplete="off" autocapitalize="off" required spellcheck="false"/>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" name="password" placeholder="Password" autocomplete="off" autocapitalize="off" required spellcheck="false"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> 
						<input type="checkbox" id="remember-me" name="remember_me" value="true"/>Remember me
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Login</button>
					</div>
				</div>
	
				<c:if test="${ error eq true}">
					<div class="alert alert-danger">
						Your login attempt was not successful, try again. <br />
						<c:out value="${ SPRING_SECURITY_LAST_EXCEPTION.message }" />
					</div>
				</c:if>
			</fieldset>

		</form>
	</div>
</div>