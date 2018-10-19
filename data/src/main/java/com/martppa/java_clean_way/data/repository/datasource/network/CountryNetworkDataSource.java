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
package com.martppa.java_clean_way.data.repository.datasource.network;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.cache.Country.CountryCache;
import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;
import com.martppa.java_clean_way.data.repository.datasource.provider.CountryProvider;

import java.util.Collection;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CountryNetworkDataSource implements CountryDataSource {
    private CountryProvider countryProvider;
    private CountryCache cache;

    @Inject
    public CountryNetworkDataSource(CountryProvider countryProvider, CountryCache cache) {
        this.countryProvider = countryProvider;
        this.cache = cache;
    }

    @Override
    public Observable<Collection<CountryEntity>> getCountries() {
        return countryProvider.getCountries().doOnNext(countryEntityCollection -> {
            CountryEntity[] countryEntities = new CountryEntity[0];
            countryEntities = countryEntityCollection.toArray(countryEntities);
            cache.save(countryEntities);
        });
    }
}
