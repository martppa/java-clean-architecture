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
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestApiImpl;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.inject.Inject;

/**
 * <a href="https://restcountries.eu">RestCountries</a> flavour
 * implementation
 */
public class RestCountriesCountryRestApi extends CountryRestApiImpl {
    private final String BASE_URL = "https://restcountries.eu/";
    private final String COUNTRY_ROUTE = "rest/v2/all";

    @Inject
    public RestCountriesCountryRestApi(RestFramework restFramework) {
        super(restFramework);
    }

    @Override
    protected ResponseAdapter<Collection<CountryEntity>> requestCountries() {
        try {
            RestCountriesCountryModel[] response = restFramework.executeGet(RestCountriesCountryModel[].class, BASE_URL, COUNTRY_ROUTE, noParameters());
            if (response == null)
                throw new IOException("No data from server");
            return new RestCountriesResponseAdapter(Arrays.asList(response));
        } catch (IOException ioex) {
            return new RestCountriesResponseAdapter(ResponseAdapter.ResponseStatus.ERROR, ioex.getLocalizedMessage());
        }
    }
}
