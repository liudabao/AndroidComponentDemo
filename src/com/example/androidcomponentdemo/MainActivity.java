package com.example.androidcomponentdemo;


import java.sql.Connection;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btn_1;
	Button btn_2;
	Button btn_3;
	Button btn_4;
	Button btn_5;
	Button btn_6;
	Button btn_7;
	Button btn_8;
	MyReceiver3 receiver;
	IntentFilter filter;
	LocalBroadcastManager manager;
	MyService2.DownBinder binder;
	ServiceConnection connection=new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			binder=(MyService2.DownBinder)service;
			binder.download();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.e("Activity", "service unbind");
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	public void initView(){
		btn_1=(Button)findViewById(R.id.button1);
		btn_2=(Button)findViewById(R.id.button2);
		btn_3=(Button)findViewById(R.id.button3);
		btn_4=(Button)findViewById(R.id.button4);
		btn_5=(Button)findViewById(R.id.button5);
		btn_6=(Button)findViewById(R.id.button6);
		btn_7=(Button)findViewById(R.id.button7);
		btn_8=(Button)findViewById(R.id.button8);
		
		filter=new IntentFilter();
		receiver=new MyReceiver3();
		manager=LocalBroadcastManager.getInstance(this);
		
		btn_1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("com.test.broad1");
				sendBroadcast(intent);
			}
		});
		
        btn_2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("com.test.broad2");
				sendOrderedBroadcast(intent, null);
			}
		});
        
       btn_7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("com.test.broad3");
				manager.sendBroadcast(intent);
			}
		});
       filter.addAction("com.test.broad3");
       manager.registerReceiver(receiver, filter);

        btn_3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, MyService.class);
				startService(intent);
			}
		});
        btn_4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, MyService.class);
				stopService(intent);
			}
		});
        btn_5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, MyService2.class);
				bindService(intent, connection, BIND_AUTO_CREATE);
			}
		});
        btn_6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, MyService2.class);
				unbindService(connection);
			}
		});
	}
	
	@Override
	public void onStart(){
		super.onStart();
		Log.e("Activity", "activity start");
	}
	
	@Override
	public void onRestart(){
		super.onRestart();
		Log.e("Activity", "activity restart");
	}
	
	@Override
	public void onResume(){
		super.onResume();
		Log.e("Activity", "activity resume");
	}
	
	@Override
	public void onPause(){
		super.onPause();
		Log.e("Activity", "activity pause");
	}
	
	@Override
	public void onStop(){
		super.onStop();
		Log.e("Activity", "activity stop");
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.e("Activity", "activity destroy");
		unregisterReceiver(receiver);
	}

	@Override
	public void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		Log.e("Acitivy", " saveInstanceState");
		
		
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState){
		Log.e("Acitivy", " restore "+savedInstanceState.getString("test"));
		super.onRestoreInstanceState(savedInstanceState);
		
	}
	
	public void onConfigurationChanged (Configuration newConfig){
		Log.e("Activity", "activity config");
		super.onConfigurationChanged(newConfig);
	}

}
