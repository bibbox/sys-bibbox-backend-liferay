<%@ include file="/html/init_config.jsp" %>

<%
String baseurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseurl", "http://datastore.development.bibbox.org/js"));
String firstparameter_cfg = GetterUtil.getString(portletPreferences.getValue("firstparameter", "%"));
String baseportalurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseportalurl", "demo.bibbox.org"));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
   		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<!-- Record Name -->
		<aui:input name="preferences--firstparameter--" label="First Parameter (% will only use url parameters)" type="text" value ="<%= firstparameter_cfg %>" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>