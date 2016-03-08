package com.bloodapp.myblood;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Logon
{
	public boolean validate(Context context,String email,String password)
	{
		//Network n=new Network();
		
		InputStream is;
		
		/*Alerts alerts=new Alerts();
		boolean b=n.testNetwork();
		if(!b)
		{
			alerts.networkError(context);
			return false;
		}*/
		 try {
			 HttpClient httpclient = new DefaultHttpClient();
			 HttpPost httppost = new HttpPost("http://www.nmsl.in/myblood/login.php");
			 HttpResponse response = httpclient.execute(httppost);
			 HttpEntity entity = response.getEntity();
			 is = entity.getContent();
			
			 Log.e("log_tag", "Logon class Login.php success");
			 // Toast.makeText(getApplicationContext(), “pass”,Toast.LENGTH_SHORT).show();
			  } catch (Exception e) {
				  Log.e("log_tag", "Logon class Login.php failure" + e.toString());
				  return false;				 					 
			  }
		//convert response to string
		  try {
		   BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
		  StringBuilder sb = new StringBuilder();
		 String line = null;
		  while ((line = reader.readLine()) != null) {
		  sb.append(line + "\n");
		  // Toast.makeText(getApplicationContext(), “Input Reading pass”, Toast.LENGTH_SHORT).show();
		  }
		  is.close();
		 
		 String result = sb.toString();
		  JSONArray jArray=new JSONArray(result);
		  
		  String[] email2=new String[jArray.length()];
			String[] password2=new String[jArray.length()];
			
		  //JSONArray ar=new JSONArray(ob);
		  for(int i=0;i<jArray.length();i++)
		  {
			  JSONObject json_data = jArray.getJSONObject(i);
			  email2[i]=json_data.getString("email");
		  
			  password2[i]=json_data.getString("pass");
			  Log.e("log_tag", "LOOP email: "+email2[i].toString()+" Pass : "+password2[i].toString());
			  if(email2[i].equals(email)&&password2[i].equals(password))
			  {
				  Log.e("log_tag", "LOOP VALID USER");
				  reader.close();
				 
				  
		
				  return true;
			  }
			  
		  }
		  reader.close();
		  
		
		  //tv.setText(result);
		  } catch (Exception e) {
			  
		  Log.e("log_tag", "LOGON Error converting result" + e.toString());
		  				 
		  }	 
		
		
		return false;
	}

}
