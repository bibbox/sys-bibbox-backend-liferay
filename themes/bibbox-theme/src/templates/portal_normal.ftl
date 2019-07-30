<!doctype html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

    <!--<link href="//db.onlinewebfonts.com/c/8e61b0b984ebefdb7dbb89d0d2b8dbdf?family=VerdanaProW01-Light" rel="stylesheet" type="text/css"/>-->

	<@liferay_util["include"] page=top_head_include />

	<#assign bibbox_baseurl = "">
	<#assign counter = 0>
	<#assign tmpstring = theme_display.getURLHome()?split("/")>
	<#assign bibbox_baseurl = tmpstring[0] + "//" + tmpstring[2]>

	<link rel="stylesheet" type="text/css" href="${bibbox_baseurl}/datastore/js/css/activity.css">
	
	
	<style id="hide-controls">
		.control-menu,
		.sidenav-menu-slider {
		    display: none;
		}
		#wrapper {
		    padding-left: 0 !important;
		    margin-top: 0 !important;
		}
	</style>
</head>

<body class="${css_class}">

	<script>
		var datastore = "${bibbox_baseurl}/datastore";
		var activitydomain = "${bibbox_baseurl}/sys-activities";
	</script>

					

<@liferay_ui["quick-access"] contentid="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div id="wrapper">
	<header class="container-fluid-1280" id="banner" role="banner">
		<div class="row">
			<div class="navbar-header" id="heading">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="64" src="${site_logo}" width="64" />
				</a>

				<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					${site_name}
				</span>

				<#if is_setup_complete>
					<button aria-controls="navigation" aria-expanded="false" class="collapsed navbar-toggle" data-target="#navigationcollapse" data-toggle="collapse" type="button">
						<span class="icon-bar"></span>

						<span class="icon-bar"></span>

						<span class="icon-bar"></span>
					</button>
					
					<#if is_signed_in>
						<a id="my-profile" url="${my_account_url}">
							<img src="${user.getPortraitURL(themeDisplay)}" alt="My Profile" />
						</a>
						<a href="${sign_out_url}" id="sign-out" rel="nofollow"> </a>
					<#else>
						<div class="pull-right user-personal-bar">
							<@liferay.user_personal_bar />
						</div>
					</#if>
				</#if>
			</div>

			<#include "${full_templates_path}/navigation.ftl" />
		</div>
	</header>

	<section class="container-fluid-1280" id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			<#if portletdisplay??>
				${portletdisplay.recycle()}

				${portletdisplay.settitle(the_title)}

				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
		</#if>
	</section>

	<footer class="container-fluid-1280" id="footer" role="contentinfo">
		<div class="row">
			<div class="footer-copyright">
				<a href="http://bibbox.org/" rel="external" target="_blank">© BIBBOX 2017</a>
			</div>
			<div class="footer-menu">
				<ul>
					<li><a href="/web/guest/contact">Contact</a></li>
					<li><a href="/web/guest/partners">Partners</a></li>
					<li><a href="/web/guest/imprint">Imprint</a></li>
				</ul>
			</div>
            <div class="footer-partners">
                <a href="http://www.b3africa.org/" rel="external" target="_blank">
					<img class="footer-partner-item" src="${images_folder}/b3africa.png" />
				</a>
                <a href="http://bbmri-eric.eu/" rel="external" target="_blank">
                    <img class="footer-partner-item" src="${images_folder}/bbmri-eric.png" />
                </a>
            </div>
		</div>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<script type="text/javascript" src="${javascript_folder}/custom.js" charset="utf-8"></script>
<script>
	function makeid() {
	    var text = "";
	    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	    for( var i=0; i < 5; i++ )
	        text += possible.charAt(Math.floor(Math.random() * possible.length));
	
	    return text;
	}
</script>

<#if is_signed_in>
	<script type="text/javascript" src="${bibbox_baseurl}/datastore/js/js/helpers.js"></script>
	<script src="${bibbox_baseurl}/datastore/js/js/activity.js"></script>
	<script>
		var account_url = '${my_account_url}';
		
		account_url = account_url.replace('maximized', 'pop_up') + '&_com_liferay_my_account_web_portlet_MyAccountPortlet_mvcRenderCommandName=%2Fusers_admin%2Fedit_user';
		
		jQuery('#my-profile').click(function(e) {
			e.preventDefault();
			Liferay.Util.selectEntity({
				dialog: {
					constrain: true,
					modal: true,
					width: 1000
				},
				id: makeid(),
				title: 'Edit my account.',
				uri: account_url
			});
		});
	</script>
	
	<#if is_admin>
		<script>
			jQuery('#hide-controls').remove();
		</script>
	</#if>
</#if>
</body>

</html>