package com.patrickblack.map;

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

public class Staff extends ListActivity {

	Vector<String> parents;
	Vector<String> ID;
	String top;
	int index;
	String van;
	String foo = new String();

	public Staff() {
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
			top = extras.getString("docID");
			index = Integer.parseInt(top);

		}
		initializeString(index);
		parents.elements();
		ArrayAdapter<String>a=new ArrayAdapter<String>(Staff.this,android.R.layout.simple_list_item_1);
		Enumeration<String>en=parents.elements();
		while (en.hasMoreElements())a.add(en.nextElement());
		setListAdapter(a);
		
		foo = ID.toString();
		String temp = new String();
		temp = split2(foo);
		van = temp;

		// setContentView(R.layout.staff);
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String docID = Integer.toString(index);
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
			Intent ourIntent = new Intent(Staff.this, Staff_child.class);
			ourIntent.putExtra("docID", docID);
			ourIntent.putExtra("staffID", s);
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
			StringBuffer sb =new StringBuffer(Login.MY_URL+"staff.php");
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
			//String s = "";
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);
				ID.add(json.getString("staff_id"));
				parents.add(json.getString("staff_firstname"));
			}
		} catch (Exception e) {
			Log.e("Log.tag", "Error parsing Data" + e.toString());
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
