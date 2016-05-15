package com.example.androidcomponentdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service{

	private DownBinder binder=new DownBinder();
	
	class DownBinder extends Binder{
		public void download(){
			Log.e("MyService2"," download ");
		}
	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return binder;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		Log.e("MyService2"," create ");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		Log.e("MyService2"," startCommand ");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onStart(Intent intent,int startId){
		Log.e("MyService2"," start ");
		super.onStart(intent, startId);
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.e("MyService2"," destroy ");
		
	}

}
