package com.android.easymarket;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainEasyMarket extends Activity implements OnClickListener {

	Button btScan;
	TextView tvResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_easy_market);

		btScan = (Button) findViewById(R.id.btScan);
		tvResultado = (TextView) findViewById(R.id.tvResultadoScan);
		btScan.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_easy_market, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btScan) {
			// go to fullscreen scan
			Intent intent = new Intent("com.android.easymarket.SCAN");
			intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			startActivityForResult(intent, 0);
		}

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == Activity.RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				String formatName = intent.getStringExtra("SCAN_RESULT_FORMAT");
				tvResultado.setText(contents + "\n\n" + formatName);
			} else if (resultCode == Activity.RESULT_CANCELED) {
				tvResultado.setText("Error en la lectura");
			}
		}
	}

}
