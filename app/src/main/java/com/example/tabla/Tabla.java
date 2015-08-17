package com.example.tabla;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.FrameLayout;

public class Tabla extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabla);
		FrameLayout tablaFrameLayout = (FrameLayout)findViewById(R.id.danceFrame);
		tablaFrameLayout.setOnTouchListener((TablaBitmap)findViewById(R.id.img_view));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
