<%@ include file="/html/init_config.jsp" %>

<%
String baseurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseurl", "http://datastore.development.bibbox.org/js"));
String baseactivityurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseactivityurl", "http://activities.demo.bibbox.org"));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
   		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<!-- Record Name -->

	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>