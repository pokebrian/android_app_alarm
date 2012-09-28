package br.com.brr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.ExifInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyAlarmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final PackageManager pm = getPackageManager();
        
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
        
        //iniciando app
        //startActivity(pm.getLaunchIntentForPackage("com.android.browser"));
        
        
        
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

//listando apps
//http://stackoverflow.com/questions/2695746/how-to-get-a-list-of-installed-android-applications-and-pick-one-to-run