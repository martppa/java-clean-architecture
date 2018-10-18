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

/**
 * <a href="https://restcountries.eu">RestCountries</a> host's country model
 */
public class RestCountriesCountryModel implements CountryEntity {
    private String name;
    private String alpha2Code;
    private String flag;

    public RestCountriesCountryModel(String name, String alpha2Code, String flagImageUrl) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.flag = flagImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getIsoCode() {
        return alpha2Code;
    }

    public String getFlagImageUrl() {
        return flag;
    }
}
