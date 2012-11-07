package br.com.brr.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import br.com.brr.AlarmCad;
import br.com.brr.model.Alarm;

public class FileManager {
	final static String FILENAME = "default_file";
	
	private FileManager(){}
	
	public static int saveAlarm(Context context, Alarm alarm){
		List<Alarm> alarms;
		int lastId = 0;
		try {
			alarms = getAlarmList(context, FILENAME);
			StringBuilder sb = new StringBuilder();
			for(Alarm a: alarms){
				if(alarm.getId() == a.getId())
					a = alarm;
				sb.append(a.toString());
				lastId = a.getId();
			}
			
			if(alarm.getId() == 0){
				lastId++;
				alarm.setId(lastId);
				sb.append(alarm.toString());
			}
			
			saveFile(context, FILENAME, sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lastId;
	}
	
	public static Alarm getAlarmById(Context context, int id){

		try {
			List<Alarm> alarms = getAlarmList(context, FILENAME);
			for(Alarm a: alarms){
				if(a.getId() == id){
					return a;
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
		}
		return null;
	}
	
	public static void saveFile(Context context, String fileName, String text){
		
		FileOutputStream fos;
		try {
			fos = context.openFileOutput(fileName, AlarmCad.MODE_PRIVATE);
			fos.write(text.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Alarm> getAlarmList(Context context, String fileName) throws Exception{
		if(fileName == null)
			fileName = FILENAME;
		
		List<Alarm> alarms = new ArrayList<Alarm>();
		try {
			FileInputStream fis = context.openFileInput(fileName);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bufferedReader = new BufferedReader(isr);
			String line;
			while((line = bufferedReader.readLine()) != null){
				alarms.add(Alarm.fromString(line));
				
				//Log.d("file reader", line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alarms;
	}

}
