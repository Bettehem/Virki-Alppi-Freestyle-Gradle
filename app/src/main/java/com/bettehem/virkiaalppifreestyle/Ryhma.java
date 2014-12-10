package com.bettehem.virkiaalppifreestyle;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.widget.*;
import android.content.*;
import android.net.*;

public class Ryhma extends Activity //implements View.OnClickListener
{
	//Button lisatietoja;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ryhma);
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
		//lisatietoja = (Button) findViewById(R.id.ryhmaLisatietoNappi);
		//lisatietoja.setOnClickListener(this);
	}
	
	
	/*@Override
	public void onClick(View v)
	{
		switch (v.getId()){
			case R.id.ryhmaLisatietoNappi:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.simpsio.com/default.aspx?pageid=142")));
				break;
		}
	}*/
}
