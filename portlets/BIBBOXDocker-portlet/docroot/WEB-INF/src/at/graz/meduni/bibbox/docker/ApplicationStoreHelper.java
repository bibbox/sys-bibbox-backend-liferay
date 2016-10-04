package at.graz.meduni.bibbox.docker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
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
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemLocalServiceUtil;

public class ApplicationStoreHelper {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongRepositoryStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DetachedHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CanceledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RefNotAdvertisedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getBibboxApplicationStoreFolder() {
		if(bibboxapplicationstorefolder_ == null) {
			bibboxapplicationstorefolder_ = getBibboxProperties().getProperty("bibboxapplicationstorefolder").replaceAll("\"", "");
		}
		return bibboxapplicationstorefolder_;
	}
	
	private Properties getBibboxProperties() {
		if(bibboxproperties_ == null) {
			try {
				Properties prop = new Properties();
				InputStream is = new FileInputStream(getBibboxConfigFile());
				prop.load(is);
			} catch (Exception e) {
				//TODO: Add Exception
			}
		}
		return bibboxproperties_;
	}
	
	private String getBibboxConfigFile() {
		if(bibboxconfigfile_ == null) {
			bibboxconfigfile_ = PropsUtil.get("bibboxconfigfile");
		}
		return bibboxconfigfile_;
	}
	
	private void getApplicationStoreItemsConfigFiles() {
		File applicatonstorefolder = new File(getBibboxApplicationStoreFolder());
		for(File applicationfolder : applicatonstorefolder.listFiles()) {
			getApplicationStoreItemsConfigFile(applicationfolder);
		}
	}
	
	private void getApplicationStoreItemsConfigFile(File applicationfolder) {
		if(applicationfolder.isDirectory()) {
			for(File configfile : applicationfolder.listFiles(getApplicationStoreConfigFileFilter())) {
				ApplicationStoreItemConfig applicationstoreitemconfig = new ApplicationStoreItemConfig(applicationfolder.getName());
				applicationstoreitemconfig.setConfigurationFile(configfile);
				applicationstoreitemconfig.setGitHash(headhash_);
				applicationstoreitemconfigs_.put(applicationstoreitemconfig.getApplicationName(), applicationstoreitemconfig);
			}
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
		List<ApplicationStoreItem> applicationstoreitems = ApplicationStoreItemLocalServiceUtil.getApplicationStoreItems(-1, -1);
		for(ApplicationStoreItem applicationstoreitem : applicationstoreitems) {
			updateApplicationStoreItem(applicationstoreitem);
		}
		for(String applicationfoldername : applicationstoreitemconfigs_.keySet()) {
			ApplicationStoreItemConfig applicationstoreitemconfig = applicationstoreitemconfigs_.get(applicationfoldername);
			ApplicationStoreItem applicationstoreitem = ApplicationStoreItemLocalServiceUtil.createApplicationStoreItem(CounterLocalServiceUtil.increment());
			applicationstoreitem = applicationstoreitemconfig.updateDataElements(applicationstoreitem);
		}
	}
	
	private void updateApplicationStoreItem(ApplicationStoreItem applicationstoreitem) {
		ApplicationStoreItemConfig applicationstoreitemconfig = applicationstoreitemconfigs_.get(applicationstoreitem.getApplicationFolderName());
		if(applicationstoreitemconfig == null) {
			disableApplicationStoreItem(applicationstoreitem);
		} else {
			if(!applicationstoreitemconfig.getGitHash().equals(applicationstoreitem.getGithash())) {
				updateApplicationStoreItem(applicationstoreitem, applicationstoreitemconfig);
			}
		}
		applicationstoreitemconfigs_.remove(applicationstoreitem.getApplicationFolderName());
	}
	
	private void disableApplicationStoreItem(ApplicationStoreItem applicationstoreitem) {
		applicationstoreitem.setDepreciated(true);
		ApplicationStoreItemLocalServiceUtil.updateApplicationStoreItem(applicationstoreitem);
	}
	
	private void updateApplicationStoreItem(ApplicationStoreItem applicationstoreitem, ApplicationStoreItemConfig applicationstoreitemconfig) {
		applicationstoreitem.setDepreciated(false);
		if(applicationstoreitemconfig.equalsApplicationStoreItem(applicationstoreitem)) {
			applicationstoreitem = applicationstoreitemconfig.updateDataElements(applicationstoreitem);
		}
	}
	
}
