package com.medic.map;

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
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Firstaid extends Activity{

	TextView resultView;
	int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.information);
		
		resultView = (TextView) findViewById(R.id.tvDiseaseContent);
		Bundle extras = getIntent().getExtras();
		if(extras !=null) {
		String top = extras.getString("List_Position");
		index = Integer.parseInt(top);
		}
		//resultView.setText("Index is: - " + index);
		initializeString(index+1);
	}
	
	public void initializeString(int id) {
		String result = "";
		InputStream isp = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			StringBuffer sb =new StringBuffer(Login.MY_URL+"firstaid.php");
			if (id>0)sb.append("?id="+id);
			HttpPost httppost = new HttpPost(sb.toString());
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			isp = entity.getContent();
		} catch (Exception e) {
			Log.e("Log.tag", "Error in http connection" + e.toString());
		}
		// convert response to string
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
				s = s + 
				"CONDITION: \n" + json.getString("name")+"\n"+
				"******************************\n"+
				"DESCRIPTION: \n"+ json.getString("description")+"\n"+
				"******************************\n"+
				"SIGNS: \n"+ json.getString("signs")+"\n"+
				"******************************\n"+
				"REMEDY: \n"+ json.getString("remedy");
			}
			resultView.setText(s);
		} catch (Exception e) {
			Log.e("Log.tag", "Error parsing Data" + e.toString());
		}
	}
}
