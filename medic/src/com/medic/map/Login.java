package com.medic.map;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Login extends Activity implements OnClickListener {
	public static String MY_URL = "http://10.0.2.2/cool/";
	EditText patId;
	EditText patPassword;
	TextView failure;
	Button go;
	Button ignore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		patId = (EditText) findViewById(R.id.etPatientId);
		patPassword = (EditText) findViewById(R.id.etLoginPassword);
		failure = (TextView) findViewById(R.id.tvFailure);
		go = (Button) findViewById(R.id.bGo);
		ignore = (Button) findViewById(R.id.bIgnore);
		go.setOnClickListener(this);
		ignore.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bGo:

			String pat_id = patId.getText().toString();
			int myId = Integer.parseInt(pat_id);
			String password = patPassword.getText().toString();
			//checkPassword(myId, password);
			String pid = String.valueOf(myId);
			Intent success = new Intent(Login.this,Select.class);
			success.putExtra("id", pid);
			success.putExtra("password", password);
			startActivity(success);

			// startActivity(new Intent(Login.this,home.class));

			break;
		case R.id.bIgnore:
			startActivity(new Intent(Login.this, Ignore.class));
		}

	}

}
