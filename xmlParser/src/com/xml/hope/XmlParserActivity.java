package com.xml.hope;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class XmlParserActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	static final String baseURL = "http://www.google.com/ig/api?weather=";
	TextView tv;
	EditText city,state;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b = (Button) findViewById(R.id.bWeather);
        tv = (TextView) findViewById(R.id.tvWeather);
        city = (EditText) findViewById (R.id.etCity);
        state = (EditText) findViewById (R.id.etState);
        b.setOnClickListener(this);
    
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String c = city.getText().toString();
		String s = state.getText().toString();
		
		StringBuilder URL = new StringBuilder(baseURL);
		URL.append(c + ","+ s);
		String fullUrl = URL.toString();
		try{
			URL website = new URL(fullUrl);
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			HandlingXMLStuff doingWork = new HandlingXMLStuff();
			xr.setContentHandler(doingWork);
			xr.parse(new InputSource(website.openStream()));
			String information = doingWork.getInformation();
			tv.setText(information);
			
		}catch(Exception e){
			tv.setText("error");
		}
		
		
	}

	
}