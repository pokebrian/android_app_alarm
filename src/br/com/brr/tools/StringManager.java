package br.com.brr.tools;

public class StringManager {
	
	private static final String SEMICOLON = "__sc__";
	private static final String LINE_BREAK = "__bl__";
	private static final String EMPTY = "__em__";
	
	public static String parseStorageFormat(String str) {
		if ("".equals(str))
			return EMPTY;
		return str.replaceAll(";", SEMICOLON).replaceAll("\n", LINE_BREAK);
	}
	
	public static String parseShowFormat(String str) {
		if (EMPTY.equals(str))
			return "";
		return str.replaceAll(SEMICOLON, ";").replaceAll(LINE_BREAK, "\n");
	}
}
