package at.graz.meduni.bibbox.liferay.portlet.docker;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import com.liferay.portal.kernel.util.Constants;

import at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer;
import at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerLocalServiceUtil;

/**
 * Portlet implementation class ToolList
 */
public class ToolList extends MVCPortlet {
	
	public void serveResource(ResourceRequest request, ResourceResponse response) {
		String cmd = request.getParameter(Constants.CMD);
		System.out.println("CMD: " + cmd);
		if(cmd.equals("docker_reload")) {
		}
	}
	
	public void addDockerContainer(ActionRequest request, ActionResponse response) {
		DockerContainer dockercontainer = DockerContainerLocalServiceUtil.dockerContainerFromRequest(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		dockercontainer.setDockerContainerId(CounterLocalServiceUtil.increment());
		dockercontainer.setCompanyId(themeDisplay.getCompanyId());
		dockercontainer.setUserId(themeDisplay.getUserId());
		dockercontainer.setUserName(themeDisplay.getUser().getFullName());
		dockercontainer.setCreateDate(new Date());
		dockercontainer.setModifiedDate(new Date());
		DockerContainerLocalServiceUtil.addDockerContainer(dockercontainer);
	}
	
	public void createDockerContainer(ActionRequest request, ActionResponse response) {
		
	}

	public void updateDockerContainer(ActionRequest request, ActionResponse response) {
		
	}

}
