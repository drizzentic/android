package com.izzoh.expandableList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class ExpandableListActivity extends Activity {
    /** Called when the activity is first created. */
	 ExpandableListView list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ExpandableListView(this);
        list.setGroupIndicator(getResources().getDrawable(R.drawable.expandicon));
        list.setIndicatorBounds(list.getRight(), list.getWidth());
        list.setChildIndicator(null);
        String[] titles = {"Days","Months"};
        String[] Days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","saturday"};
        String[] Months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        /*
         * JSONArray jtitles;
         * string s = "";
         * for (int i=0;i<2;i++){
         * JSONObject json = jtitles.getJSONObject(i);
         * s=s + 
         * "Disease:"+json.getString("name");
         * }
         * 
         * 
         * 
         * 
         * 
         * 
         */
        String[][] contents = {Days,Months};
        ExpandableAdapter adapter = new ExpandableAdapter(this,titles,contents);
        list.setAdapter(adapter);
        setContentView(list);
    }
}
    
   