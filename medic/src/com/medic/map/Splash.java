package com.medic.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread timer = new Thread(){
        	public void run(){
        		try{
        			sleep(1000);
        		}catch (Exception e){
        			e.printStackTrace();
        		}finally{
        			startActivity(new Intent(Splash.this,Login.class));
        		}
        	}
        	
        };
        timer.start();
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
    
}