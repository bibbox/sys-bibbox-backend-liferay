<%@ include file="/html/init.jsp" %>

<%
String baseportalurl_cfg = BibboxConfigReader.getBaseURL();
String url_scheme = BibboxConfigReader.getBaseURLSchema();
String baseurl_cfg = url_scheme + baseportalurl_cfg + "/datastore/js";
String baseactivityurl_cfg = url_scheme + baseportalurl_cfg + "/sys-activities";
%>

<link rel="stylesheet" type="text/css" href="<%= baseurl_cfg %>/css/apps.css">

<div id="activity-wrapper"></div>

<script>
	var activitydomain = "<%= baseactivityurl_cfg %>";
</script>

<script type="text/javascript" src="<%= baseurl_cfg %>/js/helpers.js"></script>
<script src="<%= baseurl_cfg %>/js/activity.js"></script>