package com.bettehem.virkiaalppifreestyle;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.widget.*;
import android.content.*;
import android.net.*;

public class Linkit extends Activity implements View.OnClickListener
{
	Button virkia, simpsio, joupiska, sjh, skisport, lss, simpsiopark;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linkit);
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
		virkia = (Button) findViewById(R.id.linkitNappiVirkia);
		simpsio = (Button) findViewById(R.id.linkitNappiSimpsio);
		joupiska = (Button) findViewById(R.id.linkitNappiJoupiska);
		sjh = (Button) findViewById(R.id.linkitNappiSJH);
		skisport = (Button) findViewById(R.id.linkitNappiSkisport);
		lss = (Button) findViewById(R.id.linkitNappiLsSCrew);
		simpsiopark = (Button) findViewById(R.id.linkitNappiSimpsioPark);
		
		virkia.setOnClickListener(this);
		simpsio.setOnClickListener(this);
		joupiska.setOnClickListener(this);
		sjh.setOnClickListener(this);
		skisport.setOnClickListener(this);
		lss.setOnClickListener(this);
		simpsiopark.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View p1)
	{
		switch (p1.getId()){
			case R.id.linkitNappiVirkia:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lapuanvirkia.fi")));
				break;
			case R.id.linkitNappiSimpsio:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.simpsio.com")));
				break;
			case R.id.linkitNappiJoupiska:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.joupiska.fi")));
				break;
			case R.id.linkitNappiSJH:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.seinajoenhiihtoseura.fi")));
				break;
			case R.id.linkitNappiSkisport:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.skisport.fi")));
				break;
			case R.id.linkitNappiLsSCrew:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC8A0XqOOBVCKEnEa7ual1_A")));
				break;
			case R.id.linkitNappiSimpsioPark:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/simpsiopark")));
				break;
		}
	}
}
