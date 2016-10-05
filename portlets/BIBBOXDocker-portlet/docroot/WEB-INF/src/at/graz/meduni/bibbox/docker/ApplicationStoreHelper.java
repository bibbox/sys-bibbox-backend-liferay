package at.graz.meduni.bibbox.docker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.DetachedHeadException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefNotAdvertisedException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import at.graz.meduni.bibbox.docker.model.ApplicationStoreItemConfig;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemLocalServiceUtil;

public class ApplicationStoreHelper {
	/**
	 * Error Format for date
	 */
	private String log_portlet_ = "BIBBOXDocker";
	private String log_classname_ = "at.graz.meduni.bibbox.docker.ApplicationStoreHelper";
	
	private static String bibboxconfigfile_ = null;
	private static Properties bibboxproperties_ = null;
	private static String bibboxapplicationstorefolder_ = null;
	
	private String headhash_ = "";
	private String gitmessage_ = "";
	private HashMap<String, ApplicationStoreItemConfig> applicationstoreitemconfigs_ = new HashMap<String, ApplicationStoreItemConfig>();
	
	public void loadApplicationStoreItems() {
		updateGitHubRepository();
		getApplicationStoreItemsConfigFiles();
		updateApplicationStoreItems();
	}
	
	private void updateGitHubRepository() {
		try {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			File repositoryfolder = new File(getBibboxApplicationStoreFolder() + "/.git");
			Repository repository = builder.setGitDir(repositoryfolder).readEnvironment().findGitDir().build();
			Git git = new Git(repository);
			PullCommand pullCmd = git.pull();
			pullCmd.setRemoteBranchName("master");
			PullResult result = pullCmd.call();
			
			gitmessage_ = result.getMergeResult().getMergeStatus().toString();
			headhash_ = result.getMergeResult().getNewHead().name();
			git.close();
		} catch (IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "IOException wile updating git repository"));
			e.printStackTrace();
		} catch (WrongRepositoryStateException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "WrongRepositoryStateException wile updating git repository"));
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "InvalidConfigurationException wile updating git repository"));
			e.printStackTrace();
		} catch (DetachedHeadException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "DetachedHeadException wile updating git repository"));
			e.printStackTrace();
		} catch (InvalidRemoteException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "InvalidRemoteException wile updating git repository"));
			e.printStackTrace();
		} catch (CanceledException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "CanceledException wile updating git repository"));
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "RefNotFoundException wile updating git repository"));
			e.printStackTrace();
		} catch (RefNotAdvertisedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "RefNotAdvertisedException wile updating git repository"));
			e.printStackTrace();
		} catch (NoHeadException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "NoHeadException wile updating git repository"));
			e.printStackTrace();
		} catch (TransportException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "TransportException wile updating git repository"));
			e.printStackTrace();
		} catch (GitAPIException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "GitAPIException wile updating git repository"));
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateGitHubRepository()", "Exception wile updating git repository"));
			e.printStackTrace();
		}
	}
	
	private String getBibboxApplicationStoreFolder() {
		try {
			if(bibboxapplicationstorefolder_ == null) {
				String basepwd = getBibboxProperties().getProperty("bibboxdir").replaceAll("\"", "");
				String folder = getBibboxProperties().getProperty("bibboxapplicationstorefolder").replaceAll("\"", "");
				bibboxapplicationstorefolder_ = basepwd + "/" + folder;
			}
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getBibboxApplicationStoreFolder()", "Error getting application folder from bibbox config file."));
			e.printStackTrace();
		}
		return bibboxapplicationstorefolder_;
	}
	
	private Properties getBibboxProperties() {
		if(bibboxproperties_ == null) {
			try {
				bibboxproperties_ = new Properties();
				InputStream is = new FileInputStream(getBibboxConfigFile());
				bibboxproperties_.load(is);
			} catch (Exception e) {
				System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getBibboxProperties()", "Error reading bibbox config file."));
				e.printStackTrace();
			}
		}
		return bibboxproperties_;
	}
	
	private String getBibboxConfigFile() {
		try {
			if(bibboxconfigfile_ == null) {
				bibboxconfigfile_ = PropsUtil.get("bibboxconfigfile");
				System.out.println("Test: bibboxconfigfile_ = " + bibboxconfigfile_);
			}
			if(bibboxconfigfile_ == null || bibboxconfigfile_.equals("")) {
				bibboxconfigfile_ = "/etc/bibbox/bibbox.cfg";
			}
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getBibboxConfigFile()", "Error reading Liferay config file."));
			e.printStackTrace();
		}
		return bibboxconfigfile_;
	}
	
	private void getApplicationStoreItemsConfigFiles() {
		try {
			File applicatonstorefolder = new File(getBibboxApplicationStoreFolder());
			for(File applicationfolder : applicatonstorefolder.listFiles()) {	
				getApplicationStoreItemsConfigFile(applicationfolder);
			}
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getApplicationStoreItemsConfigFiles()", "Error reading ApplicationStore folder."));
			e.printStackTrace();
		}
	}
	
	private void getApplicationStoreItemsConfigFile(File applicationfolder) {
		try {
			if(applicationfolder.isDirectory()) {
				for(File configfile : applicationfolder.listFiles(getApplicationStoreConfigFileFilter())) {
					ApplicationStoreItemConfig applicationstoreitemconfig = new ApplicationStoreItemConfig(applicationfolder.getName());
					applicationstoreitemconfig.setConfigurationFile(configfile);
					applicationstoreitemconfig.setGitHash(headhash_);
					applicationstoreitemconfigs_.put(applicationstoreitemconfig.getApplicationName(), applicationstoreitemconfig);
				}
			}
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getApplicationStoreItemsConfigFile(File applicationfolder)", "Error reading Application info file. File:" + applicationfolder.getAbsolutePath()));
			e.printStackTrace();
		}
	}
	
	private FilenameFilter getApplicationStoreConfigFileFilter() {
		return new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.equals("appinfo.xml")) {
					return true;
				} else {
					return false;
				}
			}
		};
	}
	
	private void updateApplicationStoreItems() {
		try {
			List<ApplicationStoreItem> applicationstoreitems = ApplicationStoreItemLocalServiceUtil.getApplicationStoreItems(-1, -1);
			for(ApplicationStoreItem applicationstoreitem : applicationstoreitems) {
				updateApplicationStoreItem(applicationstoreitem);
			}
			for(String applicationfoldername : applicationstoreitemconfigs_.keySet()) {
				createApplicationStoreItem(applicationfoldername);
			}
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateApplicationStoreItems()", "Error updating application information from appinfo file."));
			e.printStackTrace();
		}
	}
	
	private void updateApplicationStoreItem(ApplicationStoreItem applicationstoreitem) {
		try {
			ApplicationStoreItemConfig applicationstoreitemconfig = applicationstoreitemconfigs_.get(applicationstoreitem.getApplicationFolderName());
			if(applicationstoreitemconfig == null) {
				disableApplicationStoreItem(applicationstoreitem);
			} else {
				if(!applicationstoreitemconfig.getGitHash().equals(applicationstoreitem.getGithash())) {
					updateApplicationStoreItem(applicationstoreitem, applicationstoreitemconfig);
				}
			}
			applicationstoreitemconfigs_.remove(applicationstoreitem.getApplicationFolderName());
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateApplicationStoreItem(ApplicationStoreItem applicationstoreitem)", "Error updating application store item. ApplicationStoreItem: " + applicationstoreitem.getApplicationStoreItemId() + ":" + applicationstoreitem.getApplicationFolderName()));
			e.printStackTrace();
		}
	}
	
	private void disableApplicationStoreItem(ApplicationStoreItem applicationstoreitem) {
		applicationstoreitem.setDepreciated(true);
		applicationstoreitem = ApplicationStoreItemLocalServiceUtil.updateApplicationStoreItem(applicationstoreitem);
	}
	
	private void updateApplicationStoreItem(ApplicationStoreItem applicationstoreitem, ApplicationStoreItemConfig applicationstoreitemconfig) {
		applicationstoreitem.setDepreciated(false);
		if(applicationstoreitemconfig.equalsApplicationStoreItem(applicationstoreitem)) {
			applicationstoreitem = applicationstoreitemconfig.updateDataElements(applicationstoreitem);
		}
	}
	
	private void createApplicationStoreItem(String applicationfoldername) {
		try {
			ApplicationStoreItemConfig applicationstoreitemconfig = applicationstoreitemconfigs_.get(applicationfoldername);
			ApplicationStoreItem applicationstoreitem = ApplicationStoreItemLocalServiceUtil.createApplicationStoreItem(CounterLocalServiceUtil.increment());
			applicationstoreitem.setDepreciated(false);
			applicationstoreitem = applicationstoreitemconfig.updateDataElements(applicationstoreitem);
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "updateApplicationStoreItem(ApplicationStoreItem applicationstoreitem)", "Error creating application store item. String: " + applicationfoldername));
			e.printStackTrace();
		}
	}
	
}
