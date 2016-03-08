package com.bloodapp.myblood;


import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class SearchActivity extends Activity {

	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy);
		
		
		Intent it=getIntent();
		ListView list1,list2;
		ImageButton ib=(ImageButton)findViewById(R.id.back);
		ib.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				finish();
			}
		});
		
		
		
		int x=Integer.parseInt(it.getStringExtra("noOfPeople"));
		String[] nameBgrLoc=new String[x];
		  //String[] bgr=new String[x];
		  //String[] location=new String[x];
		  String[] phone=new String[x];
		for(int i=0;i<x;i++)
		{
			nameBgrLoc[i]=it.getStringExtra("name"+i)+"    "+it.getStringExtra("bgroup"+i)+"    " +
					""+it.getStringExtra("location"+i)+"	"+it.getStringExtra("phone"+i);
			
			phone[i]=it.getStringExtra("phone"+i);
			Log.e("SEARCHACTIVITYLOG","Hello");
			//Log.e("name "+i,name[i]);
		//	Log.e("bggroup "+i,bgr[i]);
			//Log.e("location "+i,location[i]);
			Log.e("phone "+i,phone[i]);
		}
		
		
		
		//grid=(GridView)findViewById(R.id.gridView1);
		list1=(ListView)findViewById(R.id.listview2);
		//list2=(ListView)findViewById(R.id.listview2);
		ArrayAdapter arr=new ArrayAdapter<String>(this,R.layout.listview_adapter,nameBgrLoc); 
		list1.setAdapter(arr);
		
	//	ArrayAdapter arr2=new ArrayAdapter<String>(this,R.layout.listview_adapter,phone); 
		//list2.setAdapter(arr2);
		
		
		list1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int arg2,long arg3) {
				// TODO Auto-generated method stub
				String x=((TextView)v).getText().toString();
				StringBuilder y=new StringBuilder();
				//int j=0;
				Log.e("1",x.length()+"");
				
				for(int i=x.length()-1;i>=x.length()-10;i--)
				{
					Log.e("Loop",i+"  "+x.charAt(i));
					y.append(x.charAt(i));
				
				}
				y.reverse();
				
				
				
				Log.e("CALLING",y.toString());
				
				Intent it=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+y));
			
				startActivity(it);
			}
			
			
		});
		//String[] adapter={"vam","nav","ppp","kkk"}; //ctrl+space nokku naku avvatle
		
	}

}
