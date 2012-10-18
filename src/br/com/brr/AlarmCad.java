package br.com.brr;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
			
			@Override
			public void onClick(View arg0) {

				String FILENAME = "hello_file";
				String string = "hello world!";

				FileOutputStream fos;
				try {
					fos = openFileOutput(FILENAME, AlarmCad.MODE_PRIVATE);
					fos.write(string.getBytes());
					fos.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Log.d("saveButton", "Click!");
			}
		});
	}
}
