<%@ include file="/html/init.jsp" %>

<%
String baseurl_cfg = GetterUtil.getString(portletPreferences.getValue("baseurl", "http://datastore.development.bibbox.org/js"));



String instanceID = ParamUtil.getString(request, "par1");
String componentID = ParamUtil.getString(request, "par2");
%>

instanceID: <%= instanceID %><br>
componentID: <%= componentID %><br>

<link rel="stylesheet" type="text/css" href="<%=baseurl_cfg%>/css/apps.css">

<div id="bibbox-wrapper" par1="instance" par2="<%= instanceID %>" par3="<%= componentID %>"></div>
  
<script type="text/javascript" src="<%=baseurl_cfg%>/js/helpers.js"></script>
<script src="<%=baseurl_cfg%>/js/apps.js"></script>

