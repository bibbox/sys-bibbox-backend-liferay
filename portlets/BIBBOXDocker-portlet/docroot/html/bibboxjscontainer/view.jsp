<%@ include file="/html/init.jsp" %>

<%
String baseurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseurl", "http://datastore.development.bibbox.org/js"));
String firstparameter_cfg = GetterUtil.getString(portletPreferences.getValue("firstparameter", "%"));
String baseportalurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseportalurl", "demo.bibbox.org"));
%>

<link rel="stylesheet" type="text/css" href="<%=baseurl_cfg%>/css/apps.css">

<div id="bibbox-wrapper"></div>


 
<script>
	var basedomain = "<%= baseportalurl_cfg %>";
	var datastore = "<%= "http://datastore." + baseportalurl_cfg %>";
   	var params = {
		<% 
		int parcounter = 1;
		if(!firstparameter_cfg.equals("%")) {
			%>
			param<%= parcounter %>: "<%= firstparameter_cfg %>",
			<%
			parcounter++;
		}
		String seperator = "";
		for(int readcounter = 1; readcounter <= 20; readcounter ++) {
			String parameter = ParamUtil.getString(request, "par" + readcounter);
			if(!parameter.equals("")) {
				%>
				<%= seperator %>param<%= parcounter %>: "<%= parameter %>"
				<%	
				seperator = ",";
			} else {
				break;
			}
			parcounter++;
		}
		%>
   };
</script>

<script type="text/javascript" src="http://cdn.tinymce.com/4/tinymce.min.js"></script>
<script type="text/javascript" src="<%=baseurl_cfg%>/js/helpers.js"></script>
<script src="<%=baseurl_cfg%>/js/apps.js"></script>

