<%@ include file="/WEB-INF/include.jsp"%>

<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			
			<c:url value="/" var="indexUrl" />
			<a class="navbar-brand" href="${ indexUrl }">Automation</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<!--  
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/contact" />">Contact</a></li>
				<li><a href="<c:url value="/faq" />">FAQ</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul>
				</li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						Welcome <sec:authorize access="isAuthenticated()">${ username } </sec:authorize><span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<sec:authorize access="!isAuthenticated()">
							<li><a href="<c:url value="/login" />">Login</a></li>
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
							<li><a href="<c:url value="/logout" />">Logout</a></li>
						</sec:authorize>
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</li>
			</ul>
		</div>
		 -->
	</div>
</nav>