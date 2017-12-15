package com.pa1.servicesnearby;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etLocation;
    Button btnFind;
    Spinner spnServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLocation = findViewById(R.id.etLoaction);
        btnFind = findViewById(R.id.btnFind);
        spnServ= findViewById(R.id.spnServ);

        ArrayAdapter<CharSequence> arr= ArrayAdapter.createFromResource(getApplicationContext(),R.array.services,android.R.layout.simple_spinner_item);
        spnServ.setAdapter(arr);

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(etLocation.getText().toString() == "")){
                    String loc = etLocation.getText().toString();
                    String serv = spnServ.getSelectedItem().toString().trim();
                    String result = serv+", "+ loc;
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q="+result);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);


                }
            }
        });

    }
}
