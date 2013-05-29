package com.patrickblack.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Appointment extends Activity implements OnClickListener{
	ImageView appView;
	ImageView appCre;
	String top;
	String temp;
	int docID;
	int patID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.appointment);
		appView = (ImageView) findViewById(R.id.ivViewAppointment);
		appCre = (ImageView) findViewById(R.id.ivCreateAppointment);
		appView.setOnClickListener(this);
		appCre.setOnClickListener(this);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		top = extras.getString("docID");
		temp = extras.getString("patID");
	    docID = Integer.parseInt(top);
	    patID=Integer.parseInt(temp);
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.ivViewAppointment:
			//code to view appointments
			Intent viewAppoint = new Intent(Appointment.this,ViewApp.class);
			viewAppoint.putExtra("patID", temp);
			viewAppoint.putExtra("docID", top);
			startActivity(viewAppoint);
			
			break;
		case R.id.ivCreateAppointment:
			Intent createAppoint = new Intent(Appointment.this,CreateApp.class);
			createAppoint.putExtra("patID", temp);
			createAppoint.putExtra("docID", top);
			startActivity(createAppoint);
			break;
		}
	}
	

}
