package at.graz.meduni.bibbox.helper;

import java.io.BufferedReader;
import java.io.File;
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
	private static String scriptfolder_ = null;
	private static String baseurl_ = null;
	private static String adminroles_ = null;
	private static String vmadminroles_ = null;
	
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
	
	public static String getScriptPWD() {
		if(scriptfolder_ == null) {
			getScriptFolderFromConfig();
		}
		return scriptfolder_;
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
			String sb = "";
			try {
			    String line = br.readLine();
	
			    while (line != null) {
			        sb += line;
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
	
	public static String getAdminRoles() {
		if(adminroles_ == null) {
			getAdminRolesfromConfig();
		}
		return adminroles_;
	}
	
	public static String getVMAdminRoles() {
		if(vmadminroles_ == null) {
			getVmAdminRolesfromConfig();
		}
		return vmadminroles_;
	}

	public static String getApplicationFolder(String applicationname, String version) {
		return getApplicationStorePWD() + "/" + applicationname + "/blob/" + version;
	}
	
	public static String getBibboxKit() {
		try {
			Properties bibboxproperties = new Properties();
			InputStream is = new FileInputStream(getLiferayConfigForBibboxConfigFile());
			bibboxproperties.load(is);
			String kit = bibboxproperties.getProperty("bibboxkit").replaceAll("\"", "");
			is.close();
			return kit;
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getBibboxApplicationStorePWDfromConfig()", "Error reading bibbox config file."));
			e.printStackTrace();
		}
		return "eB3kit";
	}
	
	public static String getBibboxUsedInstanceIds() {
		return readBibboxUsedInstanceIds();
	}
	
	public static String getBibboxLockedAppsInstanceIds() {
		return readBibboxLockedAppsInstanceIds();
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
	
	private static void getScriptFolderFromConfig() {
		try {
			Properties bibboxproperties = new Properties();
			InputStream is = new FileInputStream(getLiferayConfigForBibboxConfigFile());
			bibboxproperties.load(is);
			String basepwd = bibboxproperties.getProperty("bibboxdir").replaceAll("\"", "");
			String folder = bibboxproperties.getProperty("bibboxscriptfolder").replaceAll("\"", "");
			scriptfolder_ = basepwd + "/" + folder;
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
	
	private static void getAdminRolesfromConfig() {
		try {
			Properties bibboxproperties = new Properties();
			InputStream is = new FileInputStream(getLiferayConfigForBibboxConfigFile());
			bibboxproperties.load(is);
			adminroles_ = bibboxproperties.getProperty("adminroles").replaceAll("\"", "");
			is.close();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getAdminRolesfromConfig()", "Error reading bibbox config file."));
			e.printStackTrace();
		}
	}
	
	private static void getVmAdminRolesfromConfig() {
		try {
			Properties bibboxproperties = new Properties();
			InputStream is = new FileInputStream(getLiferayConfigForBibboxConfigFile());
			bibboxproperties.load(is);
			vmadminroles_ = bibboxproperties.getProperty("vmadminroles").replaceAll("\"", "");
			is.close();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getVmAdminRolesfromConfig()", "Error reading bibbox config file."));
			e.printStackTrace();
		}
	}
	
	private static String readBibboxUsedInstanceIds() {
		String used_instance_ids = "";
		try {
			Properties bibboxproperties = new Properties();
			InputStream is = new FileInputStream(getLiferayConfigForBibboxConfigFile());
			bibboxproperties.load(is);
			used_instance_ids = bibboxproperties.getProperty("usedinstanceids").replaceAll("\"", "");
			is.close();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "readBibboxUsedInstanceIds()", "Error reading bibbox config file."));
			e.printStackTrace();
		}
		return used_instance_ids;
	}
	
	private static String readBibboxLockedAppsInstanceIds() {
		String applock_ids = "";
		try {
			Properties bibboxproperties = new Properties();
			String configfile = getLiferayConfigForBibboxConfigFile().replaceAll("/bibbox.cfg", "/conf.d/applock.cfg");
			File f = new File(configfile);
			if(f.exists()) {
				InputStream is = new FileInputStream(configfile);
				bibboxproperties.load(is);
				applock_ids = bibboxproperties.getProperty("applock").replaceAll("\"", "");
				is.close();
			}
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "readBibboxLockedAppsInstanceIds()", "Error reading bibbox applock config file."));
			e.printStackTrace();
		}
		return applock_ids;
	}
}
