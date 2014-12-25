package com.bettehem.virkia_alppi_freestyle;
import android.app.*;
import android.content.Intent;
import android.content.res.*;
import android.net.Uri;
import android.os.*;
import android.view.*;
import android.widget.Button;

public class Etusivu extends Activity implements View.OnClickListener
{

    Button lomake;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.etusivu);
		
		
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
        lomake = (Button) findViewById(R.id.ajankohtaistaNappi);

        lomake.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ajankohtaistaNappi:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.virkia-alppi.net/ilmottautumiskaavake.doc")));
                break;
        }
    }
}
