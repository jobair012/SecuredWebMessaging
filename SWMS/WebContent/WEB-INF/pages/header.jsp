<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">

		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/home/inbox">Secured Web
			Messaging</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">

		<li><c:out value="${pageContext.request.userPrincipal.name}"></c:out>
		</li>

		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#"><i class="fa fa-user fa-fw"></i> User
						Profile</a></li>
				<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a></li>
				<li class="divider"></li>
				<li>
					<form action="${pageContext.request.contextPath}/logout"
						method="post" id="logoutForm">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form> <c:if test="${pageContext.request.userPrincipal.name != null}">

						<a href="javascript:formSubmit()"> <i
							class="fa fa-sign-out fa-fw"></i>Logout
						</a>

					</c:if>
				</li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div> <!-- /input-group -->
				</li>

				<li><a href="${pageContext.request.contextPath}/home/inbox"><i
						class="fa fa-envelope fa-fw"></i>&nbsp;&nbsp;Inbox</a></li>
				<li><a href="${pageContext.request.contextPath}/home/compose"><i
						class="fa fa-edit fa-fw"></i>&nbsp;&nbsp;Compose</a></li>
				<li><a href="${pageContext.request.contextPath}/home/sent"><i
						class="fa fa-mail-forward fa-fw"></i>&nbsp;&nbsp;Sent</a></li>
				<li><a href="${pageContext.request.contextPath}/home/trash"><i
						class="fa fa-archive fa-fw"></i>&nbsp;&nbsp;Trash</a></li>
				<li><a href="${pageContext.request.contextPath}/home/keys"><i
						class="fa fa-key fa-fw"></i>&nbsp;&nbsp;Keys</a></li>

			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
