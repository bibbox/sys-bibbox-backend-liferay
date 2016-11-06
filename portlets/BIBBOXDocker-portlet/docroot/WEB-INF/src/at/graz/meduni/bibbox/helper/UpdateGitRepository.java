package at.graz.meduni.bibbox.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.DetachedHeadException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotAdvertisedException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class UpdateGitRepository {
	/**
	 * Error Format for date
	 */
	private String log_portlet_ = "BIBBOXDocker";
	private String log_classname_ = "at.graz.meduni.bibbox.helper.UpdateGitRepository";
	
	private static String githubbaseurl_ = "https://github.com/bibbox/";
	
	public String updateLocalGitRepository(String repositorypwd) {
		String status = updateLocalGitRepository(new File(repositorypwd + "/.git"));
		return status;
	}
	
	public boolean checkIfLocalRepositoryExists(String repositorypwd) {
		return new File(repositorypwd).exists();
	}
	
	public void cloneRepositoryToFolder(String repositorypwd, String applicationname) {
		try {
			File repository = new File(repositorypwd);
			Git git = Git.cloneRepository().setURI(githubbaseurl_ + applicationname + ".git").setDirectory(repository).call();
			git.close();
		} catch (InvalidRemoteException e) {
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
	
	public void createAllTagFolders(String baserepositorypwd, String applicationname) {
		try {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			Repository repository = builder.setGitDir(new File(BibboxConfigReader.getApplicationFolder(applicationname, "development") + "/.git")).readEnvironment().findGitDir().build();
			Git git = new Git(repository);
			List<Ref> taglist = git.tagList().call();
			for(Ref ref : taglist) {
				createTagFodler(applicationname, ref.getName().replaceAll("refs/tags/", ""));
			}
			git.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createTagFodler(String applicationname, String version) {
		try {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			String applicationfolder = BibboxConfigReader.getApplicationFolder(applicationname, version);
			String applicationfolderdevelopment = BibboxConfigReader.getApplicationFolder(applicationname, "development");
			File repositoryfolder_development = new File(applicationfolderdevelopment + "/.git");
			Repository repository = builder.setGitDir(repositoryfolder_development).readEnvironment().findGitDir().build();
			Git git = new Git(repository);
			git.checkout().setName(version).call();
			String sourcefolder = applicationfolderdevelopment;
			String destfolder = applicationfolder;
			ProcessBuilder processbuilder = new ProcessBuilder("bash", "-c", "cp -r " + sourcefolder + " " + destfolder);
			Process process = processbuilder.start();
			git.close();
			process.waitFor();
			git.checkout().setName( "master" ).call();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RefAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRefNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CheckoutConflictException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String updateLocalGitRepository(File repositoryfolder) {
		String status = "";
		try {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			Repository repository = builder.setGitDir(repositoryfolder).readEnvironment().findGitDir().build();
			Git git = new Git(repository);
			PullCommand pullCmd = git.pull();
			pullCmd.setRemoteBranchName("master");
			PullResult result = pullCmd.call();
			
			status = result.getMergeResult().getMergeStatus().toString();
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
		return formatStatus(status);
	}
	
	private String formatStatus(String status) {
		switch (status) {
			case "":
				return "error";
			case "Fast-forward":
				return "updated";
			case "Already-up-to-date":
				return "uptodate";
			default:
				return "error";
		}
	}
}
