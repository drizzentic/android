package com.medic.map;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends Activity implements OnClickListener {

	EditText password;
	Button submit;
	String top;
	int docID;
	int patID;
	String temp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		password = (EditText) findViewById(R.id.etNewPass);
		submit = (Button) findViewById(R.id.bSubmitPassword);
		submit.setOnClickListener(this);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		top = extras.getString("docID");
		temp = extras.getString("patID");
	    docID = Integer.parseInt(top);
	    patID=Integer.parseInt(temp);
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.bSubmitPassword:
			String pass = password.getText().toString();
			changePass(patID,pass);
			break;
			
		}

	}

	public void changePass(int id,String pass) {
		InputStream isp = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			StringBuffer sb = new StringBuffer(
					Login.MY_URL+"changepass.php");
			sb.append("?id="+id+"&pass='" + pass + "'");
			HttpPost httppost = new HttpPost(sb.toString());

			HttpResponse response = httpclient.execute(httppost);

			HttpEntity entity = response.getEntity();
			isp = entity.getContent();

		} catch (Exception e) {
			Log.e("Log.tag", "Error in http connection" + e.toString());
		}
		
	}
	

}
