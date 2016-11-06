package at.graz.meduni.bibbox.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil;

public class PortRegister {
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.helper.PortRegister";
	
	private static long port_ = -1;
	
	public static synchronized long getNextAvailablePort() {
		if(port_ == -1) {
			setInitailPort();
		}
		port_ ++;
		while(!checkIfPortInUser()) {
			port_++;
		}
		return port_;
	}
	
	private static void setInitailPort() {
		port_ = 9000;
		List<ApplicationInstancePort> applicationinstanceports = ApplicationInstancePortLocalServiceUtil.getApplicationInstancePorts(-1, -1);
		for(ApplicationInstancePort applicationinstanceport : applicationinstanceports) {
			if(port_ < applicationinstanceport.getPort()) {
				port_ = applicationinstanceport.getPort();
			}
		}
	}
	
	private static boolean checkIfPortInUser() {
		try {
			// Linux: netstat -lnt | awk '$6 == "LISTEN" && $4 ~ ".445"'
			// Mac: netstat -anp tcp | awk '$6 == "LISTEN" && $4 ~ "\.445"'
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "netstat -lnt tcp | awk '$6 == \"LISTEN\" && $4 ~ \"\\." + port_ + "\"'");
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			if(reader.readLine() != null) {
				return false;
			}
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "checkIfPortInUser()", "Error checking if port available. Port:" + port_));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "checkIfPortInUser()", "Error checking if port available. Port:" + port_));
			e.printStackTrace();
		}
		return true;
	}
}
