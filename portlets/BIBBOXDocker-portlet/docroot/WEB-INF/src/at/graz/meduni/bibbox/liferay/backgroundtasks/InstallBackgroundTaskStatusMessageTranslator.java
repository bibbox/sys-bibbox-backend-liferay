package at.graz.meduni.bibbox.liferay.backgroundtasks;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusMessageTranslator;
import com.liferay.portal.kernel.messaging.Message;

public class InstallBackgroundTaskStatusMessageTranslator implements BackgroundTaskStatusMessageTranslator {

	@Override
	public void translate(BackgroundTaskStatus backgroundTaskStatus, Message message) {
		System.out.println("translate message " + message.getDestinationName());
		backgroundTaskStatus.setAttribute("xy", doTranslate(message.getString("xy")));
	}
	
	private String doTranslate(String message) {
		return message;
	}

}
