package at.graz.meduni.bibbox.docker.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag;
import at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit;
import at.graz.meduni.bibbox.liferay.portlet.model.KitGroup;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationTagLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.BibboxKitLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.KitGroupLocalServiceUtil;

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
		if(!compareApplicationTags(applicationstoreitem.getApplicationTags())) {
			return false;
		}
		if(!compareBibboxKits(applicationstoreitem.getBibboxKits())) {
			return false;
		}
		if(!compareKitGroups(applicationstoreitem.getKitGroups())) {
			return false;
		}
		return true;
	}
	
	public ApplicationStoreItem updateDataElements(ApplicationStoreItem applicationstoreitem) {
		if(!parsedfile) {
			parseConfigFile();
		}
		applicationstoreitem.setApplicationName(name);
		applicationstoreitem.setApplicationShortName(short_name);
		applicationstoreitem.setApplicationVersion(version);
		applicationstoreitem.setApplicationApplicationUrl(application_url);
		applicationstoreitem.setApplicationCatalogueUrl(catalogue_url);
		applicationstoreitem.setApplicationDescription(description);
		applicationstoreitem.setApplicationReleaseState(release_state);
		applicationstoreitem = ApplicationStoreItemLocalServiceUtil.updateApplicationStoreItem(applicationstoreitem);
		if(!compareApplicationTags(applicationstoreitem.getApplicationTags())) {
			updateApplicationTags(applicationstoreitem.getApplicationTags(), applicationstoreitem.getApplicationStoreItemId());
		}
		if(!compareBibboxKits(applicationstoreitem.getBibboxKits())) {
			updateBibboxKits(applicationstoreitem.getBibboxKits(), applicationstoreitem.getApplicationStoreItemId());
		}
		if(!compareKitGroups(applicationstoreitem.getKitGroups())) {
			updateKitGroups(applicationstoreitem.getKitGroups(), applicationstoreitem.getApplicationStoreItemId());
		}
		return applicationstoreitem;
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
	
	private boolean compareApplicationTags(List<ApplicationTag> applicationtags) {
		ArrayList<String> applicationconfigtaglist =  getArrayListStringFromString(application_topics, "");
		if(applicationconfigtaglist.size() != applicationtags.size()) {
			return false;
		}
		ArrayList<String> applicationtaglist = getArrayListStringFromApplicationTags(applicationtags);
 		return compareLists(applicationtaglist, applicationconfigtaglist);
	}
	
	private boolean compareBibboxKits(List<BibboxKit> bibboxkits) {
		ArrayList<String> bibboxkitconfiglist =  getArrayListStringFromString(kit, "");
		if(bibboxkitconfiglist.size() != bibboxkits.size()) {
			return false;
		}
		ArrayList<String> bibboxkitlist = getArrayListStringFromBibboxKits(bibboxkits);
 		return compareLists(bibboxkitlist, bibboxkitconfiglist);
	}
	
	private boolean compareKitGroups(List<KitGroup> kitgroups) {
		ArrayList<String> kitgroupconfiglist =  getArrayListStringFromString(eb3kit_group, "eb3kit:");
		if(kitgroupconfiglist.size() != kitgroups.size()) {
			return false;
		}
		ArrayList<String> kitgrouplist = getArrayListStringFromKitGroups(kitgroups);
 		return compareLists(kitgrouplist, kitgroupconfiglist);
	}
	
	private ArrayList<String> getArrayListStringFromString(String arraystring, String prefix) {
		ArrayList<String> arraylist = new ArrayList<String>();
		for(String tag : arraystring.split(";")) {
			arraylist.add(prefix + tag.trim());
		}
		return arraylist;
	}
	
	private ArrayList<String> getArrayListStringFromApplicationTags(List<ApplicationTag> applicationtags) {
		ArrayList<String> applicationtaglist = new ArrayList<String>();
		for(ApplicationTag applicationtag : applicationtags) {
			applicationtaglist.add(applicationtag.getTag());
		}
		return applicationtaglist;
	}
	
	private ArrayList<String> getArrayListStringFromBibboxKits(List<BibboxKit> bibboxkits) {
		ArrayList<String> bibboxkitlist = new ArrayList<String>();
		for(BibboxKit bibboxkit : bibboxkits) {
			bibboxkitlist.add(bibboxkit.getKitName());
		}
		return bibboxkitlist;
	}
	
	private ArrayList<String> getArrayListStringFromKitGroups(List<KitGroup> kitgroups) {
		ArrayList<String> kitgrouplist = new ArrayList<String>();
		for(KitGroup kitgroup : kitgroups) {
			kitgrouplist.add(kitgroup.getBibboxKitName() + ":" + kitgroup.getGroup());
		}
		return kitgrouplist;
	}
	
	private boolean compareLists(List<String> applicationstoreitemlist, List<String> applicationstoreitemconfiglist) {
		applicationstoreitemlist.removeAll(applicationstoreitemconfiglist);
		if(applicationstoreitemlist.size() == 0) {
			return true;
		}
		return false;
	}
	
	private void updateApplicationTags(List<ApplicationTag> applicationtags, long applicationstoreitemId) {
		ArrayList<String> applicationconfigtaglist =  getArrayListStringFromString(application_topics, "");
		for(ApplicationTag applicationtag : applicationtags) {
			if(applicationconfigtaglist.contains(applicationtag.getTag())) {
				applicationconfigtaglist.remove(applicationtag.getTag());
			} else {
				ApplicationTagLocalServiceUtil.deleteApplicationTag(applicationtag);
			}
		}
		createNewApplicationTags(applicationconfigtaglist, applicationstoreitemId);
	}
	
	private void createNewApplicationTags(ArrayList<String> applicationconfigtaglist, long applicationstoreitemId) {
		for(String applicationconfigtag : applicationconfigtaglist) {
			ApplicationTag applicationtag = ApplicationTagLocalServiceUtil.createApplicationTag(CounterLocalServiceUtil.increment());
			applicationtag.setApplicationStoreItemId(applicationstoreitemId);
			applicationtag.setTag(applicationconfigtag);
			ApplicationTagLocalServiceUtil.updateApplicationTag(applicationtag);
		}
	}
	
	private void updateBibboxKits(List<BibboxKit> bibboxkits, long applicationStoreItemId) {
		ArrayList<String> bibboxkitconfiglist =  getArrayListStringFromString(kit, "");
		for(BibboxKit bibboxkit : bibboxkits) {
			if(bibboxkitconfiglist.contains(bibboxkit.getKitName())) {
				bibboxkitconfiglist.remove(bibboxkit.getKitName());
			} else {
				BibboxKitLocalServiceUtil.deleteBibboxKit(bibboxkit);
			}
		}
		createNewBibboxKits(bibboxkitconfiglist, applicationStoreItemId);
	}
	
	private void createNewBibboxKits(ArrayList<String> bibboxkitconfiglist, long applicationStoreItemId) {
		for(String bibboxkitconfig : bibboxkitconfiglist) {
			BibboxKit bibboxkit = BibboxKitLocalServiceUtil.createBibboxKit(CounterLocalServiceUtil.increment());
			bibboxkit.setApplicationStoreItemId(applicationStoreItemId);
			bibboxkit.setKitName(bibboxkitconfig);
			BibboxKitLocalServiceUtil.updateBibboxKit(bibboxkit);
		}
	}
	
	private void updateKitGroups(List<KitGroup> kitgroups, long applicationstoreitemId) {
		ArrayList<String> kitgroupconfiglist =  getArrayListStringFromString(eb3kit_group, "");
		for(KitGroup kitgroup : kitgroups) {
			if(kitgroupconfiglist.contains(kitgroup.getGroup())) {
				kitgroupconfiglist.remove(kitgroup.getGroup());
			} else {
				KitGroupLocalServiceUtil.deleteKitGroup(kitgroup);
			}
		}
		createNewKitGroups(kitgroupconfiglist, applicationstoreitemId);
	}
	
	private void createNewKitGroups(ArrayList<String> kitgroupconfiglist, long applicationStoreItemId) {
		BibboxKit bibboxkit = BibboxKitLocalServiceUtil.getBibboxKit(applicationStoreItemId, "eB3kit");
		for(String kitgroupconfig : kitgroupconfiglist) {
			KitGroup kitgroup = KitGroupLocalServiceUtil.createKitGroup(CounterLocalServiceUtil.increment());
			kitgroup.setBibboxKitId(bibboxkit.getBibboxKitId());
			kitgroup.setGroup(kitgroupconfig);
			KitGroupLocalServiceUtil.updateKitGroup(kitgroup);
		}
	}
}
