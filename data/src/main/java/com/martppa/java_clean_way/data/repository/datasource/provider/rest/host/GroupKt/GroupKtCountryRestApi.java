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
package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.GroupKt;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestApiImpl;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;

/**
 * <a href="http://www.groupkt.com">GroupKt</a> flavour api
 * implementation.
 */
public class GroupKtCountryRestApi extends CountryRestApiImpl {
    private final String BASE_URL = "http://services.groupkt.com/";
    private final String COUNTRY_ROUTE = "country/get/all";

    @Inject
    public GroupKtCountryRestApi(RestFramework restFramework) {
        super(restFramework);
    }

    @Override
    protected ResponseAdapter<Collection<CountryEntity>> requestCountries() {
        try {
            GroupKtRestResponse response = restFramework
                    .executeGet(GroupKtRestResponse.class, BASE_URL, COUNTRY_ROUTE, noParameters());
            return new GroupKtResponseAdapter(response);
        } catch (IOException e) {
            return new GroupKtResponseAdapter(ResponseAdapter.ResponseStatus.ERROR, e.getMessage());
        }
    }
}
