package com.patrickblack.map;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Emergency extends Activity implements OnClickListener {
	Button ambulance;
	Button fire;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.emergency);
		ambulance = (Button) findViewById(R.id.bAmbulance);
		fire = (Button) findViewById(R.id.bFire);
		ambulance.setOnClickListener(this);
		fire.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bAmbulance:
			try{
				Intent callAmbulance = new Intent(Intent.ACTION_CALL);
				callAmbulance.setData(Uri.parse("tel:0729040397"));
				startActivity(callAmbulance);
			}catch (Exception e){
				Log.e("emergency", "call failed", e);
			}

			break;
		case R.id.bFire:
			try{
				Intent callFire = new Intent(Intent.ACTION_CALL);
				callFire.setData(Uri.parse("tel:0729040397"));
				startActivity(callFire);
			}catch (Exception e){
				Log.e("emergency", "call failed", e);
			}

			break;
		}
	}

}
