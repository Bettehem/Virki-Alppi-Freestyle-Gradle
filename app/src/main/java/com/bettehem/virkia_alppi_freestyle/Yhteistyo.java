package com.bettehem.virkia_alppi_freestyle;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;

public class Yhteistyo extends Activity
{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yhteistyo);
		
		View view = findViewById(R.id.tausta);
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			view.setBackgroundResource(R.drawable.tausta_vaaka);
		}else{
			view.setBackgroundResource(R.drawable.tausta_pysty);
		}
	}
}
