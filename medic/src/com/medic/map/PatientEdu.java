package com.medic.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class PatientEdu extends Activity implements OnClickListener {
	ImageView common;
	ImageView skin;
	ImageView serious;
	ImageView worms;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.patientedu);
		common = (ImageView) findViewById(R.id.ivCommon);
		skin = (ImageView) findViewById(R.id.ivSkin);
		serious = (ImageView) findViewById(R.id.ivSerious);
		worms = (ImageView) findViewById(R.id.ivWorms);
		common.setOnClickListener(this);
		skin.setOnClickListener(this);
		serious.setOnClickListener(this);
		worms.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.ivCommon:
			startActivity(new Intent(PatientEdu.this, Common.class));
			break;
		case R.id.ivSkin:
			startActivity(new Intent(PatientEdu.this, Skin.class));
			break;
		case R.id.ivSerious:
			startActivity(new Intent(PatientEdu.this, Serious.class));
			break;
		case R.id.ivWorms:
			startActivity(new Intent(PatientEdu.this, Worms.class));
			break;
		}
		
	}

}
