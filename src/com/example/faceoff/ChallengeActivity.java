package com.example.faceoff;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ChallengeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_challenge);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_challenge, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void createChallenge(View view) {
		Intent intent = new Intent(this, WelcomeScreen.class);
		String names = ((EditText) findViewById(R.id.names)).getText().toString();
		String drink = ((EditText) findViewById(R.id.what_drink)).getText().toString();
		int time = -1;
		try {
			time = Integer.parseInt(((EditText) findViewById(R.id.time_set)).getText().toString());
		} catch (NumberFormatException e) {
			startActivity(intent);
		}
		if(names == null || names.isEmpty() || drink == null || names.isEmpty() || time <= 0) {
			startActivity(intent);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String currentDateandTime = sdf.format(new Date());
			Challenge n = new Challenge(drink, names, currentDateandTime, time);
			Challenges.challenges.add(n);
			startActivity(intent);
			
		}
		
	}

}
