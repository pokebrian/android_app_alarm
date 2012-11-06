package br.com.brr.tools;

public class StringManager {
	
	private static final String SEMICOLON = "__sc__";
	private static final String LINE_BREAK = "__bl__";
	
	public static String parseStorageFormat(String str) {
		return str.replaceAll(";", SEMICOLON).replaceAll("\n", LINE_BREAK);
	}
	
	public static String parseShowFormat(String str) {
		return str.replaceAll(SEMICOLON, ";").replaceAll(LINE_BREAK, "\n");
	}
}
