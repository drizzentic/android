package com.izzoh.IzzohFav;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{
	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle nerd) {
		// TODO Auto-generated method stub
		super.onCreate(nerd);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound);
		ourSong.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1000);
					
				} catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint = new Intent("com.izzoh.IzzohFav.Menu");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	

}
