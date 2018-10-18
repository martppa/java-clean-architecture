/*
 * Copyright 2018 Humberto Martín Dieppa, Open source project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.martppa.java_clean_way.android_data.remote;

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

/**
 * Implementation of {@link RestFramework} in data module (data layer). This implementation
 * handles Rest requests using <a href="http://projects.spring.io/spring-android/" >Spring RestTemplate<a/> framework.
 */
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
