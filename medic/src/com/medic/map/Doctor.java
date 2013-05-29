package com.medic.map;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Doctor extends ListActivity {
	Vector<String> parents;
	Vector<String> ID;
	String foo;
	String van;

	int index;
	public Doctor() {
		// TODO Auto-generated constructor stub
		parents = new Vector<String>();
		ID = new Vector<String>();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String top = extras.getString("patient id");
			index = Integer.parseInt(top);
		}
		initializeString(index);
		parents.elements();
		ArrayAdapter<String> a = new ArrayAdapter<String>(Doctor.this,
				android.R.layout.simple_list_item_1);
		Enumeration<String> en = parents.elements();
		while (en.hasMoreElements())
			a.add(en.nextElement());
		setListAdapter(a);
		
		foo = ID.toString();
		
		String temp = new String();
		temp = split2(foo);
		van = temp;
	}

	private void initializeString(int id) {
		// TODO Auto-generated method stub
		String result = "";
		InputStream isp = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			StringBuffer sb = new StringBuffer(
					Login.MY_URL+"pat_doc.php");
			if (id > 0)
				sb.append("?id=" + id);
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
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);
				ID.add(json.getString("doc_id"));
				parents.add(json.getString("doc_secondname"));

			}
		} catch (Exception e) {
			Log.e("Log.tag", "Error parsing Data" + e.toString());
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String patID = String.valueOf(index);
		StringTokenizer token = new StringTokenizer(van,", ");
		int num = 0;
		String s = "";
		while (token.hasMoreTokens()){
			s = token.nextToken();
			num++; if (num == position+1){
				break;
			}
		}
		try {

			Intent ourIntent = new Intent(Doctor.this, home.class);
			ourIntent.putExtra("pele",s);
			ourIntent.putExtra("patID",patID);
			startActivity(ourIntent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String split2 (String s){
		String Intern = new String();
		StringBuffer sb = new StringBuffer(s);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        
        Intern = sb.toString();
        
		return Intern;
	}
	
}
