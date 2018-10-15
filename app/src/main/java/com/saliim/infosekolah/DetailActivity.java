package com.saliim.infosekolah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.saliim.infosekolah.R;

public class DetailActivity extends AppCompatActivity {
    TextView dNama, dLat, dLon;

    String dNama1, dLat1, dLon1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dNama = findViewById(R.id.detail_nama);
        dLat = findViewById(R.id.detail_latitude);
        dLon = findViewById(R.id.detail_longitude);

        Intent ambil = getIntent();

        dNama1 = ambil.getStringExtra("nama");
        dLat1 = ambil.getStringExtra("lat");
        dLon1 = ambil.getStringExtra("lon");

        dNama.setText(dNama1);
        dLat.setText("Latitude    : "+dLat1);
        dLon.setText("Longitude : "+dLon1);
    }
}
