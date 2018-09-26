package com.martppa.java_clean_way.android_data;

import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class RestTemplateFramework implements RestFramework {
    private RestTemplate restTemplate;

    @Inject
    public RestTemplateFramework() {
        restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
    }

    @Override
    public <T> T executeGet(Class<T> responseType, String baseUrl, String route, Map<String, String> parameters) {
        return restTemplate.getForObject(baseUrl + route, responseType, parameters);
    }
}
