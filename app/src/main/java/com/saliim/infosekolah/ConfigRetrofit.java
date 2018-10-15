package com.saliim.infosekolah;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saliim on 10/8/18.
 */

public class ConfigRetrofit {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://programmerkece.000webhostapp.com/index.php/Api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService apiService = retrofit.create(ApiService.class);
}
//TEST