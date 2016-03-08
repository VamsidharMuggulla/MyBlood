package com.bloodapp.myblood;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DregActivity extends Activity {
	
	
	
	EditText ETaddress;
	EditText ETlocation;
	//EditText ETpin;
	EditText ETldd;
	Spinner	 SpinnerGroup;
	Spinner SpinnerDist;
	
	

	String address;
	String location;
	//String	pin;
	String ldd;
	String group;
	String uname;
	String dist;
	

	
	
	
	
	Context context;
	//Alerts alerts;
	
	
	
	

Button register1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dreg);
		
		context=this;
		
		//alerts=new Alerts();
	
		
		
		ETaddress=(EditText)findViewById(R.id.editText5);
		ETlocation=(EditText)findViewById(R.id.editText6);
		//ETpin=(EditText)findViewById(R.id.editText1);
		ETldd=(EditText)findViewById(R.id.editText2);
		SpinnerGroup=(Spinner)findViewById(R.id.SpinnerState);
		SpinnerDist=(Spinner)findViewById(R.id.SpinnerState2);
		
		
				  register1=(Button)findViewById(R.id.button1);
					register1.setOnClickListener(new OnClickListener() {
						@SuppressLint("ShowToast") @Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub`
						//	ETCollegeName.setTextColor(Color.parseColor("#ff3300"));
							
							Log.e("1","1");
							Intent x=getIntent();
							uname=x.getStringExtra("UserName").toString();
							Log.e("1","2");
							
							address=ETaddress.getText().toString();

							Log.e("",address);
							
							location=ETlocation.getText().toString();
							Log.e("",location);
							//pin=ETpin.getText().toString();
							//Log.e("",pin);
							ldd=ETldd.getText().toString();
							group=SpinnerGroup.getSelectedItem().toString();
							Log.e("",group);
							dist=SpinnerDist.getSelectedItem().toString();
							Log.e("",dist);
							
							Log.e("1","3");
							DRegisterValidate crv=new DRegisterValidate();
							String alert="";
							Log.e("1","4");
							Log.e("5",alert);
							Log.e("LOG 1",alert);
							alert=crv.validateAddress(address,ETaddress);
							Log.e("LOG 2",alert);
							alert=crv.validateLocation(location,ETlocation);
							//Log.e("LOG 3",alert);
							//alert=crv.validatePin(pin,ETpin);
							Log.e("LOG 4",alert);
							alert=crv.validateldd(ldd,ETldd);
							
							Log.e("Username 999", uname);
								
							if((alert.length()<2)!=true)
							{
								Log.e("VALIDATION"," ERRORS");
								Toast.makeText(getApplicationContext(),alert,Toast.LENGTH_SHORT);
							}
							
							else
							{
	
							
							ArrayList<NameValuePair> a1=new ArrayList<NameValuePair>();
							a1.add(new BasicNameValuePair("username", uname));
							a1.add(new BasicNameValuePair("address", address));
							a1.add(new BasicNameValuePair("location", location));
							a1.add(new BasicNameValuePair("dist", dist));
							a1.add(new BasicNameValuePair("ldd", ldd));
							a1.add(new BasicNameValuePair("group", group));
							
							 Log.e("log_tag", "ONE");

							 Log.e("ArrayList", ""+a1.toString());
							

								InputStream is2 = null;
								// TODO Auto-generated method stub
								 try 
								 {
									
									 
									 HttpClient httpclient = new DefaultHttpClient();
									 HttpPost httppost = new HttpPost("http://www.nmsl.in/myblood/dreg.php");
									 httppost.setEntity(new UrlEncodedFormEntity(a1));
									 HttpResponse response = httpclient.execute(httppost);
									 HttpEntity entity = response.getEntity();
									  is2 = entity.getContent();
									 
									// Toast.makeText(getApplicationContext(), "Connection Success Inserted",Toast.LENGTH_SHORT).show();					 
									 
									 //Log.e("log_tag", " in doinbackground connection success");
													
									 // Toast.makeText(getApplicationContext(), “pass”,Toast.LENGTH_SHORT).show();
									  } catch (Exception e) 
									  {
										//  x="false";
										  Log.e("log_tag", "Error in http connection" + e.toString());
									  }
								 try 
								 {
									 BufferedReader br=new BufferedReader(new InputStreamReader(is2,"iso-8859-1"));
									 StringBuilder sb=new StringBuilder();
									 String line=null;
									 while((line=br.readLine())!=null)
										 sb.append(line+"\n");
									 is2.close();
									String result2=sb.toString();
									Log.e("LOG INSRT :", result2);
									
									boolean x2=result2 !=null;
									if(x2)
									{
									 
									 ETaddress.setText("");
									 ETlocation.setText("");
									 //ETpin.setText("");
									 ETldd.setText("");
									
									 
									 Toast.makeText(getApplicationContext(),"Registarion Sucess", Toast.LENGTH_SHORT).show();
									 
									Intent it=new Intent(DregActivity.this,TipsActivity.class);
									startActivity(it);
									finishAffinity();									 
								 }
									else
									{
										Toast.makeText(getApplicationContext(),"Registarion Failed \n Try Again", Toast.LENGTH_SHORT).show();
									}
								 }
								 catch(Exception e) 
								 {
									 //x="false2";
									 Log.e("log_tag","Error  in insert "+e.toString());
								}
				
							}
						}

					
					});
				//REGISTER REVIEW
	}
	
}
