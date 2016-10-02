package at.graz.meduni.bibbox.docker.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem;

public class ApplicationStoreItemConfig {
	private String applicationname_ = "";
	private File configurationfile_ = null;
	private String githash_ = "";
	private boolean parsedfile = false;
	
	private String name = "";
	private String short_name = "";
	private String version = "";
	private String application_topics = "";
	private String eb3kit_group = "";
	private String release_state = "";
	private String description = "";
	private String catalogue_url = "";
	private String application_url = "";
	private String kit = "";
	
	public ApplicationStoreItemConfig(String applicationname) {
		applicationname_ = applicationname;
	}
	
	public void setConfigurationFile(File configurationfile) {
		configurationfile_ = configurationfile;
	}
	
	public void setGitHash(String githash) {
		githash_ = githash;
	}
	
	public String getApplicationName() {
		return applicationname_;
	}
	
	public String getGitHash() {
		return githash_;
	}
	
	public boolean equalsApplicationStoreItem(ApplicationStoreItem applicationstoreitem) {
		if(!parsedfile) {
			parseConfigFile();
		}
		if(!applicationstoreitem.getApplicationName().equals(name)) {
			return false;
		}
		if(!applicationstoreitem.getApplicationShortName().equals(short_name)) {
			return false;
		}
		if(!applicationstoreitem.getApplicationVersion().equals(version)) {
			return false;
		}
		if(!applicationstoreitem.getApplicationApplicationUrl().equals(application_url)) {
			return false;
		}
		if(!applicationstoreitem.getApplicationCatalogueUrl().equals(catalogue_url)) {
			return false;
		}
		if(!applicationstoreitem.getApplicationDescription().equals(description)) {
			return false;
		}
		if(!applicationstoreitem.getApplicationReleaseState().equals(release_state)) {
			return false;
		}
		//Tags, Kit, eb3kit_group
		return true;
	}
	
	private void parseConfigFile() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(configurationfile_);
			doc.getDocumentElement().normalize();
			name = doc.getElementsByTagName("name").item(0).getTextContent();
			short_name = doc.getElementsByTagName("short_name").item(0).getTextContent();
			version = doc.getElementsByTagName("version").item(0).getTextContent();
			application_topics = doc.getElementsByTagName("application_topics").item(0).getTextContent();
			eb3kit_group = doc.getElementsByTagName("eb3kit_group").item(0).getTextContent();
			release_state = doc.getElementsByTagName("release_state").item(0).getTextContent();
			description = doc.getElementsByTagName("description").item(0).getTextContent();
			catalogue_url = doc.getElementsByTagName("catalogue_url").item(0).getTextContent();
			application_url = doc.getElementsByTagName("application_url").item(0).getTextContent();
			kit = doc.getElementsByTagName("kit").item(0).getTextContent();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
