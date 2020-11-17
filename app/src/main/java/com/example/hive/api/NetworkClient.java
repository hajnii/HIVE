package com.example.hive.api;

import android.content.Context;

import com.example.hive.Util.Utils;

import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    public static Retrofit retrofit;

    public static Retrofit getRetrofitClient(Context context) {
        if(retrofit == null){
            OkHttpClient httpClient = new OkHttpClient.Builder().build();
            retrofit = new Retrofit.Builder().baseUrl(Utils.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
