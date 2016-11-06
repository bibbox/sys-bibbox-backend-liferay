package at.graz.meduni.bibbox.helper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class BibboxConfigReader {
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.helper.BibboxConfigReader";
	
	private static String bibboxconfigfile_ = null;
	private static String applicationstorefolder_ = null;
	private static String instancefolder_ = null;
	private static String baseurl_ = null;
	
	public static String getApplicationStorePWD() {
		if(applicationstorefolder_ == null) {
			getBibboxApplicationStorePWDfromConfig();
		}
		return applicationstorefolder_;
	}
	
	public static String getInstancePWD() {
		if(instancefolder_ == null) {
			getBibboxInstancePWDfromConfig();
		}
		return instancefolder_;
	}

	public static JSONArray getBibboxApplicationStoreApplicationList() {
		try {
			return JSONFactoryUtil.createJSONArray(readApplicationsStoreJsonFile(getApplicationStorePWD() + "/application-store/applications.json"));
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getBibboxApplicationStoreApplicationList()", "Error reading bibbox applications.json file."));
			e.printStackTrace();
		}
		return JSONFactoryUtil.createJSONArray();
	}
	
	public static String readApplicationsStoreJsonFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = null;
			try {
			    sb = new StringBuilder();
			    String line = br.readLine();
	
			    while (line != null) {
			        sb.append(line);
			        line = br.readLine();
			    }
			} finally {
			    br.close();
			}
			return sb.toString();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "readApplicationsStoreJsonFile(String filename)", "Error reading application store jason file. Path:" + filename));
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getBaseURL() {
		if(baseurl_ == null) {
			getBaseURLfromConfig();
		}
		return baseurl_;
	}
	
	public static String getApplicationFolder(String applicationname, String version) {
		return getApplicationStorePWD() + "/" + applicationname + "/blob/" + version;
	}
	
	private static void getBibboxApplicationStorePWDfromConfig() {
		try {
			Properties bibboxproperties = new Properties();
			InputStream is = new FileInputStream(getLiferayConfigForBibboxConfigFile());
			bibboxproperties.load(is);
			String basepwd = bibboxproperties.getProperty("bibboxdir").replaceAll("\"", "");
			String folder = bibboxproperties.getProperty("bibboxapplicationstorefolder").replaceAll("\"", "");
			applicationstorefolder_ = basepwd + "/" + folder;
			is.close();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getBibboxApplicationStorePWDfromConfig()", "Error reading bibbox config file."));
			e.printStackTrace();
		}
	}
	
	private static String getLiferayConfigForBibboxConfigFile() {
		if(bibboxconfigfile_ == null) {
			bibboxconfigfile_ = PropsUtil.get("bibboxconfigfile");
		}
		return bibboxconfigfile_;
	}
	
	private static void getBibboxInstancePWDfromConfig() {
		try {
			Properties bibboxproperties = new Properties();
			InputStream is = new FileInputStream(getLiferayConfigForBibboxConfigFile());
			bibboxproperties.load(is);
			String basepwd = bibboxproperties.getProperty("bibboxdir").replaceAll("\"", "");
			String folder = bibboxproperties.getProperty("bibboxinstancefolder").replaceAll("\"", "");
			instancefolder_ = basepwd + "/" + folder;
			is.close();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getBibboxInstancePWDfromConfig()", "Error reading bibbox config file."));
			e.printStackTrace();
		}
	}
	
	private static void getBaseURLfromConfig() {
		try {
			Properties bibboxproperties = new Properties();
			InputStream is = new FileInputStream(getLiferayConfigForBibboxConfigFile());
			bibboxproperties.load(is);
			baseurl_ = bibboxproperties.getProperty("bibboxbaseurl").replaceAll("\"", "");
			is.close();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getBibboxApplicationStorePWDfromConfig()", "Error reading bibbox config file."));
			e.printStackTrace();
		}
	}
}
