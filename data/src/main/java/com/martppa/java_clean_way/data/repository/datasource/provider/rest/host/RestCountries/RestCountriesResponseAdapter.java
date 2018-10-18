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
package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.RestCountries;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Turns <a href="https://restcountries.eu">RestCountries</a> responses into a common response type
 * handled by {@link com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestApiImpl}
 */
public class RestCountriesResponseAdapter implements ResponseAdapter<Collection<CountryEntity>> {

    private ResponseAdapter.ResponseStatus responseStatus;
    private String errorMessage;
    private Collection<RestCountriesCountryModel> response;

    public RestCountriesResponseAdapter(Collection<RestCountriesCountryModel> response) {
        this.response = response;
        this.responseStatus = ResponseStatus.OK;
    }

    public RestCountriesResponseAdapter(ResponseStatus responseStatus, String errorMessage) {
        this.responseStatus = responseStatus;
        this.errorMessage = errorMessage;
    }

    public ResponseAdapter.ResponseStatus getStatus() {
        return responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public Collection<CountryEntity> getContent() {
        return new ArrayList<>(response);
    }
}
