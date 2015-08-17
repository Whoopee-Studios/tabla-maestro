package com.example.tabla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class Flash extends Activity {
Thread t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash);
		t=new Thread(){
			public void run(){
				try{
					sleep(2000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent i=new Intent(Flash.this,Tabla.class);
					startActivity(i);
				}
			}
		};
		t.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_flash, menu);
		return true;
	}

}
