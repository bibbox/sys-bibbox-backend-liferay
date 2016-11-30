package at.graz.meduni.bibbox.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DockerHelper {
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.helper.DockerHelper";
	
	public static String getDockerPSListening() {
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("docker", "ps");
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			while ((log = reader1.readLine()) != null) 
			{
				//TODO Exception for error
				System.out.println(log);
			}
			
			String lines = "";
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((line = reader.readLine()) != null) {
				lines += "| " + line;
			}
			return lines;
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getDockerPSListening()", "Error reading docker ps command."));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getDockerPSListening()", "Error reading docker ps command."));
			e.printStackTrace();
		}
		return "";
	}
}
