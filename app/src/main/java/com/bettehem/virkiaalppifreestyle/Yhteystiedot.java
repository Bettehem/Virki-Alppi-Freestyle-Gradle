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
    Button kaleviPuhelu, kaleviViesti, kaleviSposti, ariPuhelu, ariViesti, ariSposti, tuomoPuhelu, tuomoViesti, tuomoSposti, timoPuhelu, timoViesti, timoSposti, jarkkoPuhelu, jarkkoViesti, jarkkoSposti, chrisPuhelu, chrisViesti, chrisSposti, valtteriPuhelu, valtteriViesti, valtteriSposti;
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

        kalevi();
        ari();
        tuomo();
        timo();
        jarkko();
        chris();
        valtteri();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.kaleviPuhelu:
                numero = getString(R.string.kalevi_puh);
                soitto();
                break;
            case R.id.kaleviViesti:
				viestiNimiTeksti = getString(R.string.viesti_teksti_kalevi);
                numero = getString(R.string.kalevi_viesti);
                viestinLahetys();
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



            case R.id.tuomoPuhelu:
                numero = getString(R.string.tuomo_puh);
                soitto();
                break;
            case R.id.tuomoViesti:
                viestiNimiTeksti = getString(R.string.viesti_teksti_tuomo);
                numero = getString(R.string.tuomo_viesti);
                viestinLahetys();
                break;

            case R.id.tuomoSposti:
                yhteystieto = getString(R.string.tuomo_sposti);
                emailmessage();
                break;



            case R.id.timoPuhelu:
                numero = getString(R.string.timo_puh);
                soitto();
                break;
            case R.id.timoViesti:
                viestiNimiTeksti = getString(R.string.viesti_teksti_timo);
                numero = getString(R.string.timo_viesti);
                viestinLahetys();
                break;

            case R.id.timoSposti:
                yhteystieto = getString(R.string.timo_sposti);
                emailmessage();
                break;



            case R.id.jarkkoPuhelu:
                numero = getString(R.string.jarkko_puh);
                soitto();
                break;
            case R.id.jarkkoViesti:
                viestiNimiTeksti = getString(R.string.viesti_teksti_jarkko);
                numero = getString(R.string.jarkko_viesti);
                viestinLahetys();
                break;

            case R.id.jarkkoSposti:
                yhteystieto = getString(R.string.jarkko_sposti);
                emailmessage();
                break;



            case R.id.chrisPuhelu:
                numero = getString(R.string.chris_puh);
                soitto();
                break;
            case R.id.chrisViesti:
                viestiNimiTeksti = getString(R.string.viesti_teksti_chris);
                numero = getString(R.string.chris_viesti);
                viestinLahetys();
                break;

            case R.id.chrisSposti:
                yhteystieto = getString(R.string.chris_sposti);
                emailmessage();
                break;

            case R.id.valtteriPuhelu:
                numero = getString(R.string.valtteri_puh);
                soitto();
                break;
            case R.id.valtteriViesti:
                viestiNimiTeksti = getString(R.string.viesti_teksti_valtteri);
                numero = getString(R.string.valtteri_viesti);
                viestinLahetys();
                break;

            case R.id.valtteriSposti:
                yhteystieto = getString(R.string.ari_sposti);
                emailmessage();
                break;
        }
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

    public void kalevi(){
        kaleviPuhelu = (Button) findViewById(R.id.kaleviPuhelu);
        kaleviViesti = (Button) findViewById(R.id.kaleviViesti);
        kaleviSposti = (Button) findViewById(R.id.kaleviSposti);

        kaleviPuhelu.setOnClickListener(this);
        kaleviViesti.setOnClickListener(this);
        kaleviSposti.setOnClickListener(this);
    }

    public void ari(){
        ariPuhelu = (Button) findViewById(R.id.ariPuhelu);
        ariViesti = (Button) findViewById(R.id.ariViesti);
        ariSposti = (Button) findViewById(R.id.ariSposti);

        ariPuhelu.setOnClickListener(this);
        ariViesti.setOnClickListener(this);
        ariSposti.setOnClickListener(this);
    }

    public void tuomo(){
        tuomoPuhelu = (Button) findViewById(R.id.tuomoPuhelu);
        tuomoViesti = (Button) findViewById(R.id.tuomoViesti);
        tuomoSposti = (Button) findViewById(R.id.tuomoSposti);

        tuomoPuhelu.setOnClickListener(this);
        tuomoViesti.setOnClickListener(this);
        tuomoSposti.setOnClickListener(this);
    }

    public void timo(){
        timoPuhelu = (Button) findViewById(R.id.timoPuhelu);
        timoViesti = (Button) findViewById(R.id.timoViesti);
        timoSposti = (Button) findViewById(R.id.timoSposti);

        timoPuhelu.setOnClickListener(this);
        timoViesti.setOnClickListener(this);
        timoSposti.setOnClickListener(this);
    }

    public void jarkko(){
        jarkkoPuhelu = (Button) findViewById(R.id.jarkkoPuhelu);
        jarkkoViesti = (Button) findViewById(R.id.jarkkoViesti);
        jarkkoSposti = (Button) findViewById(R.id.jarkkoSposti);

        jarkkoPuhelu.setOnClickListener(this);
        jarkkoViesti.setOnClickListener(this);
        jarkkoSposti.setOnClickListener(this);
    }

    public void chris(){
        chrisPuhelu = (Button) findViewById(R.id.chrisPuhelu);
        chrisViesti = (Button) findViewById(R.id.chrisViesti);
        chrisSposti = (Button) findViewById(R.id.chrisSposti);

        chrisPuhelu.setOnClickListener(this);
        chrisViesti.setOnClickListener(this);
        chrisSposti.setOnClickListener(this);
    }

    public void valtteri(){
        valtteriPuhelu = (Button) findViewById(R.id.valtteriPuhelu);
        valtteriViesti = (Button) findViewById(R.id.valtteriViesti);
        valtteriSposti = (Button) findViewById(R.id.valtteriSposti);

        valtteriPuhelu.setOnClickListener(this);
        valtteriViesti.setOnClickListener(this);
        valtteriSposti.setOnClickListener(this);
    }

}
