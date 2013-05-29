package com.izzoh.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Json extends ExpandableListActivity {
	JSONArray jArray = null;
	JSONObject json_data = null;
	TextView txtMLSID;
	List<Map<String, String>> child1;
	List<Map<String, String>> child2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        List<Map<String, String>> groups = new ArrayList<Map<String , String>>();
        Map<String, String> group1 = new HashMap<String, String>();
        group1.put("group", "Active");
        groups.add(group1);
        Map<String, String> group2 = new HashMap<String, String>();
        group1.put("group", "pending");
        groups.add(group2);
        child1 = new ArrayList<Map<String, String>>();
        child2 = new ArrayList<Map<String, String>>();
        
        String url = "http://stage.realtylog.net/iphone/functions.php?username=hussain16&act=listing";
        
        String json = JSONfunctions.getJSONfromURL(url);
        
        try{
        	jArray = new JSONArray(json);
        	for (int i=0;i<jArray.length();i++){
        		Map<String, String> childdata1 = new HashMap<String, String>();
        		JSONObject e = jArray.getJSONObject(i);
        		String status = e.getString("2");
        		Log.e("log_tag", "Status: "+status);
        		if (status.contains("active")){
        			Log.e("log_tag", "StatusActive: "+status);
        			childdata1.put("0", String.valueOf(i+1)+ e.getString(name))
        		}
        		
        		
        	}
        }
        
    }
}