package com.izzoh.app;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.TableLayout;
 
import android.widget.LinearLayout;
 
import android.widget.ListView;
 
import android.widget.TabHost;
 
import android.widget.LinearLayout.LayoutParams;
 
import android.widget.TabHost.TabSpec;


public class homeActivity extends Activity {
	
	
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        //set up tabs
        TabHost host = (TabHost) findViewById(R.id.TabHost1);
        host.setup();
        //my menu tabs
        TabSpec personalData = host.newTabSpec("personalTab");
        personalData.setIndicator(getResources().getString(R.string.menu), getResources().getDrawable(android.R.drawable.star_on));
        personalData.setContent(R.id.svPersonal);
        host.addTab(personalData);
        //disease tab
        TabSpec diseaseData = host.newTabSpec("DiseaseTab");
        personalData.setIndicator(getResources().getString(R.string.menu), getResources().getDrawable(android.R.drawable.star_on));
        personalData.setContent(R.id.svDiseaseMenu);
        host.addTab(diseaseData);
        //appointment tab
        TabSpec appointmentData = host.newTabSpec("appointmentTab");
        personalData.setIndicator(getResources().getString(R.string.menu), getResources().getDrawable(android.R.drawable.star_on));
        personalData.setContent(R.id.svAppointmentMenu);
        host.addTab(appointmentData);
        //other tab
        TabSpec otherData = host.newTabSpec("otherTab");
        personalData.setIndicator(getResources().getString(R.string.menu), getResources().getDrawable(android.R.drawable.star_on));
        personalData.setContent(R.id.svOthersMenu);
        host.addTab(otherData);
        //set default tab
        host.setCurrentTabByTag("DiseaseTab");
        //retrieve the TableLayout references
        TableLayout personalTable = (TableLayout) findViewById(R.id.tlPersonalMenu);
        TableLayout diseaseTable = (TableLayout) findViewById(R.id.tlDiseaseList);
        TableLayout appointmentTable = (TableLayout) findViewById(R.id.tlAppointmentList);
        TableLayout otherTable = (TableLayout) findViewById(R.id.tlOthersList);
        
    }
    
       
			
}
   
