<%@ include file="/html/init.jsp" %>

<%
String baseportalurl_cfg = BibboxConfigReader.getBaseURL();
String baseurl_cfg = "http://" + baseportalurl_cfg + "/datastore/js";
String baseactivityurl_cfg = "http://"+ baseportalurl_cfg + "/sys-activities";
%>

<link rel="stylesheet" type="text/css" href="/datastore/js/css/apps.css">

<div id="activity-wrapper"></div>

<script>
	var activitydomain = "<%= baseactivityurl_cfg %>";
</script>

<script type="text/javascript" src="/datastore/js/js/helpers.js"></script>
<script src="/datastore/js/js/activity.js"></script>