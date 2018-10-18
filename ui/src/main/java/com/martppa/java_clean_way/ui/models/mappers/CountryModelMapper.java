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
package com.martppa.java_clean_way.ui.models.mappers;

import com.martppa.java_clean_way.core.models.Country;
import com.martppa.java_clean_way.ui.models.CountryModel;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

public class CountryModelMapper {

    @Inject
    public CountryModelMapper() {}

    /**
     * Turns a {@link Collection} of {@link Country} into a {@link Collection} of {@link CountryModel} model in
     * Presentation layer.
     *
     * @param countries {@link Collection} of {@link Country} to be transformed
     * @return Transformed {@link Collection} of {@link CountryModel}
     */
    public Collection<CountryModel> transform(Collection<Country> countries) {
        Collection<CountryModel> countriesModels = new ArrayList<>();
        for (Country country : countries) {
            countriesModels.add(transform(country));
        }
        return countriesModels;
    }

    /**
     * Turns a {@link Country} from the data layer into a {@link CountryModel} model in
     * Presentation layer.
     *
     * @param country {@link Country} to be transformed
     * @return Transformed {@link CountryModel}
     */
    public CountryModel transform(Country country) {
        return new CountryModel(country.getName(), country.getIsoCode(), country.getFlagImageUrl());
    }
}
