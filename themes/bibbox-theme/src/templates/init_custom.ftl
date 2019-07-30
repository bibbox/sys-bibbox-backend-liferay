<#--
This file allows you to override and define new FreeMarker variables.
-->
<#assign my_sites_text = languageUtil.get(locale, "my-sites") />
<#assign myroles = themeDisplay.getUser().getRoles() />
<#assign is_admin = false />
<#list myroles as myrole>
   <#if myrole.getName()?contains("Administrator")>
      <#assign is_admin = true />
   </#if>
</#list>