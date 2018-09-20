package com.martppa.remote.resttemplate;

import com.martppa.data.repository.datasource.provider.rest.framework.RestFramework;

import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateFrameworkImpl implements RestFramework {
    private RestTemplate restTemplate;

    public RestTemplateFrameworkImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public <T> T executeGet(Class<T> responseType, String baseUrl, String route, Map<String, String> parameters) {
        return restTemplate.getForObject(baseUrl + route, responseType, parameters);
    }
}