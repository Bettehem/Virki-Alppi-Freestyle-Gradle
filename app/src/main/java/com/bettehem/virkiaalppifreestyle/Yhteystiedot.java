package com.bettehem.virkiaalppifreestyle;

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.widget.Button;

public class Yhteystiedot extends Activity implements View.OnClickListener
{
    Button kaleviPuhelu, kaleviViesti, kaleviSposti, ariPuhelu, ariViesti, ariSposti;
    Intent emailIntent;
    String yhteystieto, aihe, spViesti, numero, viestiNimiTeksti;


    @Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yhteystiedot);

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
        kaleviPuhelu = (Button) findViewById(R.id.kaleviPuhelu);
        kaleviViesti = (Button) findViewById(R.id.kaleviViesti);
        kaleviSposti = (Button) findViewById(R.id.kaleviSposti);

        kaleviPuhelu.setOnClickListener(this);
        kaleviViesti.setOnClickListener(this);
        kaleviSposti.setOnClickListener(this);

        ariPuhelu = (Button) findViewById(R.id.ariPuhelu);
        ariViesti = (Button) findViewById(R.id.ariViesti);
        ariSposti = (Button) findViewById(R.id.ariSposti);

        ariPuhelu.setOnClickListener(this);
        ariViesti.setOnClickListener(this);
        ariSposti.setOnClickListener(this);

        aihe = getString(R.string.app_name);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.kaleviPuhelu:
                numero = getString(R.string.kalevi_puh);
                soitto();
                break;
            case R.id.kaleviViesti:

                break;

            case R.id.kaleviSposti:
                yhteystieto = getString(R.string.kalevi_sposti);
                emailmessage();
                break;

            case R.id.ariPuhelu:
                numero = getString(R.string.ari_puh);
                soitto();
                break;
            case R.id.ariViesti:
                viestiNimiTeksti = getString(R.string.viesti_teksti_ari);
                numero = getString(R.string.ari_viesti);
                viestinLahetys();
                break;

            case R.id.ariSposti:
                yhteystieto = getString(R.string.ari_sposti);
                emailmessage();
                break;
        }
    }

    public void sending(){

        String emailaddress[] = {yhteystieto};
        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, aihe);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, spViesti);
        startActivity(emailIntent);
        finish();
    }

    public void emailmessage(){
        spViesti = "";
        sending();
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

}
