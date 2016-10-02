package at.graz.meduni.bibbox.liferay.portlet.docker;

import java.io.IOException;
import java.net.URI;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.RemoteApiVersion;
import com.github.dockerjava.core.SSLConfig;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.AuthConfigurations;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DockerClientBuilder;
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
	
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		String cmd = request.getParameter(Constants.CMD);
		System.out.println("CMD: " + cmd);
		if(cmd.equals("docker_reload")) {	
			DockerClient dockerClient = DockerClientBuilder.getInstance("tcp://10.15.1.151:2375").build();
			System.out.print(dockerClient.versionCmd());
			Info info = dockerClient.infoCmd().exec();
			System.out.print(info);
			response.getPortletOutputStream().write(info.toString().getBytes());
		} else {
			String result = "falsch";
			response.getPortletOutputStream().write(result.getBytes());
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
