package com.martppa.iosapp_data;

import com.google.gson.JsonElement;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitApiInterface {
    @GET
    Call<JsonElement> executeGet(@Url String url, @QueryMap Map<String, String> params);
}
