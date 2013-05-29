package com.medic.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends Activity implements OnClickListener{

	EditText topic;
	EditText body;
	Button send;
	String emailAddress = "patrickblack33@gmail.com";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.feedback);
		topic = (EditText) findViewById(R.id.etEmailTopic);
		body = (EditText) findViewById(R.id.etEmailBody);
		send = (Button) findViewById(R.id.bEmailSend);
		send.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String Topic = topic.getText().toString();
		String Message = body.getText().toString();
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, Topic);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, Message);
		startActivity(emailIntent);
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
