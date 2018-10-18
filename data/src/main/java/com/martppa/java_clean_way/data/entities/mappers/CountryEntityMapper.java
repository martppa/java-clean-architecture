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
package com.martppa.java_clean_way.data.entities.mappers;

import com.martppa.java_clean_way.core.models.Country;
import com.martppa.java_clean_way.data.entities.CountryEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

public class CountryEntityMapper {

    @Inject
    public CountryEntityMapper() {}

    /**
     * Turns a {@link CountryEntity} from the data layer into a {@link Country} model in
     * Domain layer.
     *
     * @param countryEntity {@link CountryEntity} to be transformed
     * @return Transformed {@link Country}
     */
    public Country transform(CountryEntity countryEntity) {
        return new Country(countryEntity.getName(), countryEntity.getIsoCode(), countryEntity.getFlagImageUrl());
    }

    /**
     * Turns a {@link Collection} of {@link CountryEntity} into a {@link List} of {@link Country} model in
     * Domain layer.
     *
     * @param countryEntities {@link Collection} of {@link CountryEntity} to be transformed
     * @return Transformed {@link List} of {@link Country}
     */
    public List<Country> transform(Collection<CountryEntity> countryEntities) {
        List<Country> countries = new ArrayList<>();
        for (CountryEntity countryEntity : countryEntities) {
            countries.add(transform(countryEntity));
        }
        return countries;
    }
}
