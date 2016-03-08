package com.bloodapp.myblood;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;


public class ButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);
		Button b1=(Button)findViewById(R.id.button1);
		Button b2=(Button)findViewById(R.id.button2);
		
	final Intent it2=getIntent();
		
		
		ImageButton ib=(ImageButton)findViewById(R.id.logout);
		ib.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent it=new Intent(ButtonActivity.this,LoginActivity.class);
				startActivity(it);
			}
		});
		
		
		
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(ButtonActivity.this,DregActivity.class);
				it.putExtra("UserName",it2.getStringExtra("Username").toString());
				startActivity(it);
				
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(ButtonActivity.this,NeedActivity.class);
				startActivity(it);
				
			}
		});
	}
}
