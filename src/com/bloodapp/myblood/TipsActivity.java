package com.bloodapp.myblood;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class TipsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tips);
	

	ImageButton ib=(ImageButton)findViewById(R.id.logoutt);   //ctrl+space nokku
	ib.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Intent it=new Intent(TipsActivity.this,LoginActivity.class);
			startActivity(it);
		}

	});
	}

}
