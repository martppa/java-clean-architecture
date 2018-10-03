package com.martppa.iosapp_data;

import com.google.gson.Gson;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;

import java.io.IOException;
import java.util.Map;

import retrofit2.Retrofit;

public class RetrofitRestFramework implements RestFramework {
    private ApiInterface apiInterface;

    public RetrofitRestFramework() {
        apiInterface = new Retrofit.Builder()
                .build().create(ApiInterface.class);
    }

    @Override
    public <T> T executeGet(Class<T> responseType, String baseUrl, String route, Map<String, String> parameters) throws IOException {
        String response = apiInterface.executeGet(baseUrl + route, parameters).execute().body();
        return new Gson().fromJson(response, responseType);
    }
}
