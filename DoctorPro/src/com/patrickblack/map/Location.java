package com.patrickblack.map;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class Location extends MapActivity {
	String top;
	int docID;
	MapView map;
	long start;
	long stop;
	MyLocationOverlay compass;
	MapController controller;
	int x, y;
	GeoPoint touchedPoint;
	double lat =0.0;public Location() {
	lat=assignLatitude(docID);
	}
	double lon = 0.0;public void Location1(){
		lon = assignLongitude(docID);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		map = (MapView) findViewById(R.id.mvLocation);
		map.setBuiltInZoomControls(true);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		top = extras.getString("docID");
	    docID = Integer.parseInt(top);
		}

		Touchy t = new Touchy();
		List<Overlay> overlayList = map.getOverlays();
		overlayList.add(t);
		compass = new MyLocationOverlay(Location.this, map);
		overlayList.add(compass);
		controller = map.getController();
		GeoPoint point = new GeoPoint(1, 2);
		controller.animateTo(point);
		controller.setZoom(6);
	}
	
	double assignLatitude(int id){
		double s=0;
		String result = "";
		InputStream isp = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			StringBuffer sb =new StringBuffer(Login.MY_URL+"doctor.php");
			if (id>0)sb.append("?id="+id);
			HttpPost httppost = new HttpPost(sb.toString());
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			isp = entity.getContent();
		} catch (Exception e) {
			Log.e("Log.tag", "Error in http connection" + e.toString());
		}
		// convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					isp, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			isp.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("Log.tag", "Error converting result " + e.toString());
		}

		// parse json date
		try {
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);
				s =json.getDouble("latitude");
			}
		} catch (Exception e) {
			Log.e("Log.tag", "Error parsing Data" + e.toString());
		}
		return s;
	}
	
	double assignLongitude(int id){
		double s=0;
		String result = "";
		InputStream isp = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			StringBuffer sb =new StringBuffer(Login.MY_URL+"doctor.php");
			if (id>0)sb.append("?id="+id);
			HttpPost httppost = new HttpPost(sb.toString());
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			isp = entity.getContent();
		} catch (Exception e) {
			Log.e("Log.tag", "Error in http connection" + e.toString());
		}
		// convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					isp, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			isp.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("Log.tag", "Error converting result " + e.toString());
		}

		// parse json date
		try {
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);
				s =json.getDouble("longitude");
			}
		} catch (Exception e) {
			Log.e("Log.tag", "Error parsing Data" + e.toString());
		}
		return s;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		compass.disableCompass();
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		compass.enableCompass();
		super.onResume();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	class Touchy extends Overlay {
		public boolean onTouchEvent(MotionEvent e, MapView m) {
			if (e.getAction() == MotionEvent.ACTION_DOWN) {
				start = e.getEventTime();
				x = (int) e.getX();
				y = (int) e.getY();
				touchedPoint = map.getProjection().fromPixels(x, y);
			}
			if (e.getAction() == MotionEvent.ACTION_UP) {
				stop = e.getEventTime();
			}
			if (stop - start > 1500) {
				AlertDialog alert = new AlertDialog.Builder(Location.this)
						.create();
				alert.setMessage("Choose an option, seriously");
				alert.setButton("place a pinpoint",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});

				alert.setButton2("get Address",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

								Geocoder geocoder = new Geocoder(
										getBaseContext(), Locale.getDefault());
								try {
									List<Address> address = geocoder.getFromLocation(
											touchedPoint.getLatitudeE6() / 1E6,
											touchedPoint.getLongitudeE6() / 1E6,
											1);
									if (address.size() > 0) {
										String display = "";
										for (int i = 0; i < address.get(0)
												.getMaxAddressLineIndex(); i++) {

											display += address.get(0)
													.getAddressLine(i) + "\n";
										}
										Toast t = Toast.makeText(
												getBaseContext(), display,
												Toast.LENGTH_LONG);
										t.show();

									}
								} catch (Exception e) {

								}
							}
						});
				alert.setButton3("option 3",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});
				alert.show();
			}

			return false;
		}
	}

}
