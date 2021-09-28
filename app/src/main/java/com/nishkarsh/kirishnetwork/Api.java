package com.nishkarsh.kirishnetwork;

import com.nishkarsh.kirishnetwork.model.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://thekrishi.com/test/";

    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
     **/
    @GET("mandi?")
    Call<Root> getMandi(@Query("lat") String lat, @Query("lon") String lon,@Query("ver") String ver, @Query("lang") String lang, @Query("crop_id") String crop_id);

}
