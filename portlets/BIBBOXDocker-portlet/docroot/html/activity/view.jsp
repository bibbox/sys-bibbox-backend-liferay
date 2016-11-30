<%@ include file="/html/init.jsp" %>

<%
String baseurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseurl", "http://datastore.development.bibbox.org/js"));
String baseactivityurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseactivityurl", "http://activities.demo.bibbox.org"));
%>

<link rel="stylesheet" type="text/css" href="<%=baseurl_cfg%>/css/apps.css">

<div id="activity-wrapper"></div>

<script>
	var activitydomain = "<%= baseactivityurl_cfg %>";
</script>

<script type="text/javascript" src="<%=baseurl_cfg%>/js/helpers.js"></script>
<script src="<%=baseurl_cfg%>/js/activity.js"></script>