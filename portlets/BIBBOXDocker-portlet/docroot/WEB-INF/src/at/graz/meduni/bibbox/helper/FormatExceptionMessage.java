package at.graz.meduni.bibbox.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatExceptionMessage {
	private static String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	private static SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	public static String newline = System.getProperty("line.separator");
	
	public static String formatExceptionMessage(String loglevel, String portlet, String classname, String function, String message) {
		return "[" + date_format_apache_error.format(new Date()) + "] [" + loglevel + "] [" + portlet + "::" + classname + "::" + function + "] " + message;
	}
	
	public static String formatExceptionMessage(String loglevel, String portlet, String classname, String function, String message, StackTraceElement[] stacktrace, String log) {
		String stack = "";
		for(StackTraceElement stacktraceelement : stacktrace) {
			stack += stacktraceelement.toString() + newline;
		}
		return log + newline + "[" + date_format_apache_error.format(new Date()) + "] [" + loglevel + "] [" + portlet + "::" + classname + "::" + function + "] " + message + newline + stack;
	}
	
	public static String formatLogMessage(String loglevel, String message) {
		return "[" + date_format_apache_error.format(new Date()) + "] [" + loglevel + "] " + message;
	}
	
	public static String formatLogMessage(String loglevel, String message, String log) {
		return log + newline + "[" + date_format_apache_error.format(new Date()) + "] [" + loglevel + "] " + message;
	}
}
