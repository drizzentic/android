package com.database.app;

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

public class DatabaseActivity extends Activity {
    /** Called when the activity is first created. */
	TextView resultView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        resultView = (TextView)findViewById(R.id.Result);
        getData();
        
    }
    public void getData(){
    	String result = "";
    	InputStream isp = null;
    	try{
    		HttpClient httpclient = new DefaultHttpClient();
    		HttpPost httppost = new HttpPost("http://10.0.2.2/cool/android.php");
    		HttpResponse response = httpclient.execute(httppost);
    		HttpEntity entity = response.getEntity();
    		isp = entity.getContent();
    	}catch(Exception e){
    		Log.e("Log.tag", "Error in http connection"+e.toString());
    		resultView.setText("Couldn't connect to database");
    	}
    	//convert response to string
    	try{
    		BufferedReader reader = new BufferedReader(new InputStreamReader(isp,"iso-8859-1"),8);
    		StringBuilder sb = new StringBuilder();
    		String line = null;
    		while ((line = reader.readLine()) != null){
    			sb.append(line + "\n");
    		}
    		isp.close();
    		result=sb.toString();
    	}catch(Exception e){
    		Log.e("Log.tag", "Error converting result "+e.toString());
    	}
    	
    	//parse json date
    	try{
    		String s = "";
    		JSONArray jArray = new JSONArray(result);
    		for (int i=0;i<jArray.length();i++){
    			JSONObject json = jArray.getJSONObject(i);
    			s = s +
    			"Name: "+json.getString("firstname")+" "+json.getString("lastname")+"\n"+
    			"Age :"+json.getInt("age")+"\n"+
    			"phone :"+json.getString("phone")+"\n"+
    			"***************************\n";
    		}
    		resultView.setText(s);
    	}catch(Exception e){
    		Log.e("Log.tag","Error parsing Data"+e.toString());
    		
    	}
    	
    	
    }
}