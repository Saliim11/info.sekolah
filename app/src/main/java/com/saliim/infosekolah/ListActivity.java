package com.saliim.infosekolah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    RecyclerView list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list2 = (RecyclerView) findViewById(R.id.list);
        getData1();
        list2.setLayoutManager(new LinearLayoutManager(this));


    }

    private void getData1() {
        ApiService apiService = ConfigRetrofit.apiService;

        retrofit2.Call<ResponseLokasi> call = apiService.tampilLokasi();

        call.enqueue(new Callback<ResponseLokasi>() {
            @Override
            public void onResponse(Call<ResponseLokasi> call, Response<ResponseLokasi> response) {
                Toast.makeText(ListActivity.this, "data berhasil", Toast.LENGTH_SHORT).show();
                Log.d("Response", "Success" + response.body().toString());

                int code = response.body().getCode();

                if (code == 1){
                    List<DataLokasiItem> dataLokasiItems = response.body().getDataLokasi();

                    Log.d("Data Lokasi", dataLokasiItems.toString());

                    ListAdapter adapter = new ListAdapter(ListActivity.this, dataLokasiItems);

                    list2.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseLokasi> call, Throwable t) {

            }
        });
    }
}
