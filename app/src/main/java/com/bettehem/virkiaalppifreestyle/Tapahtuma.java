package com.bettehem.virkiaalppifreestyle;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.widget.*;
import android.content.*;
import android.net.*;

public class Tapahtuma extends Activity implements View.OnClickListener
{
	Button tulokset1, tulokset2, tulos1, tulos2, tulos3, tulos4, tulos5, tulos6, tulos7, tulos8;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tapahtuma);
		muuttujat();
		
		View view = findViewById(R.id.tausta);
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			view.setBackgroundResource(R.drawable.tausta_vaaka);
		}else{
			view.setBackgroundResource(R.drawable.tausta_pysty);
		}
	}
	
	public void muuttujat(){
		tulokset1 = (Button) findViewById(R.id.tapahtumaNappiTulokset1);
		tulokset2 = (Button) findViewById(R.id.tapahtumaNappiTulokset2);
		tulos1 = (Button) findViewById(R.id.tapahtumaNappiTulos1);
		tulos2 = (Button) findViewById(R.id.tapahtumaNappiTulos2);
		tulos3 = (Button) findViewById(R.id.tapahtumaNappiTulos3);
		tulos4 = (Button) findViewById(R.id.tapahtumaNappiTulos4);
		tulos5 = (Button) findViewById(R.id.tapahtumaNappiTulos5);
		tulos6 = (Button) findViewById(R.id.tapahtumaNappiTulos6);
		tulos7 = (Button) findViewById(R.id.tapahtumaNappiTulos7);
		tulos8 = (Button) findViewById(R.id.tapahtumaNappiTulos8);
		
		tulokset1.setOnClickListener(this);
		tulokset2.setOnClickListener(this);
		tulos1.setOnClickListener(this);
		tulos2.setOnClickListener(this);
		tulos3.setOnClickListener(this);
		tulos4.setOnClickListener(this);
		tulos5.setOnClickListener(this);
		tulos6.setOnClickListener(this);
		tulos7.setOnClickListener(this);
		tulos8.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View v)
	{
		switch (v.getId()){
			case R.id.tapahtumaNappiTulokset1:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B5PqjnV6bUH3VkFQY0gzSjFTU1dLVzhqcXNHY2xuNjlZV1lZ/edit")));
				break;
			case R.id.tapahtumaNappiTulokset2:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheet/ccc?key=0At8uwktDT5qqdF9sWk9vOGRmaWtqakZPZmo3RGFOelE")));
				break;
			case R.id.tapahtumaNappiTulos1:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B4-lm-HQoMZeWXdaWWNJLURaZFE/edit")));
				break;
			case R.id.tapahtumaNappiTulos2:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B4-lm-HQoMZeZWhLUEYtVFJETzg/edit")));
				break;
			case R.id.tapahtumaNappiTulos3:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B4-lm-HQoMZeSGxTUEd6bXZ1XzQ/edit")));
				break;
			case R.id.tapahtumaNappiTulos4:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B4-lm-HQoMZeWHBmZHZTVFVOY28/edit")));
				break;
			case R.id.tapahtumaNappiTulos5:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B4-lm-HQoMZeT2Rkc3VSQmpRdG8/edit")));
				break;
			case R.id.tapahtumaNappiTulos6:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B4-lm-HQoMZeWHhyeDN4V3FESFU/edit")));
				break;
			case R.id.tapahtumaNappiTulos7:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B4-lm-HQoMZeX2MyRUlHR3ZDYWs/edit")));
				break;
			case R.id.tapahtumaNappiTulos8:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/file/d/0B4-lm-HQoMZeaW1STGVKSzhoUkU/edit")));
				break;
		}
	}
}
