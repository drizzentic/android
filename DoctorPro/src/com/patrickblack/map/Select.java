package com.patrickblack.map;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Select extends Activity{

	TextView success;
	int index;
	String passi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
		success = (TextView) findViewById(R.id.tvSuccess);
		Bundle extras = getIntent().getExtras();
		if(extras !=null) {
		String top = extras.getString("id");
		passi = extras.getString("password");
		index = Integer.parseInt(top);
		}
		checkPassword(index,passi);
		
		Thread timer = new Thread(){
        	public void run(){
        		try{
        			sleep(10);
        		}catch (Exception e){
        			e.printStackTrace();
        		}finally{
        			String pid = String.valueOf(index);
        			Intent doc = new Intent(Select.this,Doctor.class);
        			doc.putExtra("patient id", pid);
        			startActivity(doc);
        		}
        	}
		};
		timer.start();
		
	}
	
	
	public void checkPassword(int id, String pass) {
		String result = "";
		InputStream isp = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			StringBuffer sb = new StringBuffer(
					Login.MY_URL+"patient.php");
			if (id > 0)
				sb.append("?id=" + id + "&sid='" + pass + "'");
			HttpPost httppost = new HttpPost(sb.toString());
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			isp = entity.getContent();
		} catch (Exception e) {
			Log.e("Log.tag", "Error in http connection" + e.toString());
			//success.setText("wrong patient id or password");
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					isp, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			isp.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("Log.tag", "Error converting result " + e.toString());
		}

		// parse json date
		try {
			String s = "";
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);
				s = s + "Name: \n" + json.getString("patient_firstname") + " "
						+ json.getString("patient_secondname") + "\n"
						+"\n";
				/*
				 * + "contact :\n" + json.getString("contant") + "\n" +
				 * "***************************\n";
				 */
			}

			success.setText(s);

		} catch (Exception e) {
			Log.e("Log.tag", "Error parsing Data" + e.toString());
			success.setText("wrong username or password");
			Intent back = new Intent(Select.this,Login.class);
			startActivity(back);
			finish();
		}

	}

}
