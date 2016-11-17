package at.graz.meduni.bibbox.threadtasks;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTaskController {

	private static ExecutorService executor = null;
	
	public static void addNewTast(String taskname, String tasktype, HashMap<String, String> config) {
		if(executor == null) {
			executor = Executors.newFixedThreadPool(5);
		}
		if(tasktype.equalsIgnoreCase("InstallApplicationTask")) {
			executor.execute(new InstallApplicationTask(taskname, config));
		}
	}
}
