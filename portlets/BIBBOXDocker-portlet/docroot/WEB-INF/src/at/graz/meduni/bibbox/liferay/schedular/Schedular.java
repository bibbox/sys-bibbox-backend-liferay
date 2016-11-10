package at.graz.meduni.bibbox.liferay.schedular;

import java.util.List;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import at.graz.meduni.bibbox.helper.DockerHelper;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;

/**
 * Portlet implementation class Schedular
 */
public class Schedular implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		System.out.println("Shedular");
		String dockerps = DockerHelper.getDockerPSListening();
		List<ApplicationInstance> applicationinstances = ApplicationInstanceLocalServiceUtil.getActiveApplicationInstances();
		for(ApplicationInstance applicationinstance : applicationinstances) {
			List<ApplicationInstanceContainer> containers = applicationinstance.getContainersNeedToRun();
			boolean running = true;
			for(ApplicationInstanceContainer container : containers) {
				if(!dockerps.contains(container.getContainerName())) {
					running = false;
				}
			}
			applicationinstance.setStatus(running);
			ApplicationInstanceLocalServiceUtil.updateApplicationInstance(applicationinstance);
		}
	}
 

}
