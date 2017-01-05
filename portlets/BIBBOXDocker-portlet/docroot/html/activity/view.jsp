<%@ include file="/html/init.jsp" %>

<%
String baseportalurl_cfg = BibboxConfigReader.getBaseURL();
String baseurl_cfg = "http://datastore." + baseportalurl_cfg + "/js";
String baseactivityurl_cfg = "http://activities."+ baseportalurl_cfg;
%>

<link rel="stylesheet" type="text/css" href="<%=baseurl_cfg%>/css/apps.css">

<div id="activity-wrapper"></div>

<script>
	var activitydomain = "<%= baseactivityurl_cfg %>";
	var datastore = "<%= "http://datastore." + baseportalurl_cfg %>";
</script>

<script type="text/javascript" src="<%=baseurl_cfg%>/js/helpers.js"></script>
<script src="<%=baseurl_cfg%>/js/activity.js"></script>