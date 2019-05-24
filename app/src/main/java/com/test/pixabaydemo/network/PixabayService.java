package com.test.pixabaydemo.network;

import com.test.pixabaydemo.model.Images;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayService {
    @GET("?")
    Call<Images> getImages(@Query("key") String apiKey, @Query("q") String searchQuery, @Query("per_page") int perPages);
}