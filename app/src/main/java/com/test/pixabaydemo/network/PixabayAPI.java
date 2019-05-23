package com.test.pixabaydemo.network;

import com.test.pixabaydemo.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PixabayAPI {

    public static final String key = BuildConfig.PIXABAY_KEY;
    public static final String url = "https://pixabay.com/api/";
    private static String TAG = PixabayAPI.class.getSimpleName();

    public static PixabayService pixabayService = null;


    public static PixabayService getPixabayService() {

        if (pixabayService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            pixabayService = retrofit.create(PixabayService.class);
        }
        return pixabayService;
    }



}
