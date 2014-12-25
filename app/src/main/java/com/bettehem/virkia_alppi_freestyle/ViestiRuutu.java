package com.bettehem.virkia_alppi_freestyle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chris on 24.12.2014.
 */
public class ViestiRuutu extends Activity implements View.OnClickListener{

    Button laheta;
    EditText viesti;
    TextView kohde;
    String kohdeTeksti, viestiNro, viestiTeksti, kohdeNumero, kirjoitettuTeksti, ilmoitusString;
    CharSequence ilmoitusTeksti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viestiruutu);

        //View view = findViewById(R.id.tausta);
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			//view.setBackgroundResource(R.drawable.tausta_vaaka);
			getWindow().setBackgroundDrawableResource(R.drawable.tausta_vaaka);
		}else{
			//view.setBackgroundResource(R.drawable.tausta_pysty);
			getWindow().setBackgroundDrawableResource(R.drawable.tausta_pysty);
		}

        muuttujat();

    }

    public void muuttujat(){
        viestiKohde();
        viestiNumero();
        viestiTeksti = kohdeTeksti;
        viestiNro = kohdeNumero;

        laheta = (Button) findViewById(R.id.viestiLahetysNappi);
        viesti = (EditText) findViewById(R.id.tekstiruutu);
        kohde = (TextView) findViewById(R.id.viestiKohde);

        laheta.setOnClickListener(this);

        kohde.setText(kohdeTeksti);

    }

    @Override
    public void onClick(View v) {

        kirjoitettuTeksti = viesti.getText().toString();

        switch (v.getId()){
            case R.id.viestiLahetysNappi:
                if (kirjoitettuTeksti.contentEquals("")){
                    tyhjaviesti();
                }else{
                    viesti();
                    viestiLahetetty();
					finish();
                }
                break;
        }
    }

    public void viesti(){
        SmsManager viestiManageri =     SmsManager.getDefault();
        viestiManageri.sendTextMessage(viestiNro, null, kirjoitettuTeksti, null, null);
    }

    public void viestiKohde(){
        Intent intent = getIntent();
        kohdeTeksti = intent.getExtras().getString("nimi");
    }

    public void viestiNumero(){
        Intent intent = getIntent();
        kohdeNumero = intent.getExtras().getString("kohdenumero");
    }

    public void tyhjaviesti(){
        ilmoitusString = getString(R.string.tyhja_viesti);
        ilmoitusTeksti = ilmoitusString;
        Toast.makeText(getApplicationContext(), ilmoitusTeksti, Toast.LENGTH_LONG).show();
    }

    public void viestiLahetetty(){
        ilmoitusString = getString(R.string.viesti_lahetetty);
        ilmoitusTeksti = ilmoitusString;
        Toast.makeText(getApplicationContext(), ilmoitusTeksti, Toast.LENGTH_LONG).show();
    }

}
