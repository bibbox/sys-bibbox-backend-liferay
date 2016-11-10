<%@ include file="/html/init.jsp" %>

<%
String baseurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseurl", "http://datastore.development.bibbox.org/js"));
%>

<link rel="stylesheet" type="text/css" href="<%=baseurl_cfg%>/css/apps.css">

<div id="bibbox-wrapper"></div>

<script type="text/javascript" src="http://cdn.tinymce.com/4/tinymce.min.js"></script>
<script type="text/javascript" src="<%=baseurl_cfg%>/js/helpers.js"></script>
<script src="<%=baseurl_cfg%>/js/apps.js"></script>

