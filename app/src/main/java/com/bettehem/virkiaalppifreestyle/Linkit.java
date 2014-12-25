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
	Button virkia, simpsio, joupiska, sjh, skisport, lsc, simpsiopark, insta, fb, twitter;
	
	
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
		lsc = (Button) findViewById(R.id.linkitNappiLSCrew);
		simpsiopark = (Button) findViewById(R.id.linkitNappiSimpsioPark);
        insta = (Button) findViewById(R.id.linkitNappiInsta);
        fb = (Button) findViewById(R.id.linkitNappiFB);
        twitter = (Button) findViewById(R.id.linkitNappiTwitter);
		
		virkia.setOnClickListener(this);
		simpsio.setOnClickListener(this);
		joupiska.setOnClickListener(this);
		sjh.setOnClickListener(this);
		skisport.setOnClickListener(this);
		lsc.setOnClickListener(this);
		simpsiopark.setOnClickListener(this);
        insta.setOnClickListener(this);
        fb.setOnClickListener(this);
        twitter.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View p1)
	{
		switch (p1.getId()){
            case R.id.linkitNappiInsta:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/virkiafreestyle")));
                break;
            case R.id.linkitNappiFB:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100008479963397")));
                break;
            case R.id.linkitNappiTwitter:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/virkiafreestyle")));
                break;
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
			case R.id.linkitNappiLSCrew:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC8A0XqOOBVCKEnEa7ual1_A")));
				break;
			case R.id.linkitNappiSimpsioPark:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/simpsiopark")));
				break;
		}
	}
}
