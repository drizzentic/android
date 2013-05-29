package com.patrickblack.map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CreateApp extends Activity implements OnClickListener{
	
	EditText name;
	EditText address;
	EditText email;
	EditText phoneNo;
	EditText contact;
	EditText clinicNo;
	EditText insuranceNo;
	EditText concern;
	Button submit;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createapp);
		name = (EditText) findViewById(R.id.etName);
		address = (EditText) findViewById(R.id.etAddress);
		contact = (EditText) findViewById(R.id.etTime);
		email = (EditText) findViewById(R.id.etEmail);
		phoneNo = (EditText) findViewById(R.id.etPhone);
		clinicNo = (EditText) findViewById(R.id.etClinicNo);
		concern = (EditText) findViewById(R.id.etConcern);
		insuranceNo = (EditText) findViewById(R.id.etInsurance);
		submit = (Button) findViewById(R.id.bSubmit);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bSubmit:
			
			break;
		}
		
	}
	

}
