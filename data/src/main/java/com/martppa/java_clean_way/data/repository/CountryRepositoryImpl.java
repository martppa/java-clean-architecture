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
package com.martppa.java_clean_way.data.repository;

import com.martppa.java_clean_way.core.repository.CountryRepository;
import com.martppa.java_clean_way.data.entities.mappers.CountryEntityMapper;
import com.martppa.java_clean_way.data.repository.datasource.factory.CountryDataSourceSimpleFactory;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Domain layer repository implementation. By implementing the interface
 * Core module has access to the data provided by data layer.
 */
public class CountryRepositoryImpl implements CountryRepository {
    private CountryEntityMapper countryEntityMapper;
    private CountryDataSourceSimpleFactory countryDataSourceSimpleFactory;

    @Inject
    public CountryRepositoryImpl(CountryEntityMapper countryEntityMapper,
                                 CountryDataSourceSimpleFactory countryDataSourceSimpleFactory) {
        this.countryEntityMapper = countryEntityMapper;
        this.countryDataSourceSimpleFactory = countryDataSourceSimpleFactory;
    }

    @Override
    public Observable getCountries() {
        return countryDataSourceSimpleFactory
                .build().getCountries().map(countryEntityMapper::transform);
    }
}
