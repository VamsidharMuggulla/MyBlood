package com.bloodapp.myblood;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Activity {
	
	EditText et1; //uname
	EditText et2; //password
	 // signin
	boolean b2=false;//return of validate
	
	
	Context context;
	    
	 //Alerts alerts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e("email", "message");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		context=this;
		Log.e("email", "message");
		
		Button bt1,bt2;
		//alerts=new Alerts();
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//NETWORK TEST AND ALERRT
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		//Intent it=getIntent();
		//final boolean b=it.getBooleanExtra("test", isChild());
		//if(!b)
		//{
		//	alerts.networkError(context);
		//}
		
		//NETWORK TEST AND ALERT ENDS
		
		
		// HANDLE LOGIN
		et1=(EditText)findViewById(R.id.email);
		et2=(EditText)findViewById(R.id.password);
		bt1=(Button)findViewById(R.id.log);  //now see it will
		
		//Log.e("OUT",et1.getText().toString());
		bt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String email=et1.getText().toString();
				Log.e("email", "message");
				String password=et2.getText().toString();
				Log.e("PASS", "message");
				if(!email.isEmpty())
				{
					
					Logon l=new Logon();
					b2=l.validate(context,email,password); 
				}
				else
				{
					//alerts.invalidEmailOrPassword(context);
					et1.setText("");
					et2.setText("");
				}
				if(b2){
					Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show();
					Intent it=new Intent(LoginActivity.this,ButtonActivity.class);
					it.putExtra("Username", email);
					startActivity(it);
					//finishAffinity();		
					
				}
				else
					Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();	
					//alerts.invalidEmailOrPassword(context);	
			}
		});
		//HANDLE LOGIN --ENDS--
			
		/*//INFO
		  tv1=(TextView)findViewById(R.id.textView4);
		  tv2=(TextView)findViewById(R.id.textView5);
		  //tv3=(TextView)findViewById(R.id.textView6);
		  
		  tv1.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(MainActivity.this,CollegeRegister.class);
				startActivity(it);
			}
		});
		  tv2.setOnClickListener(new OnClickListener() {			
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent it=new Intent(MainActivity.this,RegisterCollegeCode.class);
					startActivity(it);
				}
			});
		 //INFO END*/
		
		bt2 =(Button)findViewById(R.id.register);
		
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(LoginActivity.this,RegActivity.class);
				startActivity(it);
				
			}
		});
	}
	
}
