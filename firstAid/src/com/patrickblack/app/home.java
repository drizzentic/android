package com.patrickblack.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class home extends Activity implements OnClickListener {
	// making my variables public to other methods
	ImageView location;
	ImageView staff;
	ImageView values;
	ImageView directory;
	ImageView about;
	ImageView history;
	ImageView education;
	ImageView services;
	ImageView qualification;
	ImageView advert;
	ImageView emergency;
	ImageView information;
	ImageView medication;
	ImageView labresult;
	ImageView question;
	ImageView appointment;
	ImageView feedback;
	ImageView help;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		TabHost th = (TabHost) findViewById(R.id.tabhost);
		location = (ImageView) findViewById(R.id.ivLocation);
		staff = (ImageView) findViewById(R.id.ivStaff);
		values = (ImageView) findViewById(R.id.ivCoreValues);
		directory = (ImageView) findViewById(R.id.ivDirectory);
		about = (ImageView) findViewById(R.id.ivAbout);
		history = (ImageView) findViewById(R.id.ivHistory);
		education = (ImageView) findViewById(R.id.ivPatientEdu);
		services = (ImageView) findViewById(R.id.ivService);
		qualification = (ImageView) findViewById(R.id.ivQualification);
		advert = (ImageView) findViewById(R.id.ivAdvertisement);
		emergency = (ImageView) findViewById(R.id.ivEmergency);
		information = (ImageView) findViewById(R.id.ivInformation);
		medication = (ImageView) findViewById(R.id.ivMedication);
		labresult = (ImageView) findViewById(R.id.ivLabResult);
		question = (ImageView) findViewById(R.id.ivQuestion);
		appointment = (ImageView) findViewById(R.id.ivAppointment);
		feedback = (ImageView) findViewById(R.id.ivFeedback);
		help = (ImageView) findViewById(R.id.ivHelp);
		location.setOnClickListener(this);
		staff.setOnClickListener(this);
		values.setOnClickListener(this);
		directory.setOnClickListener(this);
		about.setOnClickListener(this);
		history.setOnClickListener(this);
		education.setOnClickListener(this);
		services.setOnClickListener(this);
		qualification.setOnClickListener(this);
		advert.setOnClickListener(this);
		emergency.setOnClickListener(this);
		information.setOnClickListener(this);
		medication.setOnClickListener(this);
		labresult.setOnClickListener(this);
		question.setOnClickListener(this);
		appointment.setOnClickListener(this);
		feedback.setOnClickListener(this);
		help.setOnClickListener(this);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("DOCTOR ",
				getResources().getDrawable(android.R.drawable.star_on));
		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("PATIENT",
				getResources().getDrawable(android.R.drawable.star_on));
		th.addTab(specs);
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("REQUEST",
				getResources().getDrawable(android.R.drawable.star_on));
		th.addTab(specs);
		specs = th.newTabSpec("tag4");
		specs.setContent(R.id.tab4);
		specs.setIndicator("TOOLS",
				getResources().getDrawable(android.R.drawable.star_on));
		th.addTab(specs);

	}
	

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.ivLocation:
			startActivity(new Intent(home.this,Location.class));

			break;
		case R.id.ivStaff:
			startActivity(new Intent(home.this,Staff.class));

			break;
		case R.id.ivCoreValues:
			startActivity(new Intent(home.this,CoreValues.class));
			break;
		case R.id.ivDirectory:
			startActivity(new Intent(home.this,Directory.class));
			break;
		case R.id.ivAbout:
			startActivity(new Intent(home.this,About.class));
			break;
		case R.id.ivHistory:
			startActivity(new Intent(home.this,History.class));
			break;
		case R.id.ivPatientEdu:
			startActivity(new Intent(home.this,PatientEdu.class));
			break;
		case R.id.ivService:
			startActivity(new Intent(home.this,Services.class));
			break;
		case R.id.ivQualification:
			startActivity(new Intent(home.this,Qualification.class));
			break;
		case R.id.ivAdvertisement:
			startActivity(new Intent(home.this,ClinicAdverts.class));
			break;
		case R.id.ivEmergency:
			startActivity(new Intent(home.this,Emergency.class));
			break;
		case R.id.ivInformation:
			startActivity(new Intent(home.this,Information.class));
			break;
		case R.id.ivMedication:
			startActivity(new Intent(home.this,Medication.class));
			break;
		case R.id.ivLabResult:
			startActivity(new Intent(home.this,LabResult.class));
			break;
		case R.id.ivQuestion:
			startActivity(new Intent(home.this,Question.class));
			break;
		case R.id.ivAppointment:
			startActivity(new Intent(home.this,Appointment.class));
			break;
		case R.id.ivFeedback:
			startActivity(new Intent(home.this,Feedback.class));
			break;
		case R.id.ivHelp:
			startActivity(new Intent(home.this,Help.class));
			break;

		}
	}

}