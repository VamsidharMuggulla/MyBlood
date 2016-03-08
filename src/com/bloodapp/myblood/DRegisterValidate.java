package com.bloodapp.myblood;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class DRegisterValidate 
{
    String alert="";
   
   /* 	
	    if(alert.equals(null))
		{
        	return true;
		}
        else
        {
          	
        	
        }
		return false;
	}
	*/
	public String validateAddress(String address ,EditText ETaddress)
	{
		if(address.isEmpty()||address.length()<10)
		{
			ETaddress.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Address\n";
			return alert;
		}
		ETaddress.setTextColor(Color.parseColor("#000000"));
		return alert;
	}
	public String validateLocation(String location ,EditText ETlocation)
	{
		if(location.isEmpty()||location.length()<5)
		{
			ETlocation.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Location\n";
			return alert;
		}
		ETlocation.setTextColor(Color.parseColor("#000000"));
		return alert;
	}
	/*public String validatePin(String pin,EditText ETpin)
	{

		Pattern pattern = Pattern.compile("[0-9]{6}");
		Matcher matcher=pattern.matcher(pin);
	
		if(!(matcher.matches())||pin.isEmpty())
		{
			ETpin.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Pincode\n";
			return alert;
		}
		ETpin.setTextColor(Color.parseColor("#000000"));
		return alert;
	}*/
	public String validateldd(String ldd,EditText ETldd)
	{
		if(ldd.isEmpty())
		{
			ETldd.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"No.of weeks before you donated blood\n";
			return alert;
		}
		ETldd.setTextColor(Color.parseColor("#000000"));
		return alert;
	}
	
}