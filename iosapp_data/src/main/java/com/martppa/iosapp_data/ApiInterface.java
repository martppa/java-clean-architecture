package com.martppa.iosapp_data;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET
    Call<String> executeGet( @Url String url, @QueryMap Map<String, String> params);
}
