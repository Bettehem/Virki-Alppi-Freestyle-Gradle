package com.bettehem.virkiaalppifreestyle;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;

public class Yhteystiedot extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yhteystiedot);

		View view = findViewById(R.id.tausta);
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			view.setBackgroundResource(R.drawable.tausta_vaaka);
		}else{
			view.setBackgroundResource(R.drawable.tausta_pysty);
		}
	}
}
