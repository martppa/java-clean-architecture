package com.martppa.iosapp_data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestFramework implements RestFramework {

    @Inject public RetrofitRestFramework() {}

    @Override
    public <T> T executeGet(Class<T> responseType, String baseUrl, String route, Map<String, String> parameters) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getUnsafeOkHttpClient().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApiInterface retrofitApiInterface = retrofit.create(RetrofitApiInterface.class);
        JsonElement response = retrofitApiInterface.executeGet(route, parameters).execute().body();
        return new Gson().fromJson(response, responseType);
    }

    private OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {}

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {}

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
