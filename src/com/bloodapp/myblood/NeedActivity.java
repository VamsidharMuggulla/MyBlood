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
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class NeedActivity extends Activity {

	EditText ETpname;
	//EditText ETpadd;
	EditText ETlocation;
	Spinner Spinnerbgroup;
	Spinner Spinnerdist;
	
	Button search;
	
	
	String pname;
	//String padd;
	String pdist;
	String plocation;
	String bgroup;
	Context context=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_need);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy);
		
		ImageButton ib=(ImageButton)findViewById(R.id.logout);
		ib.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent it=new Intent(NeedActivity.this,LoginActivity.class);
				startActivity(it);
			}
		});
		
		
		
		
		
		ETpname=(EditText)findViewById(R.id.name);
		ETlocation=(EditText)findViewById(R.id.location);
		//ETpadd=(EditText)findViewById(R.id.add);
		Spinnerbgroup=(Spinner)findViewById(R.id.SpinnerState);
		Spinnerdist=(Spinner)findViewById(R.id.SpinnerState2);
		
		search=(Button)findViewById(R.id.button1);
		search.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ShowToast") @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				pname=ETpname.getText().toString();
				//padd=ETpadd.getText().toString();
				plocation=ETlocation.getText().toString();
				bgroup=Spinnerbgroup.getSelectedItem().toString();
				pdist=Spinnerdist.getSelectedItem().toString();
				
				
				
				
				ArrayList<NameValuePair> a1=new ArrayList<NameValuePair>();
				//a1.add(new BasicNameValuePair("pname", pname));
				//a1.add(new BasicNameValuePair("padd", padd));
				a1.add(new BasicNameValuePair("plocation", plocation));
				a1.add(new BasicNameValuePair("bgroup", bgroup));
				a1.add(new BasicNameValuePair("dist", pdist));
				
				
				 Log.e("log_tag", "ONE");

				 Log.e("ArrayList", ""+a1.toString());
				 
				 
				 
				 InputStream is2 = null;
					// TODO Auto-generated method stub
					 try 
					 {
						
						 
						 HttpClient httpclient = new DefaultHttpClient();
						 HttpPost httppost = new HttpPost("http://www.nmsl.in/myblood/search.php");
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
						//convert response to string
					  try {
						  Log.e("log_tag", "TWO");
					   BufferedReader reader = new BufferedReader(new InputStreamReader(is2,"iso-8859-1"));
					  StringBuilder sb = new StringBuilder();
					 String line = null;
					  while ((line = reader.readLine()) != null) {
					  sb.append(line + "\n");
					  // Toast.makeText(getApplicationContext(), “Input Reading pass”, Toast.LENGTH_SHORT).show();
					  }
					  is2.close();
					 
					  Log.e("log_tag", "THREE");
					 String result = sb.toString();
					 
					 
					 Log.e("log_tag", " JSON"+result);
					 

					 boolean x=result!=null;
					 Log.e("log_tag", "444");
					 if(!x||result.equals("")||result.equals(null)||result==""||result==null)
					 {						 
						 Log.e("log_tag", "2222");
						Toast.makeText(getApplicationContext(),"No ResultsFound",Toast.LENGTH_SHORT);
					 }
					 Log.e("log_tag", "1111");
					  JSONArray jArray=new JSONArray(result);
					  Log.e("log_tag", "FOUR");
					  //JSONArray ar=new JSONArray(ob);
					  
					  String[] name=new String[jArray.length()];
					  String[] bgr=new String[jArray.length()];
					  String[] location=new String[jArray.length()];
					  String[] phone=new String[jArray.length()];
					  
					  for(int i=0;i<jArray.length();i++)
					  {
						  Log.e("FOR", ""+i);
						  JSONObject json_data = jArray.getJSONObject(i);
						  name[i]=json_data.getString("fname");
						  bgr[i]=json_data.getString("bgroup");
						  location[i]=json_data.getString("location");
						  phone[i]=json_data.getString("phone");
						  
						  Log.e("log_tag", "LOOP fname: "+name[i].toString()+" bgroup : "+bgr[i].toString()+"\nPhone:"+ phone[i].toString()+" loc : "+location[i].toString());
						   
					  }
					  if(jArray.length()==0)
					  {
						  Toast.makeText(getApplicationContext(), "No ResultsFound",Toast.LENGTH_SHORT);
					  }
					  else
					  {
						  reader.close();
						  Intent it=new Intent(NeedActivity.this, SearchActivity.class);
						  for(int i=0;i<jArray.length();i++)
						  {
							  it.putExtra("name"+i, name[i]);
							  it.putExtra("bgroup"+i, bgr[i]);
							  it.putExtra("location"+i, location[i]);
							  it.putExtra("phone"+i, phone[i]);
						  }
						  
						  it.putExtra("noOfPeople",""+jArray.length());
						  startActivity(it);
						  
						  
					  }
					  
					  
					
					  //tv.setText(result);
					  } catch (Exception e) {
						  
						  Toast.makeText(getApplicationContext(), "Sorry No Results Found...", Toast.LENGTH_SHORT).show();
					  Log.e("log_tag", " Error converting result" + e.toString());
					  				 
					  }	 
					
	
				

				
			}
		});
		
	}

	

}
