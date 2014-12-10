package com.bettehem.virkiaalppifreestyle;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.widget.*;
import android.content.*;
import android.net.*;

public class Freestyle extends Activity implements View.OnClickListener
{
	Button nappi1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.freestyle);
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
		nappi1 = (Button) findViewById(R.id.freestyleNappiLinkki1);
		
		nappi1.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View p1)
	{
		switch (p1.getId()){
			case R.id.freestyleNappiLinkki1:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.virkia-alppi.net/hakulomake.doc")));
				break;
		}
	}
}
