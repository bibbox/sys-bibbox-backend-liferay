package at.graz.meduni.bibbox.helper;

import java.lang.Thread.State;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class UpdateGitRepositoriesBackgroundTask implements Runnable {
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.helper.UpdateGitRepositoriesBackgroundTask";

	private static Thread thred = null;
	private String threadName;
	private UpdateGitRepository updategitrepository_ = new UpdateGitRepository();
	   
	public UpdateGitRepositoriesBackgroundTask(String name) {
		threadName = name;
	}
	
	@Override
	public void run() {
		updateApplicationStoreGitRepoitories();
	}
	
	public void start() {
		if(thred == null) {
			thred = new Thread (this, threadName);
			thred.start();
		} else if(thred.getState() == State.TERMINATED) {
			thred = new Thread (this, threadName);
			thred.start();
		}
	}
	
	private void updateApplicationStoreGitRepoitories() {
		JSONArray applications = BibboxConfigReader.getBibboxApplicationStoreApplicationList();
		for(int index = 0; index < applications.length(); index ++) {
			try {
				JSONObject application = JSONFactoryUtil.createJSONObject(applications.get(index).toString());
				String applicationname = application.getString("github_name");
				updateApplicationRepository(applicationname);
				updategitrepository_.createAllTagFolders(BibboxConfigReader.getApplicationStorePWD(), applicationname);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void updateApplicationRepository(String applicationname) {
		String applicationfolder = BibboxConfigReader.getApplicationFolder(applicationname, "development");
		if(updategitrepository_.checkIfLocalRepositoryExists(applicationfolder)) {
			updategitrepository_.updateLocalGitRepository(applicationfolder);
		} else {
			updategitrepository_.cloneRepositoryToFolder(applicationfolder, applicationname);
		}
	}

}
