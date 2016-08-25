<%@ include file="/html/init.jsp" %>

<style>
.running-panel-heading {
	background-color: #2D882D;
	color: #FFFFFF;
	border-radius: 0 10px 0 0;
}
.running-panel-body {
	background-color: #55AA55;
}
.running-panel-footer {
	background-color: #2D882D;
	color: #FFFFFF;
	border-radius: 0 0 0 10px;
}
.panel-heading-1 {
	color: #116611;
}
.panel {
	border-radius: 0 10px 0 10px;
}
</style>

<%	

List<DockerContainer> dockercontainers = DockerContainerLocalServiceUtil.getDockerContainers(-1, -1);
%>


<div class="jumbotron text-center">
	<h1>Tools</h1>
	<aui:button-row>
		<portlet:renderURL var="addToolURL">
			<portlet:param name="mvcPath" value="/html/toollist/edit.jsp" />
			<portlet:param name="task" value="addtool" />
		</portlet:renderURL>
		<aui:button value="Add Tool" onClick="<%= addToolURL.toString() %>"/>
		<portlet:renderURL var="createToolURL">
			<portlet:param name="mvcPath" value="/html/toollist/edit.jsp" />
			<portlet:param name="task" value="createtool" />
		</portlet:renderURL>
		<aui:button value="Create Tool" onClick="<%= createToolURL.toString() %>"/>
	</aui:button-row>
	<p id="demo"></p>
</div>

<div class="container">
	<div class="row">
		<%
		for(DockerContainer dockercontainer : dockercontainers) {
			%>
			<div class="col-xs-6 col-sm-4">
				<div class="panel">
					<div class="panel-heading running-panel-heading small">
						<%= dockercontainer.getDisplayName() %><br>
					</div>
					<div class="panel-body running-panel-body">
						<span class="panel-heading-1">Tool</span><br>
						<%= dockercontainer.getTool() %><br>
						<span class="panel-heading-1">Category</span><br>
						<%= dockercontainer.getCategory() %><br>
						<span class="panel-heading-1">Performance</span><br>
					</div>
					<div class="panel-footer running-panel-footer text-center small">
						<span id="show_more" dockerid="<%= dockercontainer.getDockerContainerId() %>">show more</span>
					</div>
				</div>
			</div>
			<%
		}
		%>
	</div>
</div>

<%
String portletResource = ParamUtil.getString(request, "portletResource");
String baseurl = themeDisplay.getURLCurrent().split("[?]")[0];
if(baseurl.equalsIgnoreCase("/")) {
	baseurl = "";
}
String showmoreURL = baseurl + "/-/dockercontainer/showmore/";
%>

<aui:script use="aui-base">
            A.all('#show_more').on(
               'click',
               function(event) {
                   Liferay.Util.selectEntity(
                     {
                        dialog: {
                           cache: false,
                           constrain: true,
                           modal: true,
                           width: 1000,
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_show_more' + event.target.getAttribute('dockerid'),
                        title: '',
                        uri: '<%= showmoreURL %>' + event.target.getAttribute('dockerid')
                     }
                  );
               }
            );
</aui:script>

<portlet:resourceURL var="resourceURL">
<portlet:param name="<%=Constants.CMD%>" value="docker_reload" />
</portlet:resourceURL>

<p id="demo"></p>

<aui:script use="aui-base,node,aui-datatable,aui-datatype,datatable-sort,aui-io-request">
var myVar = setInterval(myTimer, 30000);

function myTimer() {
	var d = new Date();
	document.getElementById("demo").innerHTML = d.toLocaleTimeString();
	AUI().use(
		'aui-datatable',
		'aui-datatype',
		'datatable-sort',
		'aui-io-request',
		'aui-base',
		function(Y) {
			Y.io.request('<%= resourceURL %>',{
				dataType: 'json',
				on: {
					failure: function() { 
		              	
		            },
					success: function() {
						alert(this.get('responseData'));
					}
				}
			});
		}
	);
}
</aui:script>
