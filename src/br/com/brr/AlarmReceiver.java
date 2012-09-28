package br.com.brr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		try {
			Bundle bundle = intent.getExtras();
			String message = bundle.getString("alarm_message");
		
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Toast.makeText(context, "there was an error somewhere, but we still received an alarm", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}

	}

}

//http://justcallmebrian.com/?p=129