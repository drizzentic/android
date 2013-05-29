package com.medic.map;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
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

public class Skin extends ListActivity {

	Vector<String> parents;

	public Skin() {
		// TODO Auto-generated constructor stub
		parents = new Vector<String>();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initializeString(0);
		parents.elements();
		ArrayAdapter<String> a = new ArrayAdapter<String>(Skin.this,
				android.R.layout.simple_list_item_1);
		Enumeration<String> en = parents.elements();
		while (en.hasMoreElements())
			a.add(en.nextElement());
		setListAdapter(a);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// String cheese = parents.get(position);
		String pos = String.valueOf(position);
		try {
			// Class<?> ourClass =
			// Class.forName("com.patrickblack.map.Firstaid");
			Intent ourIntent = new Intent(Skin.this, Skin_child.class);
			ourIntent.putExtra("List_Position", pos);
			startActivity(ourIntent);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initializeString(int id) {
		String result = "";
		InputStream isp = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			StringBuffer sb = new StringBuffer(Login.MY_URL + "skin.php");
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
			// String s = "";
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);
				// s = s + "Disease: " + json.getString("name");
				parents.add(json.getString("name"));

			}
		} catch (Exception e) {
			Log.e("Log.tag", "Error parsing Data" + e.toString());
		}
	}

}