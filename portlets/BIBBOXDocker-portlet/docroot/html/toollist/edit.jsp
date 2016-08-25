<%@ include file="/html/init.jsp" %>

<%
String task = ParamUtil.getString(request, "task");
String redirect = ParamUtil.getString(request, "redirect");
long dockerContainerId = ParamUtil.getLong(request, "dockerContainerId");

String toolsNames_cfg = "Liferay;bika;LabKey;phenotips;OpenSpecimen;molgenis;iRods;OrientDB";
String category_cfg = "LIMS/BIMS;Data Integration/Data Warehouse;Study Management";

DockerContainer dockercontainer = null;
if(dockerContainerId > 0) {
	dockercontainer = DockerContainerLocalServiceUtil.getDockerContainer(dockerContainerId);
}

String formActionURL = "addDockerContainer";
if(task.equals("addtool")) {
	formActionURL = "addDockerContainer";
}
if(task.equals("createtool")) {
	formActionURL = "createDockerContainer";
}
if(task.equals("updatetool")) {
	formActionURL = "updateDockerContainer";
}

%>

<div class="jumbotron text-center">
	<h1>Tools</h1>
	<h6><%= task %></h6>
</div>

<aui:model-context bean="<%= dockercontainer %>" model="<%= DockerContainer.class %>" />
<portlet:actionURL name="<%= formActionURL %>" var="editDockerContainerURL" windowState="normal" />
<aui:form action="<%= editDockerContainerURL %>" method="POST" name="fm">
	<aui:input type="hidden" name="dockerContainerId" value='<%= dockercontainer == null ? "" : dockercontainer.getDockerContainerId() %>'/>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<div class="container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<aui:input name="displayName" helpMessage="The name showen at the tile view." />
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:input name="displayToolName" helpMessage="The name showen at the show more view." />
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:input name="logourl" helpMessage="The url of the tools logo." />
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:select name="toolName">
							<%
							for(String toolsname : toolsNames_cfg.split(";")) {
								%>
								<aui:option value="<%= toolsname %>"><%= toolsname %></aui:option>
								<%
							}
							%>
						</aui:select>
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:input name="instance" />
					</div>
					
					<div class="col-xs-12 col-sm-6">
						<aui:input name="subdomain" showRequiredLabel="<%= true %>" helpMessage="The subdomain for the proxy entry." />
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:input name="url"/>
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:input name="ip" />
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:input name="port" />
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:select name="category">
							<%
							for(String category : category_cfg.split(";")) {
								%>
								<aui:option value="<%= category %>"><%= category %></aui:option>
								<%
							}
							%>
						</aui:select>
					</div>
					<div class="col-xs-12 col-sm-6">
						<aui:input name="tool" />
					</div>
					<div class="col-xs-12">
						<aui:input name="description" />
					</div>
					<div class="col-xs-12 col-sm-4">
						<aui:input name="platform" />
					</div>
					<div class="col-xs-12 col-sm-4">
						<aui:input name="company" />
					</div>
					<div class="col-xs-12 col-sm-4">
						<aui:input name="license" />
					</div>
					<div class="col-xs-12">
						<aui:input name="toolDescription" />
					</div>
				</div>
			</div>
		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>