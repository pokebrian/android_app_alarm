package br.com.brr;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.brr.model.Alarm;
import br.com.brr.tools.FileManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlarmCad extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.alarmcad);

		Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {

				String name = ((EditText)findViewById(R.id.txtNome)).getText().toString();
				Alarm alarm = new Alarm(0, name);
				FileManager.saveAlarm(AlarmCad.this, alarm);
				
				//Log.d("saveButton", "Click!");
			}
		});
	}
}
