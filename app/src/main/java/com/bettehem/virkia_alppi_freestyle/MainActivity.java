package com.bettehem.virkia_alppi_freestyle;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.net.*;

public class MainActivity extends Activity implements View.OnClickListener
{
	Button etusivu, ryhma, tapahtuma, linkit, freestyle, yhteistyo;
	ImageButton virkia, simpsio;
	Intent avaaEtusivu, avaaRyhma, avaaTapahtuma, avaaLinkit, avaaFreestyle, avaaYhteistyo, avaaYhteystiedot, avaaTiedot;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);	
        setContentView(R.layout.main);
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
        napit();
        intentit();
	}
	
	@Override
	public void onClick(View v)
	{
		switch (v.getId()){
			case R.id.etusivuNappi:
				startActivity(avaaEtusivu);
				break;
			case R.id.ryhmaNappi:
				startActivity(avaaRyhma);
				break;
			case R.id.tapahtumaNappi:
				startActivity(avaaTapahtuma);
				break;
			case R.id.linkitNappi:
				startActivity(avaaLinkit);
				break;
			case R.id.freestyleNappi:
				startActivity(avaaFreestyle);
				break;
			case R.id.virkiaNappi:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lapuanvirkia.fi")));
				break;
			case R.id.simpsioNappi:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.simpsio.com")));
				break;
			case R.id.yhteistyoNappi:
				startActivity(avaaYhteistyo);
				break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)//This is the setup for the menu
	{
		super.onCreateOptionsMenu(menu);
		MenuInflater inflaatteri = getMenuInflater();
		inflaatteri.inflate(R.menu.valikko, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()){

			case R.id.yhteystiedot:
				startActivity(avaaYhteystiedot);
				break;

			case R.id.tietoja:
				startActivity(avaaTiedot);
				break;

		}

		return false;
	}

    public void napit(){
        etusivu = (Button) findViewById(R.id.etusivuNappi);
        ryhma = (Button) findViewById(R.id.ryhmaNappi);
        tapahtuma = (Button) findViewById(R.id.tapahtumaNappi);
        linkit = (Button) findViewById(R.id.linkitNappi);
        freestyle = (Button) findViewById(R.id.freestyleNappi);
        virkia = (ImageButton) findViewById(R.id.virkiaNappi);
        simpsio = (ImageButton) findViewById(R.id.simpsioNappi);
        yhteistyo = (Button) findViewById(R.id.yhteistyoNappi);

        etusivu.setOnClickListener(this);
        ryhma.setOnClickListener(this);
        tapahtuma.setOnClickListener(this);
        linkit.setOnClickListener(this);
        freestyle.setOnClickListener(this);
        virkia.setOnClickListener(this);
        simpsio.setOnClickListener(this);
        yhteistyo.setOnClickListener(this);
    }

    public void intentit(){
        avaaEtusivu = new Intent(getPackageName() + "." + "ETUSIVU");
        avaaRyhma = new Intent(getPackageName() + "." + "RYHMA");
        avaaTapahtuma = new Intent(getPackageName() + "." + "TAPAHTUMA");
        avaaLinkit = new Intent(getPackageName() + "." + "LINKIT");
        avaaFreestyle = new Intent(getPackageName() + "." + "FREESTYLE");
        avaaYhteistyo = new Intent(getPackageName() + "." + "YHTEISTYO");
        avaaYhteystiedot = new Intent(getPackageName() + "." + "YHTEYSTIEDOT");
        avaaTiedot = new Intent(getPackageName() + "." + "TIEDOT");
    }
}
