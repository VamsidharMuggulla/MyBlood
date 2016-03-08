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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends Activity {
	
	
	
	EditText ETfname;
	EditText ETemail;
	EditText ETpass;
	EditText ETdob;
	EditText ETphone;
	
	

	String fname;
	String email;
	String pass;
	String dob;
	String phone;

	
	
	
	
	Context context;
	//Alerts alerts;
	
	
	
	TextView tv2; //Register User
	TextView tv3; //Sign In

Button register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		
		context=this;
		
		//alerts=new Alerts();
	
		
		
		ETfname=(EditText)findViewById(R.id.editText1);
		ETemail=(EditText)findViewById(R.id.editText6);
		ETpass=(EditText)findViewById(R.id.editText4);
		ETdob=(EditText)findViewById(R.id.editText2);
		ETphone=(EditText)findViewById(R.id.editText7);
		
		 
		//COLLEGE REGISTRATION --ENDS--
		
		// HOME IMAGEBUTTON
		/*ImageButton IBHome = (ImageButton)findViewById(R.id.IBHome);
		IBHome.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(CollegeRegister.this,MainActivity.class);
				startActivity(it);
			}
		});*/
		//HOME IMAGEBUTTON
		
		
		  //GO BUTTON
		/*		bGo=(Button)findViewById(R.id.Go);
				bGo.setOnClickListener(new OnClickListener() {			
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent it=new Intent(CollegeRegister.this,RegisterCollegeCode.class);
						startActivity(it);
					}
				});*/
		 //GO BUTTON END
				
				
				//INFO
		/*		  //tv1=(TextView)findViewById(R.id.textView4);
				  tv2=(TextView)findViewById(R.id.textView5);
				  tv3=(TextView)findViewById(R.id.textView6);
				  
				  tv2.setOnClickListener(new OnClickListener() {			
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent it=new Intent(CollegeRegister.this,RegisterCollegeCode.class);
						startActivity(it);
					}
				});
				  tv3.setOnClickListener(new OnClickListener() {			
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							Intent it=new Intent(CollegeRegister.this,MainActivity.class);
							startActivity(it);
						}
					});*/
				 //INFO END
				
				  //REGISTER REVIEW
				  register=(Button)findViewById(R.id.button1);
					register.setOnClickListener(new OnClickListener() {
						@SuppressLint("ShowToast") @Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub`
						//	ETCollegeName.setTextColor(Color.parseColor("#ff3300"));
							
							fname=ETfname.getText().toString();
							email=ETemail.getText().toString();
							pass=ETpass.getText().toString();
							dob=ETdob.getText().toString();
							phone=ETphone.getText().toString();
						
							RegisterValidate crv=new RegisterValidate();
							String alert="";
							Log.e("LOG 1",alert);
							alert=crv.validateName(context,fname,ETfname);
							Log.e("LOG 2",alert);
							alert=crv.validateEmail(context,email,ETemail);
							Log.e("LOG 3",alert);
							alert=crv.validatePassword(context,pass,ETpass);
							Log.e("LOG 4",alert);
							alert=crv.validatePhone(context,phone,ETphone);
							Log.e("LOG 5",alert);
							alert=crv.validatedob(context,dob,ETdob);
							
								
							if(alert.length()>2)
							{
								//alerts.invalidDetails(context,alert);
								Toast.makeText(context, ""+alert,Toast.LENGTH_SHORT).show();
							
							}
							else
							{
								Log.e("VALIDATION"," NO VALIDATION ERRORS");
								
							
							
							
							//
							
							ArrayList<NameValuePair> al=new ArrayList<NameValuePair>();
							al.add(new BasicNameValuePair("fname", fname));
							al.add(new BasicNameValuePair("email", email));
							al.add(new BasicNameValuePair("pass", pass));
							al.add(new BasicNameValuePair("phone", phone));
							al.add(new BasicNameValuePair("dob", dob));
							 Log.e("log_tag", "ONE");

							 Log.e("ArrayList", ""+al.toString());
							

								InputStream is2 = null;
								// TODO Auto-generated method stub
								 try 
								 {
									
									 
									 HttpClient httpclient = new DefaultHttpClient();
									 HttpPost httppost = new HttpPost("http://www.nmsl.in/myblood/reg.php");
									 httppost.setEntity(new UrlEncodedFormEntity(al));
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
									Log.e("LOG INSRT1==",result2);
									Log.e("LOG INSRT2",""+result2);
									Log.e("LOG INSRT3==",""+result2.equals(true));
									Log.e("LOG INSRT4==",""+result2.equals(false));
									Log.e("LOG INSRT5==",""+result2.equals("false"));
									Log.e("LOG INSRT6==",""+result2.equals("true"));
									
									
									
									Log.e("LOG INSRT7==",""+(result2=="true"));
									String x="true";
									//x=result2; != null;
									
									Log.e("res",""+result2.equals(false));
									
									Log.e("X==",""+x);
									if(result2.contains("false"))
									{
										x="false";
										Log.e("resulllllll",""+result2.equals(false));
										
										
									}
									
									 if(!x.equals("false"))
									 {
									 ETfname.setText("");
									 ETemail.setText("");
									 ETpass.setText("");
									 ETdob.setText("");
									 ETphone.setText("");
									 
									 Log.e("FALSE","RESULT IS FALSE");
									 Toast.makeText(getApplicationContext(),"Registarion Sucess", Toast.LENGTH_SHORT).show();
									 Intent it=new Intent(RegActivity.this,ButtonActivity.class);
									 it.putExtra("Username", email);
									 Log.e("LoginActivity=",email);
									 startActivity(it);
									 finishAffinity();
									 
								 }
									else
									{
										Log.e("FALSE","RESULT IS NOT FALSE");
										Toast.makeText(getApplicationContext(),"Already Registered,\n" +
												"Please Login..", Toast.LENGTH_LONG).show();
									}
								 }
								 catch(Exception e) 
								 {
									 //x="false2";
									 Log.e("Exception String",e.toString());
									 Log.e("Exception Message",e.getMessage());
									 Log.e("Exception Cause",e.getCause().toString());
									 //Log.e("Exception StackTrace",e.printStackTrace());
									 
									 Log.e("log_tag","Error  in insert "+e.toString());
								}
						}
						}
						

					
					});
				//REGISTER REVIEW
	}
	
}
