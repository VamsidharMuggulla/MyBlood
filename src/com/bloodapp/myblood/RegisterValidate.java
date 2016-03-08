package com.bloodapp.myblood;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterValidate 
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
	public String validateName(Context context,String fname,EditText ETfname)
	{
		if(fname.isEmpty()||fname.length()<5)
		{
			ETfname.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Full Name More than 5 char\n";
			return alert;
		}
		ETfname.setTextColor(Color.parseColor("#000000"));
		return alert;
	}
	public String validateEmail(Context context,String email, EditText ETemail)
	{
		Pattern pattern = Pattern.compile("[a-z]+[a-z0-9._]+\\@[a-z]+\\.[a-z]{3}");
		Matcher matcher=pattern.matcher(email);
		
		if(!(matcher.matches())||email.isEmpty()||email.length()<11)
		{
			ETemail.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Incorrect Email format\n";
			return alert;
		}
		ETemail.setTextColor(Color.parseColor("#000000"));
		return alert;
	}
	public String validatePassword(Context context,String pass, EditText ETpass)
	{
		Pattern pattern = Pattern.compile("[A-Za-z0-9]{6}[a-z0-9]+");
		Matcher matcher=pattern.matcher(pass);
	
	if(!(matcher.matches())||pass.isEmpty()||pass.length()<5)
		{
			ETpass.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Password must be more than 6 chars \n Enter without Symbols\n";
			return alert;
		}
		ETpass.setTextColor(Color.parseColor("#000000"));
		return alert;
	}

	public String validatePhone(Context context,String phone,EditText ETphone)
	{

		Pattern pattern = Pattern.compile("[7-9]{1}[0-9]{9}");
		Matcher matcher=pattern.matcher(phone);
	
		if(!(matcher.matches())||phone.isEmpty()||phone.length()!=10)
		{
			ETphone.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Phone\n";
			return alert;
		}
		ETphone.setTextColor(Color.parseColor("#000000"));
		return alert;
	}
	public String validatedob(Context context,String fdob,EditText ETdob)
	{
		if(fdob.isEmpty()||fdob.length()<2)
		{
			ETdob.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"AGE\n";
			return alert;
		}
		ETdob.setTextColor(Color.parseColor("#000000"));
		return alert;
	}
	
}