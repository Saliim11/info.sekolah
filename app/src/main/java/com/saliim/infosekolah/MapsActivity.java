package com.saliim.infosekolah;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<DataLokasiItem> banyakYgSebanyakBanyaknyaLokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ambilLokasi();

        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
//        LatLng indonesia = new LatLng(-6.115723, 106.938684);
//        mMap.addMarker(new MarkerOptions().position(indonesia).title("Indonesia, Jakarta"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(indonesia));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(indonesia, 15));
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    private void ambilLokasi() {
        ApiService apiService = ConfigRetrofit.apiService;
        Call<ResponseLokasi>call = apiService.tampilLokasi();
        call.enqueue(new Callback<ResponseLokasi>() {
            @Override
            public void onResponse(Call<ResponseLokasi> call, Response<ResponseLokasi> response) {
                int code = response.body().getCode();
                if (code == 1){

                    banyakYgSebanyakBanyaknyaLokasi = (ArrayList<DataLokasiItem>) response.body().getDataLokasi();

                    for (int i = 0; i < banyakYgSebanyakBanyaknyaLokasi.size(); i++){
                        Double lat = Double.valueOf(banyakYgSebanyakBanyaknyaLokasi.get(i).getLatitude());
                        Double lon = Double.valueOf(banyakYgSebanyakBanyaknyaLokasi.get(i).getLongitude());

                        final LatLng lokasi = new LatLng(lat, lon);
                        mMap.addMarker(new MarkerOptions().position(lokasi).title(banyakYgSebanyakBanyaknyaLokasi.get(i).getNamelocation()));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(lokasi));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 15));
                        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLokasi> call, Throwable t) {

            }
        });
    }
}
