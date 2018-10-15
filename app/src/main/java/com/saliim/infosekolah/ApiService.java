package com.saliim.infosekolah;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by saliim on 10/8/18.
 */

public interface ApiService {
    @GET("getLokasi")
    Call<ResponseLokasi> tampilLokasi();

}
