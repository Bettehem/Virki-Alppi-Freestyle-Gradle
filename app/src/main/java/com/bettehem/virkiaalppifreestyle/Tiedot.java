package com.bettehem.virkiaalppifreestyle;
import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.widget.Button;

public class Tiedot extends Activity implements View.OnClickListener
{

    Button chrisPuhelu, chrisViesti, chrisSposti;
    Intent emailIntent;
    String yhteystieto, aihe, spViesti, numero, viestiNimiTeksti;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tiedot);
		
		View view = findViewById(R.id.tausta);
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			view.setBackgroundResource(R.drawable.tausta_vaaka);
		}else{
			view.setBackgroundResource(R.drawable.tausta_pysty);
		}

        muuttujat();
	}

    public void muuttujat(){

        chris();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chrisPuhelu:
                numero = getString(R.string.chris_puh);
                soitto();
                break;
            case R.id.chrisViesti:
                viestiNimiTeksti = getString(R.string.viesti_teksti_chris);
                numero = getString(R.string.ari_viesti);
                viestinLahetys();
                break;

            case R.id.chrisSposti:
                yhteystieto = getString(R.string.chris_sposti_dev);
                emailmessage();
                break;
        }
    }

    public void chris(){
        chrisPuhelu = (Button) findViewById(R.id.chrisPuhelu);
        chrisViesti = (Button) findViewById(R.id.chrisViesti);
        chrisSposti = (Button) findViewById(R.id.chrisSposti);

        chrisPuhelu.setOnClickListener(this);
        chrisViesti.setOnClickListener(this);
        chrisSposti.setOnClickListener(this);
    }

    public void soitto(){
        Intent dial = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numero));
        startActivity(dial);
    }

    public void viestinLahetys(){
        Intent lahetys = new Intent(getPackageName() + "." + "VIESTIRUUTU");
        lahetys.putExtra("nimi", viestiNimiTeksti);
        lahetys.putExtra("kohdenumero", numero);
        startActivity(lahetys);
    }

    public void emailmessage(){
        spViesti = "";
        sending();
    }

    public void sending(){

        aihe = getString(R.string.app_name);

        String emailaddress[] = {yhteystieto};
        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, aihe);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, spViesti);
        startActivity(emailIntent);
        finish();
    }
}
