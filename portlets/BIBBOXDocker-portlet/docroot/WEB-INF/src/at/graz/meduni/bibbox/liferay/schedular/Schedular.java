package at.graz.meduni.bibbox.liferay.schedular;

import java.util.List;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import at.graz.meduni.bibbox.helper.DockerHelper;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;

/**
 * Portlet implementation class Schedular
 */
public class Schedular implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		String dockerps = DockerHelper.getDockerPSListening();
		List<ApplicationInstanceContainer> containers = ApplicationInstanceContainerLocalServiceUtil.getApplicationInstanceContainers(-1, -1);
		for(ApplicationInstanceContainer container : containers) {
			if(dockerps.contains(container.getContainerName() + "|")) {
				container.setRunning(true);
			} else {
				container.setRunning(false);
			}
			if(container.ApplicationInstanceExists()) {
				ApplicationInstanceContainerLocalServiceUtil.updateApplicationInstanceContainer(container);
			} else {
				ApplicationInstanceContainerLocalServiceUtil.deleteApplicationInstanceContainer(container);
			}
			
		}
	}
 

}
