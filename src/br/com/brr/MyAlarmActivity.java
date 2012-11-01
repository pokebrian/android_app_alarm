package br.com.brr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import br.com.brr.model.Alarm;
import br.com.brr.tools.FileManager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.ExifInterface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MyAlarmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final PackageManager pm = getPackageManager();
        
        setContentView(R.layout.alarmelst);
        
        ListView listView = (ListView) findViewById(R.id.listView1);
        
        List<Alarm> alarms = FileManager.getAlarmList(MyAlarmActivity.this, null);
        
        //ArrayAdapter<Alarm> adapter = new ArrayAdapter<Alarm>(this, android.R.layout.simple_list_item_1, alarms); 
        
        AlarmAdapter adapter = new AlarmAdapter(MyAlarmActivity.this, alarms);
        
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				int alarmId = ((Alarm)parent.getAdapter().getItem(position)).getId();
				Intent intent = new Intent(MyAlarmActivity.this, AlarmCad.class);
				intent.putExtra("alarm_id", alarmId);
				MyAlarmActivity.this.startActivity(intent);
				
			}
		});
        
        
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Intent intent = new Intent("br.com.brr.AlarmCad");
				Intent intent = new Intent(MyAlarmActivity.this, AlarmCad.class);
				MyAlarmActivity.this.startActivity(intent);
				
				//MyAlarmActivity.this.setContentView(R.layout.alarmcad);
				
				Log.d("addButton", "Click!");
			}
		});
        
        String exemplo = "";
        
        if(!exemplo.equals("")){
	        ListView list = new ListView(this);
	        
	        
	        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
	        
	        List<String> names = new ArrayList<String>();
	        for (ApplicationInfo packageInfo: packages) {
	        	Log.d("TAG", "installed package: " + packageInfo.packageName);
	        	names.add(packageInfo.packageName);
	        }
	
	        //String[] names = new String[] { "Beatles", "Credeence", "Jannis Joplin", "Dokken", "Black Sabath", "Pink Floyd", "The Kinks", "The Verve"};
	        list.setAdapter(new ArrayAdapter<String>(this,
	        		android.R.layout.simple_list_item_checked, names));
	        
	        
	        //setContentView(R.layout.main);
	        
	        
	        setContentView(list);
	        
	        //iniciando app externo
	        //startActivity(pm.getLaunchIntentForPackage("com.android.browser"));
	        
	
	        //inicio preferences
	        SharedPreferences settings = getSharedPreferences("pref", MODE_PRIVATE);
	        SharedPreferences.Editor editor = settings.edit();
	        editor.putString("key1", "value1");
	        editor.putString("key2", "value2");
	        
	        
	        //---
	        Map<String,?> keys = PreferenceManager.getDefaultSharedPreferences(this).getAll();
	        for(Map.Entry<String,?> entry : keys.entrySet()){
	            Log.d("map values",entry.getKey() + ": " + 
	                                   entry.getValue().toString());            
	        }
	        
	        //http://code.google.com/p/phxandroid/source/browse/trunk/phxandroid-sharedprefs-one/src/org/phxandroid/sharedprefs/PrefUtil.java?r=8
	        //http://developer.android.com/guide/topics/data/data-storage.html
	        
	        //fim preferences
	        
	        
	        //getSharedPreferences(pref, 0);
	        
	        
	        
	        //inicio registrando um evento
	        Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.SECOND, 30);
	        Intent intent = new Intent(this, AlarmReceiver.class);
	        intent.putExtra("alarm_message", "O'Doyle Rules");
	        PendingIntent sender = PendingIntent.getBroadcast(this, 192837, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	        
	        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
	        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);
	        //fim registrando um evento
	        
	        
	        
	        finish();
        }
        
    }
    
    @Override
    protected void onResume(){
    	super.onResume();
    	
    	
        List<Alarm> alarms = FileManager.getAlarmList(MyAlarmActivity.this, null);
        
        AlarmAdapter adapter = new AlarmAdapter(MyAlarmActivity.this, alarms);
        
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
    	
    }
}

//listando apps
//http://stackoverflow.com/questions/2695746/how-to-get-a-list-of-installed-android-applications-and-pick-one-to-run