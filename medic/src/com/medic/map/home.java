package com.medic.map;

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
	String top;
	String patID;
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
	ImageView settings;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		top = extras.getString("pele");
		patID = extras.getString("patID");
			// index = Integer.parseInt(top);
		}

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
		settings = (ImageView) findViewById(R.id.ivSettings);
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
		settings.setOnClickListener(this);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("DOCTOR ",
				getResources().getDrawable(android.R.drawable.star_on));
		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("INFO",
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
			Intent location = new Intent(home.this, Location.class);
			location.putExtra("docID", top);
			startActivity(location);

			break;
		case R.id.ivStaff:
			//startActivity(new Intent(home.this, Staff.class));
			Intent staff = new Intent(home.this, Staff.class);
			staff.putExtra("docID", top);
			startActivity(staff);

			break;
		case R.id.ivCoreValues:
			Intent values= new Intent(home.this, CoreValues.class);
			values.putExtra("docID", top);
			startActivity(values);
			break;
		case R.id.ivDirectory:
			Intent directory = new Intent(home.this, Directory.class);
			directory.putExtra("docID", top);
			startActivity(directory);
			break;
		case R.id.ivAbout:
			Intent about=new Intent(home.this, About.class);
			about.putExtra("docID", top);
			startActivity(about);
			break;
		case R.id.ivHistory:
			Intent history=new Intent(home.this, History.class);
			history.putExtra("docID", top);
			startActivity(history);
			break;
		case R.id.ivPatientEdu:
			startActivity(new Intent(home.this, PatientEdu.class));
			break;
		case R.id.ivService:
			Intent services = new Intent(home.this, Services.class);
			services.putExtra("docID", top);
			startActivity(services);
			break;
		case R.id.ivQualification:
			Intent specialty = new Intent(home.this, Qualification.class);
			specialty.putExtra("docID", top);
			startActivity(specialty);
			break;
		case R.id.ivAdvertisement:
			Intent updates = new Intent(home.this, ClinicAdverts.class);
			updates.putExtra("docID", top);
			startActivity(updates);
			break;
		case R.id.ivEmergency:
			Intent emergency =new Intent(home.this, Emergency.class);
			emergency.putExtra("docID", top);
			startActivity(emergency);
			break;
		case R.id.ivInformation:
			startActivity(new Intent(home.this, Information.class));
			break;
		case R.id.ivMedication:
			Intent medication = new Intent(home.this, Medication.class);
			medication.putExtra("docID", top);
			medication.putExtra("patID", patID);
			startActivity(medication);
			break;
		case R.id.ivLabResult:
			Intent report=new Intent(home.this, LabResult.class);
			report.putExtra("docID", top);
			report.putExtra("patID", patID);
			startActivity(report);
			break;
		case R.id.ivQuestion:
			Intent question=new Intent(home.this, Question.class);
			question.putExtra("docID", top);
			question.putExtra("patID", patID);
			startActivity(question);
			break;
		case R.id.ivAppointment:
			Intent appointment=new Intent(home.this, Appointment.class);
			appointment.putExtra("docID", top);
			appointment.putExtra("patID", patID);
			startActivity(appointment);
			break;
		case R.id.ivFeedback:
			Intent feedback = new Intent(home.this, Feedback.class);
			feedback.putExtra("docID", top);
			feedback.putExtra("patID", patID);
			startActivity(feedback);
			break;
		case R.id.ivHelp:
			Intent help = new Intent(home.this, Help.class);
			help.putExtra("docID", top);
			help.putExtra("patID", patID);
			startActivity(help);
			break;
		case R.id.ivSettings:
			Intent set = new Intent(home.this, Settings.class);
			set.putExtra("docID", top);
			set.putExtra("patID", patID);
			startActivity(set);
			break;

		}
	}

}