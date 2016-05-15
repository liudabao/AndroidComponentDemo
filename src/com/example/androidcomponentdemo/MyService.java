package com.example.androidcomponentdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		Log.e("MyService"," create ");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		Log.e("MyService"," startCommand ");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onStart(Intent intent,int startId){
		Log.e("MyService"," start ");
		super.onStart(intent, startId);
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.e("MyService"," destroy ");
		
	}

}
