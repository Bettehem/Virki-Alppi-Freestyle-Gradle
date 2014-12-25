package com.bettehem.virkia_alppi_freestyle;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.widget.*;
import android.content.*;
import android.net.*;

public class Freestyle extends Activity implements View.OnClickListener
{
	Button lisatietoNappi, skiPassiNappi, hissilippuNappi;

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
		lisatietoNappi = (Button) findViewById(R.id.freestyleLisatietoNappi);
        skiPassiNappi = (Button) findViewById(R.id.freestyleSkiPassiNappi);
        hissilippuNappi = (Button) findViewById(R.id.freestyleHissilippuNappi);
		
		lisatietoNappi.setOnClickListener(this);
        skiPassiNappi.setOnClickListener(this);
        hissilippuNappi.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View p1)
	{
		switch (p1.getId()){
			case R.id.freestyleLisatietoNappi:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.simpsio.com/default.aspx?pageid=142")));
				break;
            case R.id.freestyleSkiPassiNappi:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.skisport.fi/urheilijoille/lisenssit_ja_skipassit/skipassi-2014-2015/")));
                break;
            case R.id.freestyleHissilippuNappi:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://simpsio.com/default.aspx?pageid=138")));
                break;
		}
	}
}
