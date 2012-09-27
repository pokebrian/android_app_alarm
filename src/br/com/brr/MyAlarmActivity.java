package br.com.brr;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
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
        startActivity(pm.getLaunchIntentForPackage("com.android.browser"));
        
        finish();
        
    }
}

//listando apps
//http://stackoverflow.com/questions/2695746/how-to-get-a-list-of-installed-android-applications-and-pick-one-to-run