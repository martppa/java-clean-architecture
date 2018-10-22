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
package com.martppa.java_clean_way.data.repository.datasource.factory;

import com.martppa.java_clean_way.data.repository.datasource.cache.CountryCacheDataSource;
import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;
import com.martppa.java_clean_way.data.repository.datasource.network.CountryNetworkDataSource;

import javax.inject.Inject;

public class CountryDataSourceSimpleFactory {
    private CountryNetworkDataSource countryNetworkDataSource;
    private CountryCacheDataSource countryCacheDataSource;

    @Inject
    public CountryDataSourceSimpleFactory(CountryNetworkDataSource countryNetworkDataSource,
                                          CountryCacheDataSource countryCacheDataSource) {
        this.countryNetworkDataSource = countryNetworkDataSource;
        this.countryCacheDataSource = countryCacheDataSource;
    }

    public CountryDataSource build() {
        if (countryCacheDataSource.isExpired())
            return countryNetworkDataSource;
        else
            return countryCacheDataSource;
    }
}
