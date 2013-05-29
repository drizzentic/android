package com.medic.map;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Question extends Activity implements OnClickListener{
	EditText topic;
	EditText question;
	Button submit;
	Button viewQA;
	TextView resultView;
	String top;
	int docID;
	int patID;
	String temp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.question);
		topic = (EditText) findViewById(R.id.etTopic);
		question = (EditText) findViewById(R.id.etQuestion);
		submit = (Button) findViewById(R.id.bSubmitQuestion);
		viewQA = (Button) findViewById(R.id.bViewAnswer);
		submit.setOnClickListener(this);
		viewQA.setOnClickListener(this);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		top = extras.getString("docID");
		temp = extras.getString("patID");
	    docID = Integer.parseInt(top);
	    patID=Integer.parseInt(temp);
		}
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSubmitQuestion:
			String stuff2 = topic.getText().toString();
			String Topic =insertSymbol(stuff2);
			String stuff = question.getText().toString();
			String Body = insertSymbol(stuff);
			insertData(docID,patID,Topic,Body);
			
			break;
			
		case R.id.bViewAnswer:
			Intent viewAnswers = new Intent(Question.this,Qa.class);
			viewAnswers.putExtra("patID", temp);
			viewAnswers.putExtra("docID", top);
			startActivity(viewAnswers);
			break;
		}
	}
	
	public void insertData(int id,int sid, String top, String body){
		InputStream isp = null;
		try{
		HttpClient httpclient = new DefaultHttpClient();
		StringBuffer sb =new StringBuffer(Login.MY_URL+"askQuestion.php");
		sb.append("?id=" + id + "&sid=" +sid+"&top='"+top+"'&body='"+body+"'");
		HttpPost httppost = new HttpPost(sb.toString());
		
		HttpResponse response = httpclient.execute(httppost);
		
		HttpEntity entity = response.getEntity();
		isp = entity.getContent();
		
	} catch (Exception e) {
		Log.e("Log.tag", "Error in http connection" + e.toString());
	}
		
	}
	public String insertSymbol(String split){
		//split.replace(" ", "©");
		String unsplit = split.replaceAll(" ", "0");
		return  unsplit;
	}
	

}
