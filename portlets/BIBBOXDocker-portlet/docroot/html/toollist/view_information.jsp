<%@ include file="/html/init.jsp" %>

<%
long dockerContainerId = ParamUtil.getLong(request, "dockerContainerId");
%>

<%
DockerContainer dockercontainer = DockerContainerLocalServiceUtil.getDockerContainer(dockerContainerId);
 
%>

<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<h1><%= dockercontainer.getDisplayToolName() %></h1>
		</div>
		<div class="col-xs-12 col-sm-6">
			General Information
			<div class="row">
				<div class="col-sm-6">
					Instance Name<br>
					<%= dockercontainer.getInstance() %>
				</div>
				<div class="col-sm-6">
					Instance URL<br>
					<%= dockercontainer.getUrl() %>
				</div>
				<div class="col-sm-12">
					Description<br>
					<%= dockercontainer.getDescription() %>
				</div>
			</div>
			Tool<br>
			<img alt="Logo" src="<%= dockercontainer.getLogourl() %>"><br>
			<div class="row">
				<div class="col-sm-6">
					Category<br>
					<%= dockercontainer.getCategory() %>
				</div>
				<div class="col-sm-6">
					Company<br>
					<%= dockercontainer.getCompany() %>
				</div>
				<div class="col-sm-6">
					Platform<br>
					<%= dockercontainer.getPlatform() %>
				</div>
				<div class="col-sm-6">
					License<br>
					<%= dockercontainer.getLicense() %>
				</div>
				<div class="col-sm-12">
					Description<br>
					<%= dockercontainer.getToolDescription() %>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-sm-6">Performance
		</div>
	</div>
</div>