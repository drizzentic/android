package com.medic.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Ignore extends Activity implements OnClickListener {
	ImageView firstAid;
	ImageView patientEdu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ignore);
		firstAid = (ImageView) findViewById(R.id.ivFirstaid2);
		patientEdu = (ImageView) findViewById(R.id.ivPatientEdu2);
		firstAid.setOnClickListener(this);
		patientEdu.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.ivFirstaid2:
			Intent aid = new Intent(Ignore.this,Information.class);
			startActivity(aid);
			
			break;
		case R.id.ivPatientEdu2:
			Intent dis = new Intent(Ignore.this,PatientEdu.class);
			startActivity(dis);
			break;
		}
		
	}
	

}
