package at.graz.meduni.bibbox.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceStatusLocalServiceUtil;

public class ActivitiesProtocol {
	public static JSONObject createActivity(String input) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		HttpURLConnection conn = null;
		try {
			URL url = new URL("http://activities." + BibboxConfigReader.getBaseURL() + "/activities/api/v1.0/activities");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				returnobject.put("status", "error");
				returnobject.put("error", "Failed : HTTP error code : " + conn.getResponseCode());
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String responsestring = "";
			while ((output = br.readLine()) != null) {
				responsestring += output;
				
			}
			JSONObject response = JSONFactoryUtil.createJSONObject(responsestring);
			returnobject.put("activitId", response.getLong("id"));

		} catch (MalformedURLException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return returnobject;
	}
	
	public static void updateActivity(String activitId, String input) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL("http://activities." + BibboxConfigReader.getBaseURL() + "/activities/api/v1.0/activities/" + activitId);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

		} catch (MalformedURLException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
	
	public static void addActivityLogEntry(String activitId, String type, String log) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL("http://activities." + BibboxConfigReader.getBaseURL() + "/activities/api/v1.0/activities/" + activitId + "/logs");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			JSONObject activity = JSONFactoryUtil.createJSONObject();
			activity.put("log-message", log);
			activity.put("type", type);
			String input = activity.toJSONString();
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

		} catch (MalformedURLException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
