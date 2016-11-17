package at.graz.meduni.bibbox.liferay.backgroundtasks;

import java.util.Map;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;

public class InstallApplicationBG extends BaseBackgroundTaskExecutor {

	public InstallApplicationBG() {
		setBackgroundTaskStatusMessageTranslator(new InstallBackgroundTaskStatusMessageTranslator());
	}
	
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		System.out.println("execute");
		Map taskContextMap = backgroundTask.getTaskContextMap();
		//BackgroundTaskManagerUtil.addBackgroundTaskAttachment(userId, backgroundTask.getBackgroundTaskId(), fileName, file);
		return new BackgroundTaskResult(BackgroundTaskConstants.STATUS_SUCCESSFUL);
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		System.out.println("getBackgroundTaskDisplay");
		return new InstallBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		System.out.println("clone");
		InstallApplicationBG installApplicationBG = new InstallApplicationBG();
		installApplicationBG.setBackgroundTaskStatusMessageTranslator(getBackgroundTaskStatusMessageTranslator());
		installApplicationBG.setIsolationLevel(getIsolationLevel());
		return installApplicationBG;
	}

}
